package com.techiterator.springboot.studentservices.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.techiterator.springboot.studentservices.model.Student;
import com.techiterator.springboot.studentservices.repository.StudentRepository;
@Service
public class StudentDAO {

	@Autowired
	private StudentRepository studentRepository;
	
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	
	public void save(Student p) {
		
//String sql="insert into world.student(firstName,lastName,sex,dob,email,section,country,firstAttempt,subjects) values('"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getSex()+"','"+p.getDob()+"','"+p.getEmail()+"','"+p.isFirstAttempt()+"','"+p.getCountry()+"',true,'"+convertListToDelimitedString(p.getSubjects())+"')"; 
		
		studentRepository.save(p);
		
		 
	}
	
	public int count() {
		int count = (int) studentRepository.count();
		return count;
		  }
	public List<Student> getStudentsByPage(int pageid, int total) {
		return studentRepository.getStudentsByPage(pageid, total);
	}
	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> result = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return result;

	}
}
