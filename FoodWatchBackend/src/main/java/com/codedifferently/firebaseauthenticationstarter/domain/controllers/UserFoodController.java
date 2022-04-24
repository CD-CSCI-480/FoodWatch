package com.codedifferently.firebaseauthenticationstarter.domain.controllers;

import com.codedifferently.firebaseauthenticationstarter.domain.models.Food;
import com.codedifferently.firebaseauthenticationstarter.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserFoodController {

    @Autowired
    UserService userService;
    @DeleteMapping("/{userId}/clearSaveFood")
    public ResponseEntity<String> clearSavedFood(@PathVariable Long userId){
        userService.clearUserSaved(userId);
        return new ResponseEntity<>("cleared "+userId+" saved foods ", HttpStatus.OK);
    }

   // public ResponseEntity<String> getFood(@PathVariable Long )

    @GetMapping("/{userId}/getSaveFood")
    public List<Food> getSavedFood(@PathVariable Long userId){
       return userService.getUserSaved(userId);
    }



}
