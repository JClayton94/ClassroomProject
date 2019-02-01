package com.qa.persistance.repository;

public interface StudentRepository {

	String getAllStudents();

	String createStudent(String student);

	String deleteStudent(Long id);

	String updateStudent(Long id, String student);

}
