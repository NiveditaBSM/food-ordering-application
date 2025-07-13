package com.sunbeam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {
 //derived finder method
	List<Restaurant> findByStatusTrue();
	//derived exists method
	boolean existsByName(String restaurantName);
	//to fetch complete details(=restaurant + food items)
	@Query("select r from Restaurant r left join fetch r.foodItems where r.id=:restaurantId")
	Restaurant fetchCompleteDetails(Long restaurantId);
	
}
