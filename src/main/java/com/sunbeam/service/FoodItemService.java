package com.sunbeam.service;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.FoodItemDTO;

public interface FoodItemService {
	ApiResponse addFoodItemToRestaurant(Long restaurantId, FoodItemDTO dto);
}
