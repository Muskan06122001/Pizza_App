package com.example.pizzaorder;
import com.example.pizzaorder.entity.PizzaOrder;
import com.example.pizzaorder.entity.UserDetails;
import com.example.pizzaorder.entity.UserDetailsDTO;
import com.example.pizzaorder.proxy.UserDetailsProxy;
import com.example.pizzaorder.repository.PizzaOrderRepository;
import com.example.pizzaorder.service.PizzaOrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import  static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;




@ExtendWith(MockitoExtension.class)
@DataMongoTest
class PizzaOrderServiceTests {

@Mock
   PizzaOrderRepository pizzaOrderRepository;

@InjectMocks
    PizzaOrderService pizzaOrderService;


    UserDetailsProxy userDetailsProxy;

UserDetails userDetails;
PizzaOrder pizzaOrder;

UserDetailsDTO userDetailsDTO;




    @BeforeEach
    public void setUp(){
    System.out.println("I am in @BeforeEach method");
    List<PizzaOrder> listOfPizza=new ArrayList<>();
    pizzaOrder=new PizzaOrder(1,"cheese pizza",200,"Medium");
    listOfPizza.add(pizzaOrder);
    userDetails=new UserDetails("Nisha123@gmail.com","Nisha","Nisha@123","9835363738","sankalp Colony",listOfPizza);
    userDetailsDTO=new UserDetailsDTO("Nisha123@gmail.com","Nisha","Nisha@123","9835363738","sankalp Colony");
       }

      @AfterEach
    public void tearDown() {
          System.out.println("I am in tearDown() method");
          userDetails = null;
      }

    @Test
    @DisplayName("Test case for getCart() method")
    public void getCartTest() {
        String emailId = "Neha123@gmail.com";

        UserDetails userDetails = new UserDetails();
        userDetails.setCart(null);

        when(pizzaOrderRepository.findById(emailId)).thenReturn(Optional.of(userDetails));

        List<PizzaOrder> result = pizzaOrderService.getCart(emailId);
        System.out.println(result);

        assertEquals(null, result);
    }






    @Test
     @DisplayName("Test case for saveDetails()")
    public void saveDetailsTest(){

      when(userDetailsProxy.saveDetails(userDetailsDTO)).thenReturn(new ResponseEntity("Sussessfull", HttpStatus.OK));
      when(pizzaOrderRepository.save(userDetails)).thenReturn(userDetails);
        UserDetails result = pizzaOrderService.saveDetails(userDetails);
        assertEquals(userDetails,result);

    }




    @Test
    @DisplayName("Test case for addPizza()")
    public void addPizzaTest(){
        String emailId = "Muskan0612@gmail.com";

        when(pizzaOrderRepository.findById(emailId)).thenReturn(Optional.of(userDetails));
        when(pizzaOrderRepository.save(userDetails)).thenReturn(userDetails);
        UserDetails result = pizzaOrderService.addToCart(emailId,pizzaOrder);
        assertEquals(userDetails,result);

    }



    @Test
    @DisplayName("Test case for addToCart()")
    public void addToCartTest(){
        String emailId = "Muskan0612@gmail.com";


        ArrayList<PizzaOrder> list=new ArrayList<>();
        UserDetails userDetails = new UserDetails();
        userDetails.setCart(list);

        when(pizzaOrderRepository.findById(emailId)).thenReturn(Optional.of(userDetails));
        when(pizzaOrderRepository.save(userDetails)).thenReturn(userDetails);
        UserDetails result = pizzaOrderService.addToCart(emailId,pizzaOrder);
        assertEquals(userDetails,result);

    }


    @Test
    @DisplayName("Test for viewCatalogue()")
    public void viewCatalogueTest(){
        String admin = "Admin0612@gmail.com";
        when(pizzaOrderRepository.findById(admin)).thenReturn(Optional.of(userDetails));
        List<PizzaOrder> listOfPizza=new ArrayList<>();
        pizzaOrder=new PizzaOrder(1,"cheese pizza",200,"Medium");
        listOfPizza.add(pizzaOrder);


       List<PizzaOrder>  result = pizzaOrderService.viewCatalogue();
        assertEquals(listOfPizza,result);

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
//    @Test
//    @DisplayName("Test case for deleteOrder()")
//    public void deleteOrderTest(){
//        String emailId = "Muskan0612@gmail.com";
//        when(pizzaOrderRepository.findById(emailId)).thenReturn(Optional.of(userDetails));
//        when(pizzaOrderRepository.save(userDetails)).thenReturn(null);
//        PizzaOrder pizzaName=new PizzaOrder();
//        pizzaName.setVarietyOfPizza("Garlic Pizza");
//        List<PizzaOrder> listOfPizza=new ArrayList<>();
//       // pizzaOrder=new PizzaOrder(1,"cheese pizza",200,"Medium");
//        listOfPizza.add(pizzaName);
//        listOfPizza.remove(pizzaName);
//        PizzaOrder  result = pizzaOrderService.deleteOrder(emailId,pizzaName);
//

}
