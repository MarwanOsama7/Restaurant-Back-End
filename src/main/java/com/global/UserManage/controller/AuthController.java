package com.global.UserManage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.UserManage.secEntity.JwtToken;
import com.global.UserManage.secEntity.SignInRequest;
import com.global.UserManage.security.TokenUtil;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final TokenUtil tokenUtil;
	
	@Operation(summary = "sign in users")
	@PostMapping("/signin")
	public JwtToken signin(@RequestBody SignInRequest signInRequest) {
		return tokenUtil.signin(signInRequest);
	}
}
