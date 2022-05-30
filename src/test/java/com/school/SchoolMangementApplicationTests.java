package com.school;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.school.entity.Apartment;
import com.school.entity.Course;
import com.school.entity.CourseDetail;
import com.school.entity.Teacher;
import com.school.repository.CourseDetailRepository;
import com.school.repository.CourseRepository;
import com.school.repository.TeacherRepository;
import com.school.response.Schedule;
import com.school.service.CourseService;

@SpringBootTest
class SchoolMangementApplicationTests {

	
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CourseDetailRepository courseDetailRepository;
//	
	@Autowired
	TeacherRepository teacherRepository;
	
//	@Test
//	void findCourse() {
//		List<CourseDetail> lDetails = courseDetailRepository.findCourseDetailsBycourseCourseId(1);
//		for(CourseDetail courseDetail : lDetails) {
//			System.out.println(courseDetail.getDay());
//			System.out.println(courseDetail.getLocation());
//			System.out.println(courseDetail.getStartTime());
//			System.out.println(courseDetail.getEndTime());
//			System.out.println(courseDetail.getCourse().getCourseName());
//			
//		}
//	}
	
	@Test
	void findTeacher() {

		List<Teacher> lTeachers	= teacherRepository.findTeachersByapartmentApartmentName("IT");

		List<Schedule> schecList = new ArrayList<>();
		
		
		for(Teacher t: lTeachers) {
			//System.out.println(t.getTeacherName());
			//List<Course> list =t.getCourses();
			List<Course> list = courseRepository.findByTeachersTeacherId(t.getTeacherId());
			//System.out.println("course siez"+list.size());
			Schedule schedule = new Schedule(t.getTeacherName(),list,t.getTeacherId());
			schecList.add(schedule);
		}
		System.out.println("===========Get course=======");
		for(int i=0;i<schecList.size();i++) {
			Schedule schedule = schecList.get(i);
			
			List<Course> cList = schedule.getListCourses();
			List<CourseDetail> courseDetails = new ArrayList<>();
			
			for(Course c:cList) {
				System.out.println(schedule.getTeacherName());
				System.out.println(c.getCourseName());
				courseDetails = courseDetailRepository.findCourseDetailsBycourseCourseId(c.getCourseId());
				
//				for(CourseDetail cDetail : courseDetails) {
//					System.out.println(cDetail.getDay());
//					System.out.println(cDetail.getLocation());
//					System.out.println(cDetail.getStartTime());
//					System.out.println(cDetail.getEndTime());
//				}
			}
			
			
			
		}

	}

}
