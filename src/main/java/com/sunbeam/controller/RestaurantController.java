package com.sunbeam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.AddRestaurantDTO;
import com.sunbeam.dto.RestaurantRespDTO;
import com.sunbeam.service.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;

@RestController 
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@Validated
public class RestaurantController {
	
	private final RestaurantService restaurantService;

	/*
	 * Request handling method (REST API end point) URL -
	 * http://host:port/restaurants/ 
	 * Method - GET 
	 * Payload - none 
	 * Resp - in case of empty list - SC204 (NO_CONTENT) 
	 * o.w SC 200 + list of restaurants -> JSON []
	 */
	@GetMapping
	public  ResponseEntity<?> listAvailableRestaurants() {
		System.out.println("in list");
		List<RestaurantRespDTO> restaurants 
		= restaurantService.getAllRestaurants();
		if(restaurants.isEmpty())
			 return ResponseEntity
					 .status(HttpStatus.NO_CONTENT).build();
		//=> list non empty		
		return ResponseEntity.ok(restaurants);
	}

	/*
	 * Request handling method (REST API end point) 
	 * - desc - Add new restaurant 
	 * URL -http://host:port/restaurants 
	 * Method - POST 
	 * Payload -JSON representation of restaurant 
	 * Resp - in case failure (dup restaurant name) - ApiResp DTO
	 *  - containing err mesg + SC 400(BAD_REQUEST)
	 *  success - SC 201 + ApiResp - success mesg
	 */
	@PostMapping
	@Operation(description = "Add New Resaturant")
	public ResponseEntity<?> addNewRestaurant(@RequestBody 
			AddRestaurantDTO dto) {
		System.out.println("in add " + dto);
		
		// call service method
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(restaurantService
						.addNewRestaurant(dto));

	}

	/*
	 * REST API end point - 
	 * desc -soft delete restaurant details 
	 * URL-http://host:port/restaurants/{restaurantId} 
	 * Method - DELETE 
	 * Payload - none
	 * Resp - ApiResponse
	 */
	@DeleteMapping("/{restaurantId}") 
	public ResponseEntity<?> deleteDetails
	(@PathVariable  Long restaurantId) {
		System.out.println("in delete " + restaurantId);
		return ResponseEntity
				.ok(restaurantService.deleteRestaurantDetail(restaurantId));
	}

	/*
	 * REST API end point - desc -get restaurant details by id 
	 * URL
	 * -http://host:port/restaurants/{restaurantId} 
	 * Method - GET 
	 * Payload - none 
	 * successful Resp - SC 200 +Restaurant Resp dto-> JSON
	 * error resp - SC 404 + Apiresp (err mesg)
	 */
	@GetMapping("/{restaurantId}")
	// swagger annotation
	@Operation(description = "Get restaurant details by ID")
	public ResponseEntity<?> getRestaurantDetails(
			@PathVariable @Min(1) @Max(100) Long restaurantId) {
		System.out.println("in get details " + restaurantId);
	
		return ResponseEntity.ok(
				restaurantService.getRestaurantDetails(restaurantId));

	}
	/*
	 * REST API end point - 
	 * desc -update restaurant details by id
	 *  URL -http://host:port/restaurants/{restaurantId} 
	 *  Method - PUT 
	 *  Payload - JSON representation of Restaurant
	 *  Resp - Apiresp	   	 
	 */
	@PutMapping("/{restaurantId}")
	@Operation(description = "Update restaurant details(Partial or Complete)")
	public ResponseEntity<?> updateDetails
	(@PathVariable Long restaurantId,
			@RequestBody AddRestaurantDTO dto ) {
		System.out.println("in update "+restaurantId+" "+dto);
		return ResponseEntity.ok(
				restaurantService.updateDetails(restaurantId, dto));
	}	
	/*
	 * 2.2 Get restaurant n its menu
 - i/p restaurant id
 o/p - complete details (restaurant + food items)
  REST API end point - 
	 * desc -get complete details
	 *  URL -http://host:port/restaurants/{restaurantId} 
	 *  Method - GET
	 *  Payload - none
	 *  Resp - DTO of Restaurant + food items	

	 */
	@GetMapping("/{restaurantId}/food_items")
	public ResponseEntity<?> fetchCompleteDetails(@PathVariable Long restaurantId) {
		System.out.println("in get completer details "+restaurantId);
		return ResponseEntity.ok(
				restaurantService.getCompleteDetails(restaurantId)
				);
	}

}
