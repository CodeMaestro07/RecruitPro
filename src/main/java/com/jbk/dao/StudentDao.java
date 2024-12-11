package com.jbk.dao;

import java.util.List;

import com.jbk.entities.Student;

public interface StudentDao {
	public int createStudent(Student student);
	public int createMultipleStudent(List<Student> liststudent) ;
	public List<Student> fetchallStudents();
}
