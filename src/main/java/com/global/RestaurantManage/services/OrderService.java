package com.global.RestaurantManage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.global.RestaurantManage.entity.Order;
import com.global.RestaurantManage.error.RecordNotFoundException;
import com.global.RestaurantManage.repository.OrderRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepo repo;

	public List<Order> findByCategoryId(Long id) {
		return repo.findByCategoryId(id);
	}

	public Optional<Order> findById(Long id) {
		Optional<Order> entity = repo.findById(id);
		if (entity.isPresent()) {
			return entity;
		} else {
			throw new RecordNotFoundException("this record with id : " + id + "  Not Found");
		}
	}

	public List<Order> findall() {
		return repo.findAll();
	}

	public List<Order> findByName(String name) {
		return repo.findByNameContaining(name);
	}

	public Order insert(Order entity) {
		if(entity.getCategory().getId() == null) {
			throw new RecordNotFoundException("this id of category Not Found");
		}else {
			return repo.save(entity);
		}
	}
}
