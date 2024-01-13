package com.example.userauth;

import com.example.userauth.entity.UserDetails;
import com.example.userauth.repository.UserDetailsRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public  class UserAuthRepositoryLayerTest {

	@Autowired
	UserDetailsRepo userDetailsRepo;

	UserDetails userDetails;

	@BeforeEach
	public void setUp(){
		System.out.println("-------------setUp()---------------------");
		userDetails=new UserDetails("Muskann@123","Muskan","Muskan@123","8217821733","abc");

	}

	@AfterEach
	public  void tearDown(){
		System.out.println("--------tearDown()---------------");
//		userDetails=null;
	}

	@Test
	@DisplayName("Test case for saveDetails()")

	public void saveDetailsTest(){
	   UserDetails	userDetails=new UserDetails("Muskann@123","Muskan","Muskan@123","8217821733","abc");

	   userDetailsRepo.save(userDetails);
		UserDetails details = userDetailsRepo.findById(userDetails.getCustomerEmailId()).get();
		assertNotNull(details);
		assertEquals(userDetails.getCustomerEmailId(), details.getCustomerEmailId());

	}
}

