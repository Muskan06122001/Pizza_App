package com.example.pizzaorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserDetails
{

    @Id
    private String customerEmailId;
    private String customerName;
    private String password;
    private String mobileNo;
    private String address;

    List<PizzaOrder> cart ;

}
