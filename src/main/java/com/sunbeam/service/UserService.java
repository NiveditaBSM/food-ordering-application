package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserRequestDTO;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.User;

public interface UserService {
//sign in
	UserRespDTO authenticate(AuthRequest dto);

	UserRespDTO signUp(UserRequestDTO dto);

	ApiResponse assignAddress(Long userId, AddressDTO dto);
	
	//get users by city
	List<UserRespDTO> getAllUsersByCity(String city);
}
