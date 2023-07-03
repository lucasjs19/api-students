package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private StudentRepository repository;
	
	@GetMapping
	public List<Student> findAll(){
		List<Student> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Student findById(@PathVariable Long id) {
		Student result = repository.findById(id).get();
		return  result;
	}
	
	@PostMapping
	public Student insert(@RequestBody Student student) {
		Student result = repository.save(student);
		return result;
	}
	
	@DeleteMapping(value = "/{id}")
	public void  deleteById(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
