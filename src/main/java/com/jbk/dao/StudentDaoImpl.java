package com.jbk.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entities.Student;

@Repository
public class StudentDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public int createStudent(Student student) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction(); // Start transaction

			// Fetch the student by ID using HQL
			String hql = "FROM Student WHERE id = :id";
			Query<Student> query = session.createQuery(hql, Student.class);
			query.setParameter("id", student.getId());
			Student existingStudent = query.uniqueResult();

			if (existingStudent == null) {
				session.save(student); // Save new student
				transaction.commit(); // Commit transaction
				return 1; // Success
			} else {
				return 2; // Student already exists
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback(); // Rollback on failure
			}
			e.printStackTrace(); // Log exception (Replace with logging framework in production)
			return 3; // Error occurred
		}
	}

	public int createMultipleStudent(List<Student> liststudent) {
		Transaction transaction = null; // Declare transaction outside the try block
		try (Session session = sessionFactory.openSession()) { // Use try-with-resources to ensure session closure
			if (liststudent != null && !liststudent.isEmpty()) {
				transaction = session.beginTransaction(); // Start the transaction

				for (Student student : liststudent) {
					session.save(student); // Save each student to the database
				}

				transaction.commit(); // Commit the transaction if successful
				return 1; // Success
			} else {
				return 2; // List is null or empty
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback(); // Rollback the transaction on error
			}
			e.printStackTrace(); // Log the error (use a logging framework in production)
			return 3; // Error occurred
		}
	}

	public List<Student> fetchallStudents() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			String hql = "FROM Student"; // HQL to fetch all students
			Query<Student> query = session.createQuery(hql, Student.class);
			return query.getResultList(); // Retrieve the list of students
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList();

		}

	}

	public int deleteStudent(Long id) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction(); // Start transaction

			// Fetch the student by ID using HQL
			String hql = "FROM Student WHERE id = :id";
			Query<Student> query = session.createQuery(hql, Student.class);
			query.setParameter("id", id);
			Student std = query.uniqueResult();

			if (std != null) {
				session.delete(std); // Delete the student
				transaction.commit(); // Commit transaction
				return 1; // Success
			} else {
				return 2; // Student not found
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback(); // Rollback transaction on failure
			}
			e.printStackTrace();
			return 3; // Error occurred
		}
	}

	// Update student details
	public int updateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction(); // Start transaction

			// Fetch the student by ID using HQL
			String hql = "FROM Student WHERE id = :id";
			Query<Student> query = session.createQuery(hql, Student.class);
			query.setParameter("id", student.getId());
			Student existingStudent = query.uniqueResult();

			if (existingStudent != null) {
				// Update student fields
				existingStudent.setFullName(student.getFullName());
				existingStudent.setEmail(student.getEmail());
				existingStudent.setPassword(student.getPassword());
				existingStudent.setContactNumber(student.getContactNumber());
				existingStudent.setDepartment(student.getDepartment());
				existingStudent.setGraduationYear(student.getGraduationYear());

				session.update(existingStudent); // Update the student in the database
				transaction.commit(); // Commit transaction
				return 1; // Success
			} else {
				return 2; // Student not found
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback(); // Rollback transaction on failure
			}
			e.printStackTrace();
			return 3; // Error occurred
		}
	}

}
