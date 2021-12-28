package com.example.demo.service.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private String secretCode = "123456789";

    private Long expireTime = 36000L;

    public String createTokenLogin(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expireTime))
                .signWith(SignatureAlgorithm.HS512, secretCode)
                .compact();
        return token;
    }

    public String getUsernameByToken(String token) {
        String username = Jwts.parser()
                .setSigningKey(secretCode)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return username;
    }
}
