package com.school.request;

import java.util.HashMap;
import java.util.Map;

import com.school.response.Invigilation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvigilationRequest {
	//key: teacherId'
	//value: invigilationCount
	//Map<Integer,Integer> invigilationMap = new HashMap<>();
	private Integer teacherId;
	private Integer invigilationCount;
}
