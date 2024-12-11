package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jbk.entities.Student;
import com.jbk.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create-student")
	public String createStudent(@RequestBody Student student) {
		int status = studentService.createStudent(student);

		switch (status) {
		case 1:
			return "Student added successfully.";
		case 2:
			return "Student already exists.";
		case 3:
			return "An error occurred while adding the student.";
		default:
			return "Unexpected error.";
		}
	}

	@PostMapping("/create-multiple-student")
	public String createMultipleStudent(@RequestBody List<Student> liststudent) {
		int status = studentService.createMultipleStudent(liststudent);

		switch (status) {
		case 1:
			return "Student added successfully.";
		case 2:
			return "Student already exists.";
		case 3:
			return "An error occurred while adding the student.";
		default:
			return "";
		}
	}

	@GetMapping("all-students")
	public List<Student> fetchallStudents() {
		return studentService.fetchallStudents();

	}

	@DeleteMapping("/delete-student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		int status = studentService.deleteStudent(id);

		switch (status) {
		case 1: {
			return "Student Deleted Successfully";

		}
		case 2: {
			return "Student Not Exists";
		}
		case 3: {
			return "Something went wwrong";
		}
		default:
			return "";
		}
	}

	@PutMapping("/update-student")
	public String updateStudent(@RequestBody Student student) {
		int status = studentService.updateStudent(student);
		switch (status) {
		case 1: {
			return "Student Update Successfully";

		}
		case 2: {
			return "Student Not Exists";
		}
		case 3: {
			return "Something went wwrong";
		}
		default:
			return "";
		}
	}
}
