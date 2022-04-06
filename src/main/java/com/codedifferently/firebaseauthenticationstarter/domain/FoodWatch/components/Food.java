package com.codedifferently.firebaseauthenticationstarter.domain.FoodWatch.components;

import org.springframework.stereotype.Component;

@Component
public class Food {
    Long id;
    int calorie;
    int goal;
    String pictureUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }
}
