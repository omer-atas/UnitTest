package com.atmosware.unitTestingDemo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import com.atmosware.unitTestingDemo.entities.concretes.Student;

public class StudentManager {

	public List<Student> students = new ArrayList<>();

	public StudentManager() {

		students.add(new Student(1, "Engin", 5));
		students.add(new Student(2, "Ahmet", 6));
		students.add(new Student(3, "Alihaydar", 7));
		students.add(new Student(4, "Berkan", 8));
		students.add(new Student(5, "Burak", 9));
	}

	// int add(Student)
	// Sucess : 1
	// Fail: 0

	// Öğrenci ismi tekrar edemez...

	public int add(Student student) throws Exception {

		
		checkIfStudentAgeIsValid(student);
		checkIfStudentExists(student);

		students.add(student);
		return 1;
	}

	public void checkIfStudentExists(Student student) throws Exception {

		for (Student s : students) {

			if (s.getName().equalsIgnoreCase(student.getName())) {
				throw new Exception("Aynı isimde öğrenci bulunmaktadır..");
			}

		}
	}

	public void checkIfStudentAgeIsValid(Student student) throws Exception {

		if (student.getAge() < 4 || student.getAge() > 12) {
			throw new Exception("Yaş aralığı 4-12 olmalıdır..");
		}
	}

}
