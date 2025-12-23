package com.project.bloomMetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bloomMetric.dto.RegisterRequest;
import com.project.bloomMetric.dto.UserResponse;
import com.project.bloomMetric.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	@Autowired
	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
		return ResponseEntity.ok(userService.register(registerRequest));
	}

}
