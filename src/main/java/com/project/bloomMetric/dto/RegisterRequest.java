package com.project.bloomMetric.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	
	private String id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
}
