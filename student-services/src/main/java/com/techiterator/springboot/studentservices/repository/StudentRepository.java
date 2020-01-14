package com.techiterator.springboot.studentservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techiterator.springboot.studentservices.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>, StudentCustomRepository{


	
	
}