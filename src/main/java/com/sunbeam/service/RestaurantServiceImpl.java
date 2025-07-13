package com.sunbeam.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ApiException;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.RestaurantDao;
import com.sunbeam.dto.AddRestaurantDTO;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.RestaurantMenuDTO;
import com.sunbeam.dto.RestaurantRespDTO;
import com.sunbeam.entities.Restaurant;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
	// depcy - auto wire by type : constr based D.I - immutable
	private final RestaurantDao restaurantDao;
	private final ModelMapper modelMapper;

	@Override
	public List<RestaurantRespDTO> getAllRestaurants() {
		// TODO Auto-generated method stub
		return restaurantDao.findByStatusTrue() //List<entity>
				.stream() //Stream<entity>
				.map(restaurant -> 
				modelMapper.map(restaurant, RestaurantRespDTO.class)) //Stream<dto>
				.toList(); //List<dto>
	}

	@Override
	public ApiResponse deleteRestaurantDetail(Long restaurantId) {
		// get restaurant from its id
		Restaurant restaurant = restaurantDao.findById(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("invalid restaurant id !!!!!"));
		// => restaurant : PERSISTENT
		restaurant.setStatus(false);// modifying state the persistent entity
		return new ApiResponse("soft deleted restaurant details ");
	}

	@Override
	public RestaurantRespDTO getRestaurantDetails(Long id) {
		// invoke dao's method
		Restaurant entity = restaurantDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Restaurant ID !!!!!"));
		// => success , map entity -> dto
		return modelMapper.map(entity, RestaurantRespDTO.class);
	}

	@Override
	public ApiResponse updateDetails(Long id, AddRestaurantDTO dto) {
		// validate restaurant name - distinct
		if (restaurantDao.existsByName(dto.getName()))
			throw new ApiException("Dup Restaurant Name - update restaurant failed ");

		// invoke dao's method
		Restaurant entity = restaurantDao.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException("Invalid Restaurant ID : Update failed"));
		// map dto -> entity (only not null fields will be transferred)
		//entity - PERSISTENT
		modelMapper.map(dto, entity);//modifying state of the persistent entity
	//	restaurantDao.save(entity);
		return new ApiResponse("restaurant details updated !");
	}// DML - update

	@Override
	public ApiResponse addNewRestaurant(AddRestaurantDTO dto) {
		// validate if restaurant name - distinct
		if (restaurantDao.existsByName(dto.getName()))
			throw new ApiException
			("Dup Restaurant Name - add restaurant failed");
//map dto -> entity
		Restaurant entity = modelMapper.map(dto, Restaurant.class);
		// unique name , set status : true (=> restaurant available)
		entity.setStatus(true);
		// invoke dao's method - save :insert
		Restaurant persistenRestaurant = restaurantDao.save(entity);
		return new ApiResponse
				("Added new restaurant with ID=" + persistenRestaurant.getId());
	}

	@Override
	public RestaurantMenuDTO getCompleteDetails(Long restaurantId) {
		// 1. call dao's method
		Restaurant entity =
				restaurantDao.fetchCompleteDetails(restaurantId);
		//2. map entity -> dto
		return modelMapper.map(entity, RestaurantMenuDTO.class);
	}
	
	

}
