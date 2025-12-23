package com.project.bloomMetric.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.project.bloomMetric.model.ActivityType;
import com.project.bloomMetric.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityRequest {
	
	private String userId;
	private ActivityType type;
	private Map<String, Object> additinalMetrics;
	private Integer duration;
	private Integer caloriesBurned;
	private LocalDateTime startTime;
}
