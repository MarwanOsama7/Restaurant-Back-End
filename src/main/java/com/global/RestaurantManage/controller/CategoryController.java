package com.global.RestaurantManage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.RestaurantManage.entity.Category;
import com.global.RestaurantManage.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryService service;

	@Operation(summary = "Get All Category")
	@GetMapping("/findall")
	public ResponseEntity<?>  findall(){
		return ResponseEntity.ok(service.findall());
	}
	
	@Operation(summary = "Insert Category")
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Category entity) {
		return ResponseEntity.ok(service.insert(entity));
	}
	
}
