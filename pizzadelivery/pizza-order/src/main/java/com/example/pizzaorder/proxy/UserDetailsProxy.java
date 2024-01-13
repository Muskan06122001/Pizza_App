package com.example.pizzaorder.proxy;


import com.example.pizzaorder.entity.UserDetails;
import com.example.pizzaorder.entity.UserDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Userauthentication",url = "http://localhost:8083")
public interface UserDetailsProxy {

@PostMapping("/api/v1/user")
    public ResponseEntity<UserDetails> saveDetails(@RequestBody UserDetailsDTO userDetails);

}
