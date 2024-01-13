package com.example.pizzaorder.repository;

import com.example.pizzaorder.entity.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaOrderRepository extends MongoRepository<UserDetails,String > {

}
