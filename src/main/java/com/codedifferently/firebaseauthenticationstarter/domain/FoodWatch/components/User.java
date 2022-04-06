package com.codedifferently.firebaseauthenticationstarter.domain.FoodWatch.components;

import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Component
public class User {

    @Id
    Long id;

    int password;
    String email;
    String userName;

    public boolean confirmPassword(String password, String otherPass){
        char[] passwordArr = password.toCharArray();
        char[] otherPassArr = otherPass.toCharArray();
        for (int i = 0; i < passwordArr.length; i++) {
            if(passwordArr[i] == otherPassArr[i]){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
