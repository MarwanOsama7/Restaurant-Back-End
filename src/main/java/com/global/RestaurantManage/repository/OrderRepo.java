package com.global.RestaurantManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.RestaurantManage.entity.Order;

public interface OrderRepo extends JpaRepository<Order,Long>{
	
	List<Order> findByCategoryId(Long id);
	List<Order> findByNameContaining(String name);
}
