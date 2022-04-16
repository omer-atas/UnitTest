package com.atmosware.unitTestingDemo.businessTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.atmosware.unitTestingDemo.business.concretes.StudentManager;
import com.atmosware.unitTestingDemo.entities.concretes.Student;

public class StudentManagerTests {

	StudentManager studentManager;

	/*
	 * 
	 * @After 
	 * public void finish(){
	 * 	En son bir defa çalışır...
	 * }
	 * 
	 * @BeforeAll 
	 * public void start(){
	 *   Başlangıçta bir defa çalışır..
	 * }
	 * 
	 * @AfterEach 
	 * public void clean(){
	 *  Her işlemden sonra data temizliliğini sağlamak amacıyla kullanılır..
	 * }
	 * 
	 */

	@BeforeEach
	public void setUp() {
		studentManager = new StudentManager();
	}

	@Test
	public void add_different_name_student_to_list() throws Exception {

		// arange

		Student student = new Student();
		student.setId(8);
		student.setName("Ömer");
		student.setAge(10);

		int expected = 1;

		// act
		int actual = studentManager.add(student);

		// assert
		Assertions.assertEquals(expected, actual);

	}

	@Test
	public void add_same_name_student_to_list() throws Exception {

		// arange

		Student student = new Student();
		student.setId(6);
		student.setName("Engin");
		student.setAge(10);

		int expected = 0;

		// act
		int actual = studentManager.add(student);

		// assert
		Assertions.assertEquals(expected, actual);

	}

	@Test
	public void student_added_successfully() throws Exception {

		// arange

		Student student = new Student();
		student.setId(8);
		student.setName("Ömer");
		student.setAge(10);

		String expectedName = "Ömer";
		int expectedId = 8;

		// act
		int result = studentManager.add(student);
		String actualName = studentManager.students.get(5).getName();
		int actualId = studentManager.students.get(5).getId();

		// assert
		Assertions.assertEquals(expectedId, actualId);
		Assertions.assertEquals(expectedName, actualName);
	}

	@Test
	public void is_valid_age_student() throws Exception {

		// arange
		Student student = new Student();
		student.setId(12);
		student.setName("test");
		student.setAge(10);

		// act
		Assertions.assertThrows(Exception.class, () -> {
			studentManager.add(student);
		});
	}
}
