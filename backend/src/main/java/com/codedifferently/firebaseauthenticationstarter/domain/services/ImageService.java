package com.codedifferently.firebaseauthenticationstarter.domain.services;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import com.codedifferently.firebaseauthenticationstarter.domain.controllers.UserController;
import marvin.image.MarvinImage;
import org.marvinproject.image.transform.scale.Scale;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ImageService {
    public ImageService() {
    }
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    public void saveImage(MultipartFile imageFile) throws IOException {
        String folder = "/foodWatchImages";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    public BufferedImage scaleDown(BufferedImage sourceImage, int targetWidth, int targetHeight) {

        int sourceWidth  = sourceImage.getWidth();
        int sourceHeight = sourceImage.getHeight();
        BufferedImage targetImage = new BufferedImage(targetWidth, targetHeight, sourceImage.getType());
        Graphics2D g = targetImage.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(sourceImage, 0, 0, targetWidth, targetHeight, 0, 0, sourceWidth, sourceHeight, null);
        g.dispose();
        return targetImage;
    }

    public File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        String var10002 = System.getProperty("java.io.tmpdir");
        File convFile = new File(var10002 + "/" + fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

    public BufferedImage convertImage(BufferedImage image,String fileType) throws IOException{

        if(Objects.equals(fileType,"jpeg")){
            return image;
  }

        final BufferedImage convertedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            convertedImage.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);

            final FileOutputStream fileOutputStream = new FileOutputStream("dice-test.jpeg");
            final boolean canWrite = ImageIO.write(convertedImage, "jpeg", fileOutputStream);
            fileOutputStream.close(); // ImageIO.write does not close the output stream
            if (!canWrite) {
                throw new IllegalStateException("Failed to write image.");
            }
        logger.info("file size = {} x {}, type = {}",image.getWidth(), image.getHeight(), fileType);

        return  convertedImage ;
    }
    public MultipartFile imageToFile(BufferedImage image) throws IOException {
        //ByteArrayOutputStream
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //BufferedImage ByteArrayOutputStream
        ImageIO.write(image, "jpeg", os);
        //ByteArrayOutputStream InputStream
        InputStream input = new ByteArrayInputStream(os.toByteArray());
        //InputStream MultipartFile
        MultipartFile file =new MockMultipartFile("file", "file.jpeg", "text/plain", input);
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
