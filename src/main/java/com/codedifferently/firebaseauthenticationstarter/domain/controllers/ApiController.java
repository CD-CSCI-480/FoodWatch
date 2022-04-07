package com.codedifferently.firebaseauthenticationstarter.domain.controllers;

import com.codedifferently.firebaseauthenticationstarter.domain.services.ImageService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.codedifferently.firebaseauthenticationstarter.domain.user.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ApiController {
    ImageService imageService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    public ApiController() {
    }

    public File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        String var10002 = System.getProperty("java.io.tmpdir");
        File convFile = new File(var10002 + "/" + fileName);
        multipart.transferTo(convFile);
        return convFile;
    }

    /**
     * post image to Calorie Mama Api and retrieve it's data
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(
            value = {"/calories"},
            produces = {"application/json"},
            method = {RequestMethod.POST}
    )
    public ResponseEntity<?> getCalories(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("/Users/pmmbabittebit19@students.desu.edu/FoodWatch/imgs/foodd.jpeg")));
        stream.write(bytes);
        stream.close();
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap();
        parameters.add("file", new FileSystemResource(this.multipartToFile(file, file.getName())));
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");
        new HashMap();
        Map<String, Object> FeedBackStatus = (Map)(new RestTemplate()).exchange("https://api-2445582032290.production.gw.apicast.io/v1/foodrecognition?user_key=34e0a1cb16f774eec562ec24d9a3d3ae", HttpMethod.POST, new HttpEntity(parameters, headers), Map.class, new Object[0]).getBody();
        return ResponseEntity.ok(FeedBackStatus);
    }

    @PostMapping({"/uploadImage"})
    public String uploadImage(@RequestParam MultipartFile imageFile) {
        String returnValue = "start";

        try {
            this.imageService.saveImage(imageFile);
            returnValue = "start";
        } catch (IOException var4) {
            var4.printStackTrace();
            returnValue = "error";
        }

        return returnValue;
    }
}

