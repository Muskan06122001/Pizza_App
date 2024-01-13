package com.example.userauth.service;

import com.example.userauth.entity.UserDetails;
import com.example.userauth.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDetailsRepo userDetailsRepo;


    public UserDetails saveDetails(UserDetails userDetails){
     return userDetailsRepo.save(userDetails);
    }

    public UserDetails checkAuthentication(UserDetails userDetails){
      Optional<UserDetails> userDetails1 = userDetailsRepo.findById(userDetails.getCustomerEmailId());
      if(userDetails1.isPresent()){
          UserDetails user=userDetails1.get();
          if(user.getCustomerEmailId().equals(userDetails.getCustomerEmailId())){
              return  user;
          }else {
              return null;
          }
      }else {
          return null;
      }

    }
}
