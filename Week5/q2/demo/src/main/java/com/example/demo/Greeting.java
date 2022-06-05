package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Greeting {
    public String getMessage(){
        return "Hello";
    }
}
