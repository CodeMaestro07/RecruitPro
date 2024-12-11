package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDaoImpl;
import com.jbk.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDaoImpl studentDao;

	@Override
	public int createStudent(Student student) {
		int status = studentDao.createStudent(student);
		return studentDao.createStudent(student);
	}

	@Override
	public int createMultipleStudent(List<Student> liststudent) {
		int status = studentDao.createMultipleStudent(liststudent);
		return status;
	}

	@Override
	public List<Student> fetchallStudents() {

		return studentDao.fetchallStudents();
	}

	@Override
	public int deleteStudent(Long id) {
		int status = studentDao.deleteStudent(id);
		return status;
	}

	@Override
	public int updateStudent(Student student) {

		return studentDao.updateStudent(student);
	}

}
