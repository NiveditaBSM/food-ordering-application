package com.sunbeam.service;

import com.sunbeam.dto.OrderResponse;
import com.sunbeam.dto.PlaceOrderDTO;

public interface OrderService {

	OrderResponse placeOrder(PlaceOrderDTO dto);

}
