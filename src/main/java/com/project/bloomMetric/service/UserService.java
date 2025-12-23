package com.project.bloomMetric.service;

import org.springframework.stereotype.Service;

import com.project.bloomMetric.dto.RegisterRequest;
import com.project.bloomMetric.dto.UserResponse;
import com.project.bloomMetric.model.User;
import com.project.bloomMetric.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserResponse register(RegisterRequest request) {
		
		User user = User.builder()
				.email(request.getEmail())
				.password(request.getPassword())
				.firstName(request.getFirstName())
				.lastName(request.getLastName())
				.build();


		User savedUser = userRepository.save(user);

		return mapToResponse(savedUser);
	}

	private UserResponse mapToResponse(User savedUser) {
		UserResponse response = new UserResponse();

		response.setId(savedUser.getId().toString()); // if UUID
		response.setEmail(savedUser.getEmail());
		response.setPassword(savedUser.getPassword());
		response.setFirstName(savedUser.getFirstName());
		response.setLastName(savedUser.getLastName());
		response.setCreatedAt(savedUser.getCreatedAt());
		response.setUpdatedAt(savedUser.getUpdatedAt());

		return response;
	}

}
