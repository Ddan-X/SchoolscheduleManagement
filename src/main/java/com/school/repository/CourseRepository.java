package com.school.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.school.entity.Course;
import com.school.entity.CourseDetail;
import com.school.entity.Teacher;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	Set<Teacher> findTeachersByCourseId(Integer courseId);
	List<CourseDetail> findCourseDetailsByCourseId(Integer courseId);
	List<Course> findByTeachersTeacherId(Integer id);
	
}
