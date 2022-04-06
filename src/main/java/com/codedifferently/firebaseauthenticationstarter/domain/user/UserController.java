//package com.codedifferently.firebaseauthenticationstarter.domain.user;
//
//import com.codedifferently.firebaseauthenticationstarter.security.models.FireBaseUser;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.http.*;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class UserController {
//    @Autowired
//
//    ImageService imageService;
//    private static Logger logger = LoggerFactory.getLogger(UserController.class);
//    @GetMapping("/me")
//    public ResponseEntity<FireBaseUser> getUserInfo(@AuthenticationPrincipal FireBaseUser user) {
//        user.setName("Pride");
//        logger.info("A request was made by user with id {} and email {}",user.getUid(), user.getUid());
//        return ResponseEntity.ok(user);
//    }
//
//    public void getIdToken(User user){}
//    @PostMapping("/uploadImage")
//    public String uploadImage(@RequestParam MultipartFile imageFile){
//        String returnValue = "start";
//        try {
//            imageService.saveImage(imageFile);
//            returnValue = "start";
//        } catch (IOException e) {
//            e.printStackTrace();
//            returnValue = "error";
//        }
//    return returnValue;
//    }
//
//    public  File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
//        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
//        multipart.transferTo(convFile);
//        return convFile;
//    }
//    @RequestMapping(value = "/calories", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
//    public ResponseEntity<?> registerBatchUser(@RequestParam("file") MultipartFile file) throws IOException {
//
//            byte[] bytes = file.getBytes();
//            BufferedOutputStream stream = new BufferedOutputStream(
//                    new FileOutputStream(new File("/Users/pmmbabittebit19@students.desu.edu/FoodWatch/imgs/foodd.jpeg")));
//            stream.write(bytes);
//            stream.close();
//
//
//            MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
//            parameters.add("file", new FileSystemResource(multipartToFile(file,file.getName())));
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Content-Type", "multipart/form-data");
//
//
//            Map<String, Object> FeedBackStatus = new HashMap<>();
//            FeedBackStatus = new RestTemplate().exchange("https://api-2445582032290.production.gw.apicast.io/v1/foodrecognition?user_key=34e0a1cb16f774eec562ec24d9a3d3ae", HttpMethod.POST, new HttpEntity<MultiValueMap<String, Object>>(parameters, headers), Map.class).getBody();
//            return ResponseEntity.ok(FeedBackStatus);
//
//        }
//
//}
