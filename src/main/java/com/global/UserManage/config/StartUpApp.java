package com.global.UserManage.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.UserManage.entity.AppUser;
import com.global.UserManage.entity.Role;
import com.global.UserManage.services.RoleService;
import com.global.UserManage.services.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StartUpApp implements CommandLineRunner {

	private final  UserService userService;

	private final RoleService roleService;

	@Override
	public void run(String... args) throws Exception {

		if (roleService.findAll().isEmpty()) {
			roleService.save(new Role(null,"admin"));
			roleService.save(new Role(null, "user"));
			roleService.save(new Role(null, "employee"));
		}
 
		if (userService.findall().isEmpty()) {

			Set<Role> adminRoles = new HashSet<>();
			adminRoles.add(roleService.findByName("admin"));

			Set<Role> userRoles = new HashSet<>();
			userRoles.add(roleService.findByName("user"));

			Set<Role> empRoles = new HashSet<>();
			empRoles.add(roleService.findByName("employee"));

			userService.save(new AppUser(null, "marwan@gmail.com", "marwan", "123", 1, adminRoles));
			userService.save(new AppUser(null, "ahmed@gmail.com", "ahmed", "123", 1, userRoles));
			userService.save(new AppUser(null, "mamdouh@gmail.com", "mamdouh", "123", 1, empRoles));
		}
	}
}
