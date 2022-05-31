package com.school.response;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.entity.Course;
import com.school.entity.CourseDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	private String teacherName;
	private Integer teacherId;
	private List<Course> listCourses;
	@JsonIgnore
	private List<CourseDetail> listCoursesDetails;
	
	public Schedule(String teacherName, List<Course> courses, Integer id) {
		this.teacherName = teacherName;
		this.listCourses = courses;
		this.teacherId = id;
	}
	
	public Schedule(List<Course> listC){
		this.listCourses =listC;
		for(Course c:listCourses) {
			if(c.getCourseDetails() != null) {
				listCoursesDetails = c.getCourseDetails().stream().sorted(Comparator.comparing(CourseDetail :: getDay)
						.thenComparing(CourseDetail::getStartTime)).collect(Collectors.toList());
			}
		}
		
	}
	
	
}
