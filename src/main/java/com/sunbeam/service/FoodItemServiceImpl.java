package com.sunbeam.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.FoodItemDao;
import com.sunbeam.dao.RestaurantDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.FoodItemDTO;
import com.sunbeam.entities.FoodItem;
import com.sunbeam.entities.Restaurant;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {
	//depcy 
	private final FoodItemDao foodItemDao;
	private final ModelMapper modelMapper;
	private final RestaurantDao restaurantDao;

	@Override
	public ApiResponse addFoodItemToRestaurant(Long restaurantId,
			FoodItemDTO dto) {
		// 1. get restaurant from its id - MUST
		Restaurant restaurantEntity=
				restaurantDao.findById(restaurantId).orElseThrow(() -> 
				new ResourceNotFoundException("Invalid restaurant id - Food Item can't be added!!!!"));
		//1.5 TO DO - add validation rule - for dup checking
		//restaurantEntity : persistent
		//2. map food item dto -> entity
		FoodItem foodItemEntity = modelMapper.map(dto, FoodItem.class);
		//3. Establish bi dir association between entities Restaurant 1 <---> * FoodItem
		restaurantEntity.addFoodItem(foodItemEntity);
		//no need to explicitl call dao.save - cascadeType.ALL
		return new ApiResponse("New food item added to the restaurant");
	}

}
