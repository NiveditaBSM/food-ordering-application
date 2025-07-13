package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.AddRestaurantDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RestaurantMenuDTO;
import com.sunbeam.dto.RestaurantRespDTO;

public interface RestaurantService {
	List<RestaurantRespDTO> getAllRestaurants();
	ApiResponse deleteRestaurantDetail(Long restaurantId);
	RestaurantRespDTO getRestaurantDetails(Long id);
	ApiResponse updateDetails(Long id, AddRestaurantDTO restaurant);
	ApiResponse addNewRestaurant(AddRestaurantDTO transientRestaurant);
	RestaurantMenuDTO getCompleteDetails(Long restaurantId);
}
