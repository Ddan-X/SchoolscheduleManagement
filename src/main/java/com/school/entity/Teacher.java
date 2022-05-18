package com.school.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Data
@DynamicUpdate
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teacherId;
	private String teacherName;
	@ManyToOne
	@JsonIgnore
	private Apartment apartment;
	
	@ManyToMany(mappedBy="teachers",fetch = FetchType.EAGER)
	private List<Course> courses = new ArrayList<>();
}
