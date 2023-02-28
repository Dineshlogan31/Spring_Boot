package org.jsp.student_crud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	public List<Student> saveStudents(List<Student> students) {
		return repository.saveAll(students);
	}

	public Student findById(int id) {
		
		 Optional<Student> op=repository.findById(id);
		 if(op.isPresent())
		 {
			 return op.get();
		 }
		 else
		 {
			 return null;
		 }
	}

	public List<Student> findByName(String name) {
		
		
		return repository.findByName(name);
	}

	public Student findByMobile(long mobile) {
		return repository.findByMobile(mobile);
	}

	public List<Student> findAll() {
		return repository.findAll();
	}

	public List<Student> findFirstClass() {
		return repository.findFirstClass();
	}

	public List<Student> findDistinction() {
		 return repository.findDistinction();
	}

	public List<Student> findFailedStudents() {
		return repository.findFailedStudents();
	}

	public void deleteById(int id) {
		 repository.deleteById(id);
	}
}
