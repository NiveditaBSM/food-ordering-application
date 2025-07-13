package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.FoodItem;

public interface FoodItemDao extends JpaRepository<FoodItem, Long> {

}
