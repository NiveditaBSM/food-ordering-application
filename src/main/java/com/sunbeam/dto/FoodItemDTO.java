package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class FoodItemDTO extends BaseDTO{	
	private String itemName;	
	private String itemDescription;	
	private boolean isVeg;
	private int price;
	}
