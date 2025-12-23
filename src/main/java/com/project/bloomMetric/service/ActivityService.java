package com.project.bloomMetric.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.project.bloomMetric.dto.ActivityRequest;
import com.project.bloomMetric.dto.ActivityResponse;
import com.project.bloomMetric.model.Activity;
import com.project.bloomMetric.model.User;
import com.project.bloomMetric.repository.ActivityRepository;
import com.project.bloomMetric.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {

	private final ActivityRepository activityRepository;
	private final UserRepository userRepository;

	public ActivityResponse trackActivity(ActivityRequest request) {

		User user = userRepository.findById(request.getUserId())
			    .orElseThrow(() -> new RuntimeException(
			        "User not found with id: " + request.getUserId()
			    ));


		Activity activity = Activity.builder().user(user).type(request.getType()).duration(request.getDuration())
				.caloriesBurned(request.getCaloriesBurned()).startTime(request.getStartTime())
				.additinalMetrics(request.getAdditinalMetrics()).build();
		Activity savedActivity = activityRepository.save(activity);
		return mapToResponse(savedActivity);
	}

	private ActivityResponse mapToResponse(Activity activity) {
		ActivityResponse response = new ActivityResponse();
		response.setId(activity.getId());
		response.setUserId(activity.getUser().getId());
		response.setType(activity.getType());
		response.setDuration(activity.getDuration());
		response.setCaloriesBurned(activity.getCaloriesBurned());
		response.setStartTime(activity.getStartTime());
		response.setAdditinalMetrics(activity.getAdditinalMetrics());
		response.setCreatedAt(activity.getCreatedAt());
		response.setUpdatedAt(activity.getUpdatedAt());
		return response;
	}

	public List<ActivityResponse> getUserActivities( String userId) {
		List<Activity> activityList = activityRepository.findByUserId(userId);
		return activityList.stream().map(this::mapToResponse).collect(Collectors.toList());
	}

}
