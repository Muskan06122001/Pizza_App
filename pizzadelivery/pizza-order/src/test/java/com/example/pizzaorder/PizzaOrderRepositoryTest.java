package com.example.pizzaorder;

import com.example.pizzaorder.entity.PizzaOrder;
import com.example.pizzaorder.entity.UserDetails;
import com.example.pizzaorder.entity.UserDetailsDTO;
import com.example.pizzaorder.repository.PizzaOrderRepository;
import com.example.pizzaorder.service.PizzaOrderService;
import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


import static com.mongodb.assertions.Assertions.assertNotNull;
import  static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class PizzaOrderRepositoryTest {

    @Autowired
    PizzaOrderRepository pizzaOrderRepository;
    PizzaOrder pizzaOrder;
    UserDetails userDetails;

    List<PizzaOrder> listOfPizza = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        System.out.println("I am in BeforeEach() method");

        pizzaOrder = new PizzaOrder(1, "cheese pizza", 200, "Medium");
        listOfPizza.add(pizzaOrder);
        userDetails = new UserDetails("Nisha123@gmail.com", "Nisha", "Nisha@123", "9835363738", "sankalp Colony", listOfPizza);

    }

    @AfterEach
    public void testDown() {
        System.out.println("I am in tearDown() method");
        userDetails = null;

    }

