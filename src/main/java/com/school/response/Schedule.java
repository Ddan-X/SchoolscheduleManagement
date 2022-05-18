package com.school.response;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	private List<Course> listCourses;
	private List<CourseDetail> listCoursesDetails;
	public Schedule(String teacherName, List<Course> courses) {
		this.teacherName = teacherName;
		this.listCourses = courses;
	}
	public Schedule(Course c){
		if(c.getCourseDetails() != null) {
			listCoursesDetails = c.getCourseDetails().stream().sorted(Comparator.comparing(CourseDetail :: getDay)
					.thenComparing(CourseDetail::getStartTime)).collect(Collectors.toList());
		}
	}
}
