package com.techiterator.springboot.studentservices.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.StringUtils;

import com.techiterator.springboot.studentservices.model.Student;

public class StudentRepositoryImpl  implements StudentCustomRepository{

	@Autowired
    @Lazy
    StudentRepository studentRepository;
	@Autowired
	JdbcTemplate JdbcTemplate;
	

	@Override
	public List<Student> getStudentsByPage(int pageid, int total) {

		// TODO Auto-generated method stub
		 String sql="select b.subjects,a.id,a.first_name,a.last_name,a.sex,a.dob,a.email,a.section,a.country,a.first_attempt from student a join student_subjects b on a.id=b.student_id limit "+(pageid-1)+","+total;  
		 return JdbcTemplate.query(sql,new ResultSetExtractor<List<Student>>(){  
		    
		     public List<Student> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Student> list=new ArrayList<Student>();  
		        
		        while(rs.next()){  
		        Student e=new Student();  
		        e.setId(rs.getInt("id"));  
		        e.setFirstName(rs.getString("first_name"));  
		        e.setLastName(rs.getString("last_name"));  
		        e.setSex(rs.getString("sex"));
		        e.setDob(rs.getTimestamp("dob"));
		        e.setEmail(rs.getString("email"));
		        e.setSection(rs.getString("section"));  
		        e.setCountry(rs.getString("country"));  
		        e.setFirstAttempt(rs.getBoolean("first_attempt"));
		        e.setSubjects(convertDelimitedStringToList(rs.getString("subjects")));
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
}
	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> result = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return result;

	}
}
