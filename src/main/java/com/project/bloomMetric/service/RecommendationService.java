package com.project.bloomMetric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bloomMetric.dto.RecommendationRequest;
import com.project.bloomMetric.model.Activity;
import com.project.bloomMetric.model.Recommendations;
import com.project.bloomMetric.model.User;
import com.project.bloomMetric.repository.ActivityRepository;
import com.project.bloomMetric.repository.RecommendationRepository;
import com.project.bloomMetric.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

	@Autowired
	private final UserRepository userRepository;

	@Autowired
	private final ActivityRepository activityRepository;

	@Autowired
	private final RecommendationRepository recommendationRepository;

	public Recommendations generateRecommendation(RecommendationRequest request) {
		User user = userRepository.findById(request.getUserId())
				.orElseThrow(() -> new RuntimeException("User Not Found - " + request.getUserId()));

		Activity activity = activityRepository.findById(request.getActivityId())
				.orElseThrow(() -> new RuntimeException("Activity Not Found - " + request.getActivityId()));

		Recommendations recommendations = Recommendations.builder().user(user).activity(activity)
				.improvements(request.getImprovements()).suggestions(request.getSuggestions())
				.safety(request.getSafety()).build();

		Recommendations savedRecommendations = recommendationRepository.save(recommendations);

		return savedRecommendations;
	}

	public List<Recommendations> getUserRecommendation(String userId) {
		return recommendationRepository.findByUserId(userId);
	}

	public List<Recommendations> getActivityRecommendation(String activityId) {
		return recommendationRepository.findByActivityId(activityId);
	}

}
