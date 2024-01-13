package com.example.userauth.service;

import com.example.userauth.entity.UserDetails;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String ,String> generateToken(UserDetails userDetails);
}
