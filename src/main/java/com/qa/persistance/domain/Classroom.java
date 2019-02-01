package com.qa.persistance.domain;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long classroomID;

	private String trainer;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private ArrayList<Student> students;

	public Classroom() {

	}

	public Classroom(Long classroomID, String trainer, ArrayList<Student> students) {
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

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

}
