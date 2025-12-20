package com.project.bloomMetric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bloomMetric.model.User;
import com.project.bloomMetric.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	@Autowired
	private final UserService userService;
		

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}
	
}










