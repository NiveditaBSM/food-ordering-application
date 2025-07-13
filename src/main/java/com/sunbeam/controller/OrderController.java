package com.sunbeam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.PlaceOrderDTO;
import com.sunbeam.service.OrderService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	private final OrderService orderService;
	/*
	 * Desc - Place Order 
	 * URL - http://host:port/orders
	 * Method - POST
	 * Payload - OrderRequestDTO
	 *    - customer id , restaurant id , 
	 *    array of - food item id n quantity
	 *   Resp -  ApiResp - success SC OK - order placed with id
	 *   failure -ApiResp-  err mesg -
	 */
	@PostMapping
	public ResponseEntity<?> placeFoodOrder
	(@RequestBody PlaceOrderDTO dto)
	{
		System.out.println("place order "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(orderService.placeOrder(dto));
	}

}
