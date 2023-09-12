package com.global.RestaurantManage.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.RestaurantManage.entity.Category;
import com.global.RestaurantManage.repository.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

	private final CategoryRepo repo;
	
	
	public List<Category> findall(){
		return repo.findAll();
	}
	
	public Category insert(Category entity) {
		if (entity.getId() != null) {
			throw new RuntimeException();
		}
		return repo.save(entity);
	}
}
