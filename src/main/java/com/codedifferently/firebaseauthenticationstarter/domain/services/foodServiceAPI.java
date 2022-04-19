package com.codedifferently.firebaseauthenticationstarter.domain.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class foodServiceAPI {

    public void foodServiceAPIFUNCTION(Map<String, Object> FeedBackStatus){
        System.out.println(FeedBackStatus);
        System.out.println(FeedBackStatus.get("results"));
        System.out.println(" FOR SPACING PURPOSES ");
        //holdingValues = FeedBackStatus.get("results")["items"];
//
//

    }
//
//    public ResponseEntity<?> getCalories(@RequestParam("file") MultipartFile file) throws IOException {
////        byte[] bytes = file.getBytes();
////        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("/Users/gjbarnes19@students.desu.edu/FoodWatch/imgs/foodd.jpeg")));
////        stream.write(bytes);
////        stream.close();
//        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap();
//        parameters.add("file", new FileSystemResource(this.multipartToFile(file, file.getName())));
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "multipart/form-data");
//        new HashMap();
//        JsonNode FeedBackStatus = (new RestTemplate()).exchange("https://api-2445582032290.production.gw.apicast.io/v1/foodrecognition?user_key=34e0a1cb16f774eec562ec24d9a3d3ae", HttpMethod.POST, new HttpEntity(parameters, headers), JsonNode.class, new Object[0]).getBody();
//        foodServiceAPI.foodServiceAPIFUNCTION(FeedBackStatus);
//        //holdingValues = FeedBackStatus.get("results")["items"];
//
//        return ResponseEntity.ok(FeedBackStatus);
//    }
    // Taking what is returned, dividing it up, and randomizing



}