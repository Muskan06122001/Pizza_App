package com.example.userauth.service;

import com.example.userauth.entity.UserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {

    @Override
    public Map<String, String> generateToken(UserDetails userDetails) {

        //here we are creating a token which is of a map type where key and value both will be string
        //In this map object we can store our token values which will be sent to client
        Map<String, String> tokenMap = new HashMap<String, String>();

        //here e can store the userDetailsInfo
        Map<String, Object> userDetailInfo = new HashMap<>();
        userDetailInfo.put("customerEmailId", userDetails.getCustomerEmailId());

        //In the below code we are creating a token string using Jwts object by setting the claim,date and signature
        String jwtTokenString = Jwts.builder().setClaims(userDetailInfo).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS512, "jwtkey").compact();

        //tokenMap object storing the JwtTokenString and a message
        tokenMap.put("token", jwtTokenString);
        tokenMap.put("message", "Login Successful");

        return tokenMap;
    }
}
