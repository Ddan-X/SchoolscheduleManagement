package com.school.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Course;
import com.school.entity.CourseDetail;
import com.school.entity.Teacher;
import com.school.response.Invigilation;
import com.school.response.Schedule;
import com.school.service.CourseService;
import com.school.service.TeacherService;

@RestController
public class CourseController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/apartment/{apartmentName}")
	public ResponseEntity<?> findTeachers(@PathVariable("apartmentName")String apartName){
		
		List<Teacher> lTeachers	= teacherService.findTeachersByApartName(apartName);
		List<Schedule> list = new ArrayList<>();
		
		for(Teacher t : lTeachers) {
			Schedule s = new Schedule(t.getCourses());
			s.setTeacherName(t.getTeacherName());
			list.add(s);
		}
		
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("/course/teacher/{teacherId}")
	public ResponseEntity<?> findCourseByTeacherId(@PathVariable("teacherId")Integer id){
		
		List<Course> list = courseService.findByTeachersTeacherId(id);
		
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("/courseDetails/{courseId}")
	public ResponseEntity<?> findCourseDetailsByCourseId(@PathVariable("courseId")Integer id){
		
		List<CourseDetail> list = courseService.findCourseDetailsBycourseCourseId(id);
		
		return ResponseEntity.ok(list);
		
	}
	//老师监考次数排序
	@GetMapping("/invigilations/all")
	public ResponseEntity<?> getAllTeacherBaseInvigilation() {
		List<Teacher> lTeachers = teacherService.getallTeachers();
		List<Invigilation> lInvigilations = new ArrayList<>();
		for (Teacher t : lTeachers) {
			Invigilation invigilation = new Invigilation();
			invigilation.setTeacherName(t.getTeacherName());
			invigilation.setInvigilationCount(t.getInvigilationCount());
			lInvigilations.add(invigilation);
		}
		//排序从小到大
		lInvigilations = lInvigilations.stream().sorted(Comparator.comparing(Invigilation::getInvigilationCount)).collect(Collectors.toList());
		
		return ResponseEntity.ok(lInvigilations);
	}
	
	@PutMapping(value = "/invigilations")
	public ResponseEntity<?> addInvigilationsCount(Integer id, int count){
		Teacher t = teacherService.findTeacherById(id);
		t.setInvigilationCount(count);
		teacherService.save(t);
		
		return  ResponseEntity.status(200).body(t);
	}
	
}
