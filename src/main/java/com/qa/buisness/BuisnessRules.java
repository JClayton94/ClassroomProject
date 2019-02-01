package com.qa.buisness;

public interface BuisnessRules {
	
	String getAllClassrooms();

	String createClassroom(String student);

	String deleteClassroom(Long id);

	String updateClassroom(Long id, String student);

}
