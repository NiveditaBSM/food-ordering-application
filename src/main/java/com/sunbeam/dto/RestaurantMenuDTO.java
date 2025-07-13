package com.sunbeam.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantMenuDTO extends BaseDTO{
	private String name;
	private String address;	
	private String city;
	private String description;
	//+ List < FoodItem DTO>
	private List<FoodItemDTO> foodItems=new ArrayList<>();
}
