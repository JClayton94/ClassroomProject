package com.qa.persistance.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASSROOMID")
	private Long classroomID;

	private String trainer;
	
	@OneToMany(targetEntity = com.qa.persistance.domain.Student.class ,cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Student> students;

	public Classroom() {

	}

	public Classroom(Long classroomID, String trainer, List<Student> students) {
		this.classroomID = classroomID;
		this.trainer = trainer;
		this.students = students;
	}

	public Long getClassroomID() {
		return classroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.classroomID = classroomID;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

}
