package com.codedifferently.firebaseauthenticationstarter.domain.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

@Service
public class ImageService {
    public ImageService() {
    }

    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "/foodWatchImages";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    public MultipartFile resizeImage(MultipartFile file) throws IOException, InterruptedException {
        BufferedImage image= ImageIO.read(file.getInputStream());
        if(image.getWidth() < 544 && image.getHeight() <544){
            return file;
        }
       // image.get
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://image-processing4.p.rapidapi.com/imageresize&width=544&height=544"))
//                .header("X-RapidAPI-Host", "image-processing4.p.rapidapi.com")
//                .header("X-RapidAPI-Key", "e44382f4c7msh9dcfe7b3513e5dep176903jsnbeec4a500a26")
//                .header("Content-Type", "multipart/form-data")
//                .method("GET", HttpRequest.BodyPublishers.)
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

//        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap();
//        parameters.add("file", new FileSystemResource(this.multipartToFile(file, file.getName())));
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "multipart/form-data");
//        headers.set("X-RapidAPI-Key", "e44382f4c7msh9dcfe7b3513e5dep176903jsnbeec4a500a26");
//        new HashMap();
//        Map<String, Object> FeedBackStatus = (Map)(new RestTemplate()).exchange("https://image-processing4.p.rapidapi.com/imageresize&width=544&height=544", HttpMethod.GET, new HttpEntity(parameters, headers), Map.class);
//        System.out.println(ResponseEntity.ok(FeedBackStatus));

        return  file;

    }
    public File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        String var10002 = System.getProperty("java.io.tmpdir");
        File convFile = new File(var10002 + "/" + fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

    public MultipartFile convertImage(MultipartFile file) throws IOException, InterruptedException {
        if(Objects.equals(file.getOriginalFilename().split("\\.")[1], "jpeg")){
            return file;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://image-processing4.p.rapidapi.com/imageconvert?imageUrl=https%3A%2F%2Fcodingforum.site%2Fimg%2Flogo.png&outputType=jpeg"))
                .header("X-RapidAPI-Host", "image-processing4.p.rapidapi.com")
                .header("X-RapidAPI-Key", "798cf2bea4mshc19ae4bf2271c7ep1c6e1fjsnc8ca26eb6956")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return file;
    }
    private byte[] downloadPicture(String url){

        URL urlConnection = null;
        HttpURLConnection httpURLConnection = null;
        try {

            urlConnection = new URL(url);
            httpURLConnection = (HttpURLConnection) urlConnection.openConnection();
            InputStream in = httpURLConnection.getInputStream();
// Use available() Method to get the data length
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();
            return data;
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            httpURLConnection.disconnect();
        }
        return null;
    }
}
