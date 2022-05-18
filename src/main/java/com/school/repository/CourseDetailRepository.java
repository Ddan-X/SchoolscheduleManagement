package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.school.entity.CourseDetail;

@Repository
public interface CourseDetailRepository extends JpaRepository<CourseDetail, Integer> {
	
	
	List<CourseDetail> findCourseDetailsBycourseCourseId(Integer id);
	
}