//    public UserDetails saveDetails(UserDetails userDetails) {
//        List<PizzaOrder> order = new ArrayList<>();
//        userDetails.setCart(order);
//        ResponseEntity details = userDetailsProxy.saveDetails(new UserDetailsDTO(userDetails.getCustomerEmailId(), userDetails.getCustomerName(), userDetails.getPassword(), userDetails.getMobileNo(), userDetails.getAddress()));
//        System.out.println(details.getBody());
//        return pizzaOrderRepository.save(userDetails);
//
//    }

    @Test
    @DisplayName("Test case to save UserDetails")
    public void saveDetails() {

        List<PizzaOrder> list = new ArrayList<>();
        userDetails.setCart(list);
        pizzaOrderRepository.save(userDetails);
        UserDetails details = pizzaOrderRepository.findById(userDetails.getCustomerEmailId()).get();
        assertNotNull(details);
        assertEquals(userDetails.getCustomerEmailId(), details.getCustomerEmailId());
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

    @Test
    @DisplayName("Test case for addPizza()")
    public void addPizzaTest() {

        List<PizzaOrder> pizzaList = new ArrayList<>();

        PizzaOrder pizzaOrder = new PizzaOrder();
        UserDetails userDetails = new UserDetails();
        pizzaOrder = new PizzaOrder(1, "cheese pizza", 200, "Medium");
        pizzaList.add(pizzaOrder);
        userDetails = new UserDetails("Nisha123@gmail.com", "Nisha", "Nisha@123", "9835363738", "sankalp Colony", pizzaList);

        pizzaOrderRepository.save(userDetails);
        UserDetails details = pizzaOrderRepository.findById("Nisha123@gmail.com").orElse(null);
        assertTrue(details.getCart().contains(pizzaOrder));

    }

//    public List<PizzaOrder> viewCatalogue() {
//        String admin = "Admin0612@gmail.com";
//        UserDetails userDetails = pizzaOrderRepository.findById(admin).get();
//        if (userDetails != null) {
//            List<PizzaOrder> listOfPizza = userDetails.getCart();
//            return listOfPizza;
//        } else {
//            return null;
//        }
//
//    }

    @Test
    @DisplayName("Test case for viewCatalogue()")
    public void viewCatalogue(){
        String admin = "Admin0612@gmail.com";
        PizzaOrder pizzaOrder1=new PizzaOrder();
        List<PizzaOrder> listOfPizza=new ArrayList<>();
        pizzaOrder1 = new PizzaOrder(1, "cheese pizza", 200, "Medium");
        listOfPizza.add(pizzaOrder1);
        UserDetails userDetails1=new UserDetails("Admin0612@gmail.com","Admin","Admin@123","7383838383","Admin",listOfPizza);

        pizzaOrderRepository.save(userDetails1);
        UserDetails details=pizzaOrderRepository.findById(admin).orElse(null);
        assertTrue(details.getCart().contains(pizzaOrder1));
    }


//    public UserDetails addToCart(String emailId, PizzaOrder pizzaOrder) {
//        UserDetails details = pizzaOrderRepository.findById(emailId).get();
//        System.out.println("here");
//        if (details != null) {
//            List<PizzaOrder> details1 = details.getCart();
//            details1.add(pizzaOrder);
//            details.setCart(details1);
//            System.out.println("Done");
//            return pizzaOrderRepository.save(details);
//
//        } else {
//            return null;
//        }
//    }

    @Test
    @DisplayName("Test case for addToCart()")
    public void addToCartTest(){

        String admin = "Muskann0612@gmail.com";
        PizzaOrder pizzaOrder1=new PizzaOrder();
        List<PizzaOrder> listOfPizza=new ArrayList<>();
        pizzaOrder1 = new PizzaOrder(1, "cheese pizza", 200, "Medium");
        listOfPizza.add(pizzaOrder1);
        UserDetails userDetails1=new UserDetails("Muskann0612@gmail.com","Admin","Admin@123","7383838383","Admin",listOfPizza);

        pizzaOrderRepository.save(userDetails1);
        UserDetails details=pizzaOrderRepository.findById(admin).orElse(null);
        assertTrue(details.getCart().contains(pizzaOrder1));


    }

//    public List<PizzaOrder> getCart(String emailId) {
//        UserDetails details = pizzaOrderRepository.findById(emailId).get();
//        if (details != null) {
//            List<PizzaOrder> details1 = details.getCart();
//            return details1;
//        } else {
//            return null;
//        }
//    }

    @Test
    @DisplayName("Test case for getCart()")
    public void getCartTest(){
        String admin = "Neha0612@gmail.com";
        PizzaOrder pizzaOrder1=new PizzaOrder();
        PizzaOrder pizzaOrder2=new PizzaOrder();
        List<PizzaOrder> listOfPizza=new ArrayList<>();
        pizzaOrder1 = new PizzaOrder(1, "cheese pizza", 200, "Medium");
        pizzaOrder2 = new PizzaOrder(2, "Garlic pizza", 300, "Medium");

        listOfPizza.add(pizzaOrder1);
        listOfPizza.add(pizzaOrder2);
        UserDetails userDetails1=new UserDetails("Neha0612@gmail.com","Admin","Admin@123","7383838383","Admin",listOfPizza);

        pizzaOrderRepository.save(userDetails1);
        UserDetails details=pizzaOrderRepository.findById(admin).orElse(null);
        assertTrue(details.getCart().contains(pizzaOrder1));
        assertTrue(details.getCart().contains(pizzaOrder2));

    }

//    public PizzaOrder showCard(int pizzaId){
//
//        String admin = "Admin0612@gmail.com";
//        Optional<UserDetails> details = pizzaOrderRepository.findById(admin);
//
//        if(details.isPresent()){
//            UserDetails userDetails=details.get();
//            List<PizzaOrder> card =userDetails.getCart();
//            System.out.println(card.size());
//            Optional<PizzaOrder> getCard=card.stream().filter(pizza ->pizza.getPizzaId()==pizzaId).findFirst();
//            if(getCard.isPresent()){
//                System.out.println("get list");
//                PizzaOrder selectedPizza=getCard.get();
//                return selectedPizza;
//            }else {
//                System.out.println("Not present");
//                return null;
//            }
//
//        }else {
//            return null;
//        }

    @Test
    @DisplayName("Test case for showCard()")
    public void showCardTest(){
        String admin = "Admin123@gmail.com";
        PizzaOrder pizzaOrder1=new PizzaOrder();
        PizzaOrder pizzaOrder2=new PizzaOrder();
        List<PizzaOrder> listOfPizza=new ArrayList<>();
        pizzaOrder1 = new PizzaOrder(1, "cheese pizza", 200, "Medium");
        pizzaOrder2 = new PizzaOrder(2, "Garlic pizza", 300, "Medium");

        listOfPizza.add(pizzaOrder1);
        listOfPizza.add(pizzaOrder2);
        UserDetails userDetails1=new UserDetails("Admin123@gmail.com","Admin","Admin@123","7383838383","Admin",listOfPizza);

        pizzaOrderRepository.save(userDetails1);
        UserDetails details=pizzaOrderRepository.findById(admin).orElse(null);
        assertTrue(details.getCart().contains(pizzaOrder1));
        assertTrue(details.getCart().contains(pizzaOrder2));
    }



    }
