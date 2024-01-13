package com.example.pizzaorder.controller;
import com.example.pizzaorder.entity.PizzaOrder;
import com.example.pizzaorder.entity.UserDetails;
import com.example.pizzaorder.service.PizzaOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api/v2")
public class  PizzaOrderController {

    @Autowired
    PizzaOrderService pizzaOrderService;


    @GetMapping("/test")
    public String test(){
        return "successful";

    }
    @GetMapping("/check")
    public String check(){
        String test= pizzaOrderService.check();
        return test;
    }

    @PostMapping("/saveDetails")
    public  ResponseEntity<?> saveCustomerDetails(@RequestBody UserDetails userDetails){
      UserDetails details = pizzaOrderService.saveDetails(userDetails);
      if(details!=null){
          return new ResponseEntity<>(details,HttpStatus.OK);
      }else {
          return new ResponseEntity<>("Error Occured",HttpStatus.NOT_FOUND);
      }
    }

//    @PostMapping("/addPizza")
//    public ResponseEntity<?> addPizza(HttpServletRequest httpServletRequest, @RequestBody PizzaOrder pizzaOrder){
//        String email =(String) httpServletRequest.getAttribute("customerEmailId");
//        System.out.println(email);
//        if(email!=null){
//            return new ResponseEntity<>(pizzaOrderService.addPizza(email,pizzaOrder), HttpStatus.OK);
//        }
//       else {
//           return new ResponseEntity<>("Error Occured",HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(HttpServletRequest httpServletRequest,@RequestBody PizzaOrder pizzaOrder ){
        String email = (String) httpServletRequest.getAttribute("customerEmailId");
        System.out.println(email);
        System.out.println("Hey ");
        if(email!=null){
            System.out.println("Controler ");
            return  new ResponseEntity<>(pizzaOrderService.addToCart(email,pizzaOrder),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error Occured",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cancelOrder/{Pizza}")
    public ResponseEntity<?> deletePizzaOrder(HttpServletRequest httpServletRequest,@PathVariable  String Pizza){
        String email= (String) httpServletRequest.getAttribute("customerEmailId");
        System.out.println(email);
        if(email!=null){
            return new ResponseEntity<>(pizzaOrderService.deleteOrder(email,Pizza),HttpStatus.OK);

        }else {
            return new ResponseEntity<>("Error Occured",HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/showCatalogue")
//    public ResponseEntity<?> showCatalogue(HttpServletRequest httpServletRequest){
//        String email=(String) httpServletRequest.getAttribute("customerEmailId");
//        if(email!=null){
//            return new ResponseEntity<>(pizzaOrderService.getCatalogue(email),HttpStatus.OK);
//
//        }else {
//            return new ResponseEntity<>("Error Occured",HttpStatus.NOT_FOUND);
//
//        }
//    }

    @GetMapping("/viewCatalogue")
    public ResponseEntity<?> showCatalogue(){

        List<PizzaOrder> listOfPizza=pizzaOrderService.viewCatalogue();
        if(listOfPizza!=null){
            return new ResponseEntity<>(listOfPizza,HttpStatus.OK);
        }else {
            return null;
        }
    }


    @GetMapping("/showCart")
    public ResponseEntity<?> showCart(HttpServletRequest httpServletRequest){
        String email = (String) httpServletRequest.getAttribute("customerEmailId");
        System.out.println("Helo");
        if(email!=null){
            System.out.println("Complete ss");
            return new ResponseEntity<>(pizzaOrderService.getCart(email),HttpStatus.OK);
        }else {
            System.out.println("Complete");
            return new ResponseEntity<>("Error Occured",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/showCard/{pizzaId}")
    public ResponseEntity<?> showCard(@PathVariable int pizzaId) {
        List<PizzaOrder> listOfPizza=pizzaOrderService.viewCatalogue();
        if(listOfPizza!=null){
            System.out.println("hii");
            return new ResponseEntity<>(pizzaOrderService.showCard(pizzaId),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error Occured",HttpStatus.NOT_FOUND);
        }
    }
}



