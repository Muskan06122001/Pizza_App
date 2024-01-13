package com.example.pizzaorder.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO {

    private  String customerEmailId;
    private String customerName;
    private String password;
    private String mobileNo;
    private String address;
}
