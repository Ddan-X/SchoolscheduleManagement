package com.school.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Course;
import com.school.entity.CourseDetail;
import com.school.entity.Teacher;
import com.school.request.InvigilationRequest;
import com.school.request.LoginRequest;
import com.school.response.Invigilation;
import com.school.response.Schedule;
import com.school.service.CourseService;
import com.school.service.TeacherService;

@RestController
@RequestMapping("/api/school")
@CrossOrigin(origins = "http:/4200/*", maxAge = 3600)//allow cross-origin resource sharing (CORS) request
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
			s.setTeacherId(t.getTeacherId());
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
			invigilation.setTeacherId(t.getTeacherId());
			lInvigilations.add(invigilation);
		}
		//排序从小到大
		lInvigilations = lInvigilations.stream().sorted(Comparator.comparing(Invigilation::getInvigilationCount)).collect(Collectors.toList());
		
		return ResponseEntity.ok(lInvigilations);
	}
	
	@PutMapping(value = "/invigilations/all/modify")
	public ResponseEntity<?> addInvigilationsCount(@RequestBody List<InvigilationRequest> request){
		for(InvigilationRequest inv: request) {
			Teacher t = teacherService.findTeacherById(inv.getTeacherId());
			t.setInvigilationCount(t.getInvigilationCount());
			teacherService.save(t);
		}
		
//		Map<Integer,Integer> request = invigilationRequest.getInvigilationMap();
//		for(Map.Entry<Integer, Integer> entry : request.entrySet()) {
//			Teacher t = teacherService.findTeacherById(entry.getKey());
//			t.setInvigilationCount(entry.getValue());
//			teacherService.save(t);
//		}
		return  ResponseEntity.status(200).body(request);
	}

	
}
