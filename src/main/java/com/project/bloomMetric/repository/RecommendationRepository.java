package com.project.bloomMetric.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bloomMetric.model.Recommendations;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendations, String>{

	List<Recommendations> findByUserId(String userId);

	List<Recommendations> findByActivityId(String activityId);

}
