package com.qa.persistance.repository;

public interface ClassroomRepository {
	
	String getAllClassrooms();

	String createClassroom(String classroom);

	String deleteClassroom(Long id);

	String updateClassroom(Long id, String classroom);
}
