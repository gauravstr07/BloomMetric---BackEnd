package com.project.bloomMetric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bloomMetric.dto.ActivityRequest;
import com.project.bloomMetric.dto.ActivityResponse;
import com.project.bloomMetric.service.ActivityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

	@Autowired
	private final ActivityService activityService;

	@PostMapping()
	public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {
		return ResponseEntity.ok(activityService.trackActivity(request));
	}

	@GetMapping()
	public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader(value = "X-user-ID") String userId) {
		return ResponseEntity.ok(activityService.getUserActivities(userId));
	}
}
