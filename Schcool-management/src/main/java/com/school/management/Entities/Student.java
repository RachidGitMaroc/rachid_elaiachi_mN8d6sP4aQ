package com.school.management.Entities;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    private int ID;

    @Column(name = "First_Name", nullable = false)
    private String firstName;

    @Column(name = "Last_Name", nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "Class_ID", nullable = false)
    private ClassEntity classEntity;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public Student() {
		super();
	}

	public Student(int id, String firstName, String lastName) {
		this.ID=id;
		this.firstName=firstName;
		this.lastName=lastName;
	}
    
}