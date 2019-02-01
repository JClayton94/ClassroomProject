package com.qa.buisness;

import javax.inject.Inject;

import com.qa.persistance.repository.ClassroomRepository;

public class BuisnessRulesImpl implements BuisnessRules {

	@Inject
	private ClassroomRepository repo;

	public String getAllClassrooms() {

		return repo.getAllClassrooms();

	}

	public String createClassroom(String classroom) {

		return repo.createClassroom(classroom);

	}

	public String deleteClassroom(Long id) {

		return repo.deleteClassroom(id);
	}

	public String updateClassroom(Long id, String classroom) {

		return repo.updateClassroom(id, classroom);

	}

}
