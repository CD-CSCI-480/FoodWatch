package com.codedifferently.firebaseauthenticationstarter.domain.services;

import com.codedifferently.firebaseauthenticationstarter.domain.exception.UserNotFoundException;
import com.codedifferently.firebaseauthenticationstarter.domain.models.Food;
import com.codedifferently.firebaseauthenticationstarter.domain.models.User;
import com.codedifferently.firebaseauthenticationstarter.domain.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void save(User user){
        userRepo.save(user);
    }

    public void clearUserSaved(Long userId){
        User currentUser = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        currentUser.clearSavedFoods();
        userRepo.save(currentUser);
    }
    public List<Food> getUserSaved(Long userId){
        User currentUser = userRepo.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        return currentUser.getSavedFoods();
    }
}
