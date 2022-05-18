package com.school.service.Impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.entity.Course;
import com.school.entity.CourseDetail;
import com.school.entity.Teacher;
import com.school.repository.CourseDetailRepository;
import com.school.repository.CourseRepository;
import com.school.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CourseDetailRepository courseDetailRepository;
	
	@Override
	public void saveCourse(Course c) {
		// TODO Auto-generated method stub
		courseRepository.save(c);
	}

	@Override
	public List<Course> findCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Set<Teacher> findTeachersById(Integer id) {
		// TODO Auto-generated method stub
		return courseRepository.findTeachersByCourseId(id);
	}

	@Override
	public List<Course> findByTeachersTeacherId(Integer id) {
		// TODO Auto-generated method stub
		return courseRepository.findByTeachersTeacherId(id);
	}

	@Override
	public List<CourseDetail> findCourseDetailsBycourseCourseId(Integer id) {
		// TODO Auto-generated method stub
		return courseDetailRepository.findCourseDetailsBycourseCourseId(id);
	}

	
}
