package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

import com.qa.persistance.domain.Classroom;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class ClassroomRepositoryImpl implements ClassroomRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	JSONUtil util;

	public String getAllClassrooms() {

		Query query = em.createQuery("Select a FROM Student a");

		Collection<Classroom> accounts = (Collection<Classroom>) query.getResultList();

		return util.getJSONForObject(accounts);

	}

	@Transactional(REQUIRED)
	public String createClassroom(String classroom) {
		Classroom aClassroom = util.getObjectForJSON(classroom, Classroom.class);
		em.persist(aClassroom);
		return "{\"message\": \"Classroom has been sucessfully created\"}";

	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			em.remove(classroomInDB);
		}
		return "{\"message\": \"Classroom sucessfully deleted\"}";

	}

	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String classroom) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class);
			em.remove(classroomInDB);
			em.persist(newClassroom);
			return "{\"message\": \"Classroom sucessfully updated\"}";
		}
		return "{\"message\": \"Classroom does not exist\"}";
	}

	private Classroom findClassroom(Long id) {
		return em.find(Classroom.class, id);
	}

}
