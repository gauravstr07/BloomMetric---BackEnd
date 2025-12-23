package com.project.bloomMetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bloomMetric.dto.RecommendationRequest;
import com.project.bloomMetric.model.Recommendations;
import com.project.bloomMetric.service.RecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

	@Autowired
	private final RecommendationService recommendationService;

	@PostMapping("/generate")
	public ResponseEntity<Recommendations> generateRecommendation(@RequestBody RecommendationRequest request) {
		Recommendations recommendations = recommendationService.generateRecommendation(request);
		return ResponseEntity.ok(recommendations);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Recommendations>> getUserRecommendation(@PathVariable String userId) {
		List<Recommendations> recommendationsList = recommendationService.getUserRecommendation(userId);
		return ResponseEntity.ok(recommendationsList);
	}
	
	@GetMapping("/activity/{activityId}")
	public ResponseEntity<List<Recommendations>> getActivityRecommendation(@PathVariable String activityId) {
		List<Recommendations> recommendationsList = recommendationService.getActivityRecommendation(activityId);
		return ResponseEntity.ok(recommendationsList);
	}

}
