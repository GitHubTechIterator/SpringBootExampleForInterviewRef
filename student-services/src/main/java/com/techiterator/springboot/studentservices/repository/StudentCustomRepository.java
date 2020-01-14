package com.techiterator.springboot.studentservices.repository;

import java.util.List;

import com.techiterator.springboot.studentservices.model.Student;

public interface StudentCustomRepository {

	public List<Student> getStudentsByPage(int pageid, int total);
	
}
