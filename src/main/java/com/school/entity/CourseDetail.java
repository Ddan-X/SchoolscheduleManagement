package com.school.entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class CourseDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseDetailId;
	private String day;
	private Time startTime;
	private Time endTime;
	private String location;
	
	@ManyToOne
	@JsonIgnore
	private Course course;
	
}
