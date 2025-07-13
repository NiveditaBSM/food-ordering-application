package com.sunbeam.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.sunbeam.entities.User;

@DataJpaTest //=> DAO layer testing + entities
@AutoConfigureTestDatabase(replace = Replace.NONE) //=> continue with app DB 
class UserDaoTest {
	//depcy 
	@Autowired
	private UserDao userDao;

	@Test//=> test case | method
	void testFindByEmailAndPassword() {
		Optional<User> optional = 
				userDao.findByEmailAndPassword("anju.rider@zmail.com",
						"Anju@1234");
		assertEquals(false, optional.isEmpty());
		
	}

}
