package com.example.pizzaorder;
import com.example.pizzaorder.controller.PizzaOrderController;
import com.example.pizzaorder.entity.PizzaOrder;
import com.example.pizzaorder.entity.UserDetails;
import com.example.pizzaorder.service.PizzaOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
public class PizzaOrderControllerLayerTest {


    @Autowired
    MockMvc mockMvc;

    @Mock
    PizzaOrderService pizzaOrderService;

    @InjectMocks
    PizzaOrderController pizzaOrderController;

    UserDetails userDetails;
    PizzaOrder pizzaOrder;

    List<PizzaOrder> listOfPizza=new ArrayList<>();

    @BeforeEach
    public void setUp() {
        System.out.println("I am in BeforeEach() method");

        pizzaOrder = new PizzaOrder(1, "cheese pizza", 200, "Medium");
        listOfPizza.add(pizzaOrder);
        userDetails = new UserDetails("Nisha123@gmail.com", "Nisha", "Nisha@123", "9835363738", "sankalp Colony", listOfPizza);
        mockMvc= MockMvcBuilders.standaloneSetup(pizzaOrderController).build();

    }

    @AfterEach
    public void testDown() {
        System.out.println("I am in tearDown() method");
        userDetails = null;

    }

    @Test
    public void saveCustomerDetailsTest() throws Exception {


        when(pizzaOrderService.saveDetails(any())).thenReturn(userDetails);

        mockMvc.perform(
                post("/api/v2/saveDetails").contentType(MediaType.APPLICATION_JSON).content(jsonToString(userDetails))
        ).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

        verify(pizzaOrderService,times(1)).saveDetails(any());
    }

    @Test
    public void saveCustomerDetailsTestFailure() throws Exception {

        mockMvc.perform(
                post("/api/v2/saveDetails").contentType(MediaType.APPLICATION_JSON).content(jsonToString(userDetails))
        ).andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());

        verify(pizzaOrderService,times(1)).saveDetails(any());
    }


    @Test
    public void addToCartTestFailure() throws Exception {

        mockMvc.perform(
                post("/api/v2/addToCart").contentType(MediaType.APPLICATION_JSON).content(jsonToString(userDetails))
        ).andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());

    }

@Test
public void viewCatalogue() throws Exception {

    List<PizzaOrder> PizzaList = new ArrayList<>();
    PizzaList.add(new PizzaOrder());

    when(pizzaOrderService.viewCatalogue()).thenReturn(PizzaList);

    mockMvc.perform(
                    get("/api/v2/viewCatalogue").contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(content().json(jsonToString(PizzaList)))
            .andDo(MockMvcResultHandlers.print());

    verify(pizzaOrderService, times(1)).viewCatalogue();
}


    public static  String jsonToString(final  Object obj){
            String javaObjectToJson;
            try{
                //ObjectMapper class will convert our java obj to String using the method called writeValueAsString
                ObjectMapper mapper=new ObjectMapper();
                //writeValueAsString() method takes a java obj return the String version of json of that obj
                String jsonContent=mapper.writeValueAsString(obj);
                javaObjectToJson=jsonContent;
                System.out.println("===================================");
                System.out.println(javaObjectToJson);
            }catch(JsonProcessingException je){
                javaObjectToJson="Json Processing Error";
            }
            return javaObjectToJson;
        }
    }

