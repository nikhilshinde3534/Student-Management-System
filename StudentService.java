package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepo sr;
	
	public void registration(Student s)
	{
		sr.save(s);	//Insert Query Directly
	}
	
	public List<Student> getallstudents()
	{
		return sr.findAll();	//select * from student
	}
	
	public void delete(Long id)
	{
//		sr.deleteById(id);
		
		if(sr.existsById(id))
		{
			sr.deleteById(id);
		}
		else
		{
			throw new RuntimeException("Id not found");
		}
	}
	
	public Optional<Student> getStudentById(Long id)
	{
		return sr.findById(id);
	}
	
	public void profileupdate(Long id, Student s)
	{
		Student stud = sr.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		stud.setFullname(s.getFullname());
		stud.setEmail(s.getEmail());
		stud.setPassword(s.getPassword());
		stud.setAddress(s.getAddress());
		sr.save(stud);
	}
	
	public Student logincheck(String email, String password)
	{
		Student s = sr.findByEmail(email).orElseThrow(()->new RuntimeException("Email not found"));
		
		if(!s.getPassword().equals(password))
		{
			throw new RuntimeException("Password not found");
		}
		return s;
	}
}
