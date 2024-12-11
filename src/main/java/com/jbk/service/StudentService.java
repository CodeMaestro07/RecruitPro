package com.jbk.service;

import java.util.List;

import com.jbk.entities.Student;


public interface StudentService {

	public int createStudent(Student student);

	public int createMultipleStudent(List<Student> liststudent);

	public List<Student> fetchallStudents();

	public int deleteStudent(Long id);

	public int updateStudent(Student student);

	
}
