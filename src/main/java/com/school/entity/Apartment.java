package com.school.entity;

import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Data
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer apartmentId;
	
	private String apartmentName;
	
	@OneToMany(mappedBy="apartment", cascade= CascadeType.ALL)
	private Set<Teacher> teachers;
	
	public Apartment(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	
}
