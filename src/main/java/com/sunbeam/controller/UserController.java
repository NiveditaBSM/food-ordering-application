package com.sunbeam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AddressDTO;
import com.sunbeam.dto.AuthRequest;
import com.sunbeam.dto.UserRequestDTO;
import com.sunbeam.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;

	/*
	 * User sign in
	 * URL - http://host:port/users/signin
	 * Method - POST
	 * Payload - Auth Request DTO (email ,pwd)
	 * error resp - ApiResp dto - SC 401 , mesg - login failed
	 * success resp - UseResp dto - with details
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody AuthRequest dto) {
		return ResponseEntity.ok(userService.authenticate(dto));
	}

	/*
	 * User sign up
	 * URL - http://host:port/users/signup
	 * Method - POST
	 * Payload - UserReqDTO (user details)
	 * error resp - ApiResp dto - SC 400 , mesg - reg failed
	 * success resp - UseResp dto - with details
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> userSignUp(@RequestBody @Valid UserRequestDTO dto) {
		System.out.println("in user signup " + dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.signUp(dto));
	}

	/*
	 * Assign user address
	 * URL - http://host:port/users/{userId}/address
	 * Method - POST
	 * Payload - address dto
	 * error resp - ApiResp dto - SC 400 , mesg - linking adr failed
	 * success resp - ApiResp dto - success mesg
	 */
	@PostMapping("/{userId}/address")
	public ResponseEntity<?> assignUserAddress(
			@PathVariable Long userId, @RequestBody AddressDTO dto) {
		System.out.println("assign adr ");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.assignAddress(userId, dto));
	}

}
