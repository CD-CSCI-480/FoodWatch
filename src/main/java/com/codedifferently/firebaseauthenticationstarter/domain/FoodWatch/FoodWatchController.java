package com.codedifferently.firebaseauthenticationstarter.domain.FoodWatch;
import com.codedifferently.firebaseauthenticationstarter.domain.user.ImageService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FoodWatchController {

//    @Value("${api.key}")
//    private String apiKey;
    ImageService imageService;

    public File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multipart.transferTo(convFile);
        return convFile;
    }
    @RequestMapping(value = "/calories", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
    public ResponseEntity<?> registerBatchUser(@RequestParam("file") MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(new File("/Users/pmmbabittebit19@students.desu.edu/FoodWatch/imgs/foodd.jpeg")));
        stream.write(bytes);
        stream.close();


        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("file", new FileSystemResource(multipartToFile(file,file.getName())));
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");


        Map<String, Object> FeedBackStatus = new HashMap<>();
        FeedBackStatus = new RestTemplate().exchange("https://api-2445582032290.production.gw.apicast.io/v1/foodrecognition?user_key=34e0a1cb16f774eec562ec24d9a3d3ae", HttpMethod.POST, new HttpEntity<MultiValueMap<String, Object>>(parameters, headers), Map.class).getBody();
        return ResponseEntity.ok(FeedBackStatus);

    }
//    @PostMapping
//    public String getIdToken(@RequestBody User user){
//        final String url = "https://www.googleapis.com/identitytoolkit/v3/relyingparty/verifyPassword?key=AIzaSyCRjzt4iwZ0AyCT4pVbKik0DTAvkh1Uj_U";
//
//        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
//        parameters.add("body",user);
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "multipart/form-data");
//
//
//        Map FeedBackStatus = new HashMap<>();
//        FeedBackStatus = new RestTemplate().exchange(url,HttpMethod.POST,new HttpEntity<>(parameters,headers),)
//        RestTemplate restTemplate = new RestTemplate(uri,String.class)
//    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam MultipartFile imageFile){
        String returnValue = "start";
        try {
            imageService.saveImage(imageFile);
            returnValue = "start";
        } catch (IOException e) {
            e.printStackTrace();
            returnValue = "error";
        }
        return returnValue;

    }

//    @RequestMapping("/{foodrecognition}")
//    public Food getFoodInfo(@PathVariable("foodrecognition") String foodrecognition, @RequestParam("file") MultipartFile file) {
//        Food Foodcal = restTemplate.getForObject("https://api-2445582032290.production.gw.apicast.io/v1/",);
//    }


}
