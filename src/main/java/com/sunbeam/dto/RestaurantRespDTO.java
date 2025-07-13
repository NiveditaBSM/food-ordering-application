package com.sunbeam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class RestaurantRespDTO extends BaseDTO {
	
	private String name;
	private String address;	
	private String city;
	private String description;

	// for soft delete
	private boolean status;
	
	public RestaurantRespDTO(String name, String address, String city, String description) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.description = description;
		this.status = true;
	}

}
