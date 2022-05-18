package com.school.service;

import java.util.List;
import java.util.Set;

import com.school.entity.Course;
import com.school.entity.CourseDetail;
import com.school.entity.Teacher;

public interface CourseService {
	public void saveCourse(Course c);
	public List<Course> findCourses();
	public Set<Teacher> findTeachersById(Integer id);
	List<Course> findByTeachersTeacherId(Integer id);
	List<CourseDetail> findCourseDetailsBycourseCourseId(Integer id);
}
