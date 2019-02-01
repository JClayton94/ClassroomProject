package com.qa.persistance.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistance.domain.Student;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class StudentRepositoryImpl implements StudentRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	JSONUtil util;

	public String getAllStudents() {

		Query query = em.createQuery("Select a FROM Student a");

		Collection<Student> students = (Collection<Student>) query.getResultList();

		return util.getJSONForObject(students);

	}

	@Transactional(REQUIRED)
	public String createStudent(String student) {
		Student aStudent = util.getObjectForJSON(student, Student.class);
		em.persist(aStudent);
		return "{\"message\": \"Student has been sucessfully created\"}";

	}

	@Transactional(REQUIRED)
	public String deleteStudent(Long id) {
		Student studentInDB = findStudent(id);
		if (studentInDB != null) {
			em.remove(studentInDB);
		}
		return "{\"message\": \"Student sucessfully deleted\"}";

	}

	@Transactional(REQUIRED)
	public String updateStudent(Long id, String student) {
		Student studentInDB = findStudent(id);
		if (studentInDB != null) {
			Student newStudent = util.getObjectForJSON(student, Student.class);
			em.remove(studentInDB);
			em.persist(newStudent);
			return "{\"message\": \"Student sucessfully updated\"}";
		}
		return "{\"message\": \"Student does not exist\"}";
	}

	private Student findStudent(Long id) {
		return em.find(Student.class, id);
	}

}

