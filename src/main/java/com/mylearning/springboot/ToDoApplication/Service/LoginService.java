package com.mylearning.springboot.ToDoApplication.Service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean authenticate(String userName,String password){
        return userName.equalsIgnoreCase("Dinesh") && password.equalsIgnoreCase("28111997");
    }
}
