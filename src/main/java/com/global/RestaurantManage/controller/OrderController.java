package com.global.RestaurantManage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.RestaurantManage.entity.Order;
import com.global.RestaurantManage.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService service;
	
	@Operation(summary = "Get orders by CategoryId")
	@GetMapping("/categoryid/{id}")
	public ResponseEntity<?> findByCategoryId(@PathVariable Long id){
		return ResponseEntity.ok(service.findByCategoryId(id));
	}

	@Operation(summary = "Get orders by Id")
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return  ResponseEntity.ok(service.findById(id));
	}
	
	@Operation(summary = "Get All orders ")
	@GetMapping("/findall")
	public ResponseEntity<?>  findall(){
		return ResponseEntity.ok(service.findall());
	}
	
	@Operation(summary = "Get orders by Name")
	@GetMapping("/findByName/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		return ResponseEntity.ok(service.findByName(name)) ;
	}
	@Operation(summary = "Insert orders")
	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Order entity) {
		return ResponseEntity.ok(service.insert(entity));
	}
}
