package com.example.demo.model;

import lombok.Data;

@Data
public class JwtResponse {

    private String token;

    private String type = "Bearer ";

    public JwtResponse(String token) {
        this.token = type + token;
    }
}
