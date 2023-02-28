package org.jsp.student_crud.controller;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.ResponseStructure;
import org.jsp.student_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_Controller {

	@Autowired
	StudentService service;

	@PostMapping("student")

	public ResponseStructure<Student> saveStudent(@RequestBody Student student) {

		return service.saveStudent(student);
	}

	@PostMapping("students")
	public ResponseStructure<List<Student>> saveStudents(@RequestBody List<Student> students) {
		return service.saveStudents(students);
	}

	@GetMapping("student")
	public ResponseStructure<Student> findById(@RequestParam int id) {
		return service.findById(id);
	}

	@GetMapping("studentname")
	public ResponseStructure<List<Student>> findByName(@RequestParam String name) {
		return service.findByName(name);
	}

	@GetMapping("studentmobile")
	public ResponseStructure<Student> findByMobile(@RequestParam long mobile) {
		return service.findByMobile(mobile);
	}

	@GetMapping("student/{id}")
	public ResponseStructure<Student> findByIdPv(@PathVariable int id) {
		return service.findById(id);
	}

	@GetMapping("students")
	public ResponseStructure<List<Student>> findAll() {
		return service.findAll();
	}

	@GetMapping("students/firstclass")
	public ResponseStructure<List<Student>> findFirstClass() {
		return service.findFirstClass();
	}

	@GetMapping("students/distiction")
	public ResponseStructure<List<Student>> findDistinction() {
		return service.findDistinction();
	}

	@GetMapping("students/fail")
	public ResponseStructure<List<Student>> findFailedStudents() {
		return service.findFailedStudents();
	}

	@DeleteMapping("student")
	public void deleteById(@RequestParam int id) {
		service.deleteById(id);
	}
}
