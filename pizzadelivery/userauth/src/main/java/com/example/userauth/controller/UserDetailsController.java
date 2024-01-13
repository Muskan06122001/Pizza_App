package com.example.userauth.controller;

import com.example.userauth.entity.UserDetails;
import com.example.userauth.service.SecurityTokenGeneratorImpl;
import com.example.userauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserDetailsController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityTokenGeneratorImpl securityTokenGeneratorImpl;

    @GetMapping("/check1")
    public String check(){
        return "Successful";
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveDetails(@RequestBody UserDetails userDetails){
     UserDetails userDetails1=userService.saveDetails(userDetails);
     if(userDetails1!=null){
         return new ResponseEntity<>(userDetails1, HttpStatus.OK);
     }else {
         return new ResponseEntity("Error Occured",HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping("/userAuth")
    public ResponseEntity<?> userAuthentication(@RequestBody UserDetails userDetails){
        UserDetails userDetails1 = userService.checkAuthentication(userDetails);
        if(userDetails1!=null){
            return new ResponseEntity<>(securityTokenGeneratorImpl.generateToken(userDetails1),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Error Occured",HttpStatus.NOT_FOUND);
        }
    }


}
