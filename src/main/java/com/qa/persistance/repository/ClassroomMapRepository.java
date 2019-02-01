package com.qa.persistance.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.persistence.Entity;

import com.qa.persistance.domain.Classroom;
import com.qa.util.JSONUtil;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository {

	JSONUtil util = new JSONUtil();

	Map<Long, Classroom> classroomMap = new HashMap<>();

	public String getAllClassrooms() {

		return util.getJSONForObject(classroomMap.values());
	}
	
	public String createClassroom(String classroom) {

		Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class);

		classroomMap.put(newClassroom.getClassroomID(), newClassroom);

		return "Classroom created";
	} 

	public String deleteClassroom(Long id) {

		classroomMap.remove(id);

		return "Classroom with id: " + id + " deleted!";
	}

	public String updateClassroom(Long id, String classroom) {

		Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class);

		classroomMap.put(id, newClassroom);

		return "Classroom updated";
	}
	

}
