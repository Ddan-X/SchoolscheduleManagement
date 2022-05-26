package com.school.service;

import java.util.List;

import com.school.entity.Teacher;

public interface TeacherService {
	List<Teacher> findTeachersByApartName(String apartName);
	List<Teacher> getallTeachers();
}
