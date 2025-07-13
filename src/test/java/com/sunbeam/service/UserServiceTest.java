package com.sunbeam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sunbeam.dto.UserRespDTO;

@SpringBootTest //scans all components - controller , service , dao
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testGetAllUsersByCity() {
		List<UserRespDTO> users = userService.getAllUsersByCity("Pune");
		assertEquals(4, users.size());
	}
}
