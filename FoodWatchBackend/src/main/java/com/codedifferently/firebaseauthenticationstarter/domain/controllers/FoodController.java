package com.codedifferently.firebaseauthenticationstarter.domain.controllers;

import com.codedifferently.firebaseauthenticationstarter.domain.models.Food;
import com.codedifferently.firebaseauthenticationstarter.domain.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping("/{userId}/newFood")
    public ResponseEntity<String> createFood(@PathVariable Long userId, @RequestBody Food food){
        foodService.newFood(userId,food);
        return new ResponseEntity<>("added "+food.getName()+"with "+food.getCalories()+" calories", HttpStatus.OK);
    }


}
