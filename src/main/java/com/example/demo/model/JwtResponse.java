package com.example.demo.model;

import lombok.Data;

public class JwtResponse {

    private String token;

    private String type = "Bearer ";

    public JwtResponse() {
    }

    public JwtResponse(String token) {
        this.token = type + token;
    }

    public String getToken() {
        return token;
    }
}
