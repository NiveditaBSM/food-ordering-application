package com.sunbeam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Order;

public interface OrderDao extends JpaRepository<Order,Long> {

}
