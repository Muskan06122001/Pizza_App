package com.example.pizzaorder.service;

import com.example.pizzaorder.entity.PizzaOrder;
import com.example.pizzaorder.entity.UserDetails;
import com.example.pizzaorder.entity.UserDetailsDTO;
import com.example.pizzaorder.proxy.UserDetailsProxy;
import com.example.pizzaorder.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaOrderService {

    @Autowired
    PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    UserDetailsProxy userDetailsProxy;

    public UserDetails saveDetails(UserDetails userDetails) {
        List<PizzaOrder> order = new ArrayList<>();
        userDetails.setCart(order);
        ResponseEntity details = userDetailsProxy.saveDetails(new UserDetailsDTO(userDetails.getCustomerEmailId(), userDetails.getCustomerName(), userDetails.getPassword(), userDetails.getMobileNo(), userDetails.getAddress()));
        System.out.println(details.getBody());
        return pizzaOrderRepository.save(userDetails);

    }

//    public UserDetails addPizza(String emailId, PizzaOrder pizzaOrder) {
//        UserDetails details = pizzaOrderRepository.findById(emailId).get();
//        if (details != null) {
//            System.out.println("I am in addPizza");
//            List<PizzaOrder> pizza = details.getCart();
//            pizza.add(pizzaOrder);
//            details.setCart(pizza);
//            return pizzaOrderRepository.save(details);
//        } else {
//            return null;
//        }
//    }


    public UserDetails deleteOrder(String emailId, String pizzaName) {
        UserDetails details = pizzaOrderRepository.findById(emailId).get();
        System.out.println("I am in deleteOrder");
        if (details != null) {
            List<PizzaOrder> cart = details.getCart();
            PizzaOrder removePizza = cart.stream().filter(pizza -> pizza.getVarietyOfPizza().equals(pizzaName)).collect(Collectors.toList()).get(0);
            cart.remove(removePizza);
            details.setCart(cart);
            return pizzaOrderRepository.save(details);
        } else {
            return null;
        }

    }


    public List<PizzaOrder> viewCatalogue() {
        String admin = "Admin123@gmail.com";
        UserDetails userDetails = pizzaOrderRepository.findById(admin).get();
        if (userDetails != null) {
            List<PizzaOrder> listOfPizza = userDetails.getCart();
            return listOfPizza;
        } else {
            return null;
        }

    }


    public UserDetails addToCart(String emailId, PizzaOrder pizzaOrder) {
        UserDetails details = pizzaOrderRepository.findById(emailId).get();
        System.out.println("here");
        if (details != null) {
            List<PizzaOrder> details1 = details.getCart();
            details1.add(pizzaOrder);
            details.setCart(details1);
            System.out.println("Done");
            return pizzaOrderRepository.save(details);

        } else {
            return null;
        }
    }

    public List<PizzaOrder> getCart(String emailId) {
        UserDetails details = pizzaOrderRepository.findById(emailId).get();
        if (details != null) {
            List<PizzaOrder> details1 = details.getCart();
            return details1;
        } else {
            return null;
        }
    }

    public PizzaOrder showCard(int pizzaId){

        String admin = "Admin123@gmail.com";
        Optional<UserDetails> details = pizzaOrderRepository.findById(admin);

        if(details.isPresent()){
            UserDetails userDetails=details.get();
            List<PizzaOrder> card =userDetails.getCart();
            System.out.println(card.size());
            Optional<PizzaOrder> getCard=card.stream().filter(pizza ->pizza.getPizzaId()==pizzaId).findFirst();
            if(getCard.isPresent()){
                System.out.println("get list");
                PizzaOrder selectedPizza=getCard.get();
                return selectedPizza;
            }else {
                System.out.println("Not present");
                return null;
            }

        }else {
            return null;
        }

    }

   public String check(){
        return "Hello";
   }

}



//    public UserDetails deleteOrder(String emailId, String pizzaName) {
//        UserDetails details = pizzaOrderRepository.findById(emailId).get();
//        System.out.println("I am in deleteOrder");
//        if (details != null) {
//            List<PizzaOrder> cart = details.getCart();
//            PizzaOrder removePizza = cart.stream().filter(pizza -> pizza.getVarietyOfPizza().equals(pizzaName)).collect(Collectors.toList()).get(0);
//            cart.remove(removePizza);
//            details.setCart(cart);
//            return pizzaOrderRepository.save(details);
//        } else {
//            return null;
//        }
