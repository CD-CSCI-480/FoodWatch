package com.codedifferently.firebaseauthenticationstarter.domain.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String email;
    private String password;

    @OneToMany
    private List<Food> savedFoods;

    @OneToMany
    private List<Food> foodHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Food> getSavedFoods() {
        return savedFoods;
    }

    public void addToSavedFoods(Food food){
        savedFoods.add(food);
    }

    public void removeFromSavedFoods(Food food){
        savedFoods.remove(food);
    }
    public void clearSavedFoods(){
        savedFoods.clear();
    }

    public void setSavedFoods(List<Food> savedFoods) {
        this.savedFoods = savedFoods;
    }

    public List<Food> getFoodHistory() {
        return foodHistory;
    }

    public void setFoodHistory(List<Food> foodHistory) {
        this.foodHistory = foodHistory;
    }
}
