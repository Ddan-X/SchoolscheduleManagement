package com.school.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.Teacher;
import com.school.repository.TeacherRepository;
import com.school.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public List<Teacher> findTeachersByApartName(String apartName) {
		// TODO Auto-generated method stub
		return teacherRepository.findTeachersByapartmentApartmentName(apartName);
	}

}
