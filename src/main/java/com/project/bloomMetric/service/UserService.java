package com.project.bloomMetric.service;

import org.springframework.stereotype.Service;

import com.project.bloomMetric.model.User;
import com.project.bloomMetric.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;

	public User register(User user) {
		
		return userRepository.save(user);
	}

}
