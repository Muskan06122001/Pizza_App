package com.example.userauth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDetails {

    @Id
    private  String customerEmailId;
    private String customerName;
    private String password;
    private String mobileNo;
    private String address;

}
