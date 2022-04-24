package com.codedifferently.firebaseauthenticationstarter.domain.services;

import com.codedifferently.firebaseauthenticationstarter.domain.exception.UserNotFoundException;
import com.codedifferently.firebaseauthenticationstarter.domain.exception.WrongImageType;
import com.codedifferently.firebaseauthenticationstarter.domain.models.Food;
import com.codedifferently.firebaseauthenticationstarter.domain.models.User;
import com.codedifferently.firebaseauthenticationstarter.domain.repos.FoodRepo;
import com.codedifferently.firebaseauthenticationstarter.domain.repos.UserRepo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FoodService {

    @Autowired
    FoodRepo foodRepo;

    @Autowired
    UserRepo userRepo;

    public void newFood(Long userId,Food food){
        foodRepo.save(food);
        User currentUser = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        currentUser.addToSavedFoods(food);
        userRepo.save(currentUser);
    }

    public void removeFoodFromSaved(Long userId,Food food){
        foodRepo.delete(food);
        User currentUser = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        currentUser.removeFromSavedFoods(food);
        userRepo.save(currentUser);
    }

    public int calorie(Map<String, Object> FeedBackStatus) throws JSONException {
        // Works Here trying to replicate
        assert FeedBackStatus != null;
        JSONObject Attempt2 = new JSONObject(FeedBackStatus);
        List<Integer> list = new ArrayList<>();
        JSONArray array = Attempt2.getJSONArray("results");
        for (int i = 0; i < array.length(); i++) {
            //list.add(array.getJSONObject(i).getString("items"));
            JSONArray itemsArray = array.getJSONObject(i).getJSONArray("items");
            //System.out.println(array.getJSONObject(i).getString("items"));
            for (int itemsIndex = 0; itemsIndex < itemsArray.length(); itemsIndex++) {
                JSONObject caloriesObj = new JSONObject(itemsArray.getJSONObject(itemsIndex).getString("nutrition"));
                int calories = caloriesObj.getInt("calories");
                // System.out.println(calories);
                list.add(calories);
            }
        }
        Integer toBeReturned = list.get(0);
        int[] example1 = list.stream().mapToInt(i -> i).toArray();
        int length = example1.length;
        return average(example1, length);
    }

    // Function that return average of an array.
    public int average(int a[], int n) {
        // Find sum of array element
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += a[i];
        return (int) (sum / n);
    }


    public String name(Map<String, Object> FeedBackStatus) throws JSONException {
        assert FeedBackStatus != null;
        JSONObject Attempt2 = new JSONObject(FeedBackStatus);
        List<String> list = new ArrayList<>();
        JSONArray array = Attempt2.getJSONArray("results");
        for (int i = 0; i < array.length(); i++) {
            //list.add(array.getJSONObject(i).getString("items"));
            JSONArray itemsArray = array.getJSONObject(i).getJSONArray("items");
            //System.out.println(array.getJSONObject(i).getString("items"));
            for (int itemsIndex = 0; itemsIndex < itemsArray.length(); itemsIndex++) {
                String caloriesObj = (itemsArray.getJSONObject(itemsIndex).getString("group"));
                //int calories = caloriesObj.getInt("calories");
                // System.out.println(calories);
                list.add(caloriesObj);
            }
        }
        return list.get(0);
    }

}