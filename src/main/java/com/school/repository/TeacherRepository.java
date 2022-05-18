package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.Apartment;
import com.school.entity.Course;
import com.school.entity.Teacher;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	List<Teacher> findTeachersByapartmentApartmentName(String name);
	
}
