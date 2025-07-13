package com.sunbeam.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sunbeam.entities.Restaurant;
import com.sunbeam.entities.User;

@DataJpaTest //=> DAO layer testing + entities
@AutoConfigureTestDatabase(replace = Replace.NONE) //=> continue with app DB 
class RestaurantDaoTest {
	//depcy 
	@Autowired
	private RestaurantDao dao;

	@Test//=> test case | method
	void testFetchCompleteDetails() {
		Restaurant restaurant = dao.fetchCompleteDetails(2l);
		assertEquals(2,restaurant.getFoodItems().size());
		
	}

}
