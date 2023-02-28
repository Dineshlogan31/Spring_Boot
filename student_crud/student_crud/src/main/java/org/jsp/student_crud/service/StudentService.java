package org.jsp.student_crud.service;

import java.util.List;

import org.jsp.student_crud.dao.StudentDao;
import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;
	ResponseStructure<Student> structure=new ResponseStructure<>();

	public ResponseStructure<Student> saveStudent(Student student) {
		student.setPercentage(
				((student.getEnglish_marks() + student.getHindi_marks() + student.getMaths_marks()) * 100) / 300);
		ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setMessage("Data Saved SuccessFully");
		 structure.setData(dao.saveStudent(student));
		 structure.setCode(HttpStatus.CREATED.value());
		 return structure;
	}

	public ResponseStructure<List<Student>> saveStudents(List<Student> students) {
		for (Student student : students) {
			student.setPercentage(
					((student.getEnglish_marks() + student.getHindi_marks() + student.getMaths_marks()) * 100) / 300);
		}
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		structure.setMessage("Datas Saved SuccessFully");
		structure.setData(dao.saveStudents(students));
		structure.setCode(HttpStatus.CREATED.value());
		return structure;
		
	}

	public ResponseStructure<Student> findById(int id) {
		
		Student student=dao.findById(id);
		ResponseStructure<Student> structure=new ResponseStructure<>();
		if(student==null)
		{
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
			
		}
		else
		{
			structure.setMessage("Data Found");
			structure.setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Student>> findByName(String name) {
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		List<Student> student=dao.findByName(name);
		if(student==null)
		{
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else
		{
			structure.setMessage("Data Found");
			structure.setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<Student> findByMobile(long mobile) {
		ResponseStructure<Student> structure=new ResponseStructure<>();
		Student student=dao.findByMobile(mobile);
		if(student==null)
		{
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else
		{
			structure.setMessage("Data Found");
			structure.setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Student>> findAll() {
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		List<Student> student=dao.findAll();
		if(student==null)
		{
			structure.setMessage("Data Not Exist");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else
		{
			structure.setMessage("Data Found");
			structure.setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;

}

	public ResponseStructure<List<Student>> findFirstClass() {
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		List<Student> student=dao.findFirstClass();
		if(student==null)
		{
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else
		{
			structure.setMessage("Data Found");
			structure.setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Student>> findDistinction() {
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		List<Student> student=dao.findDistinction();
		if(student==null)
		{
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else
		{
			structure.setMessage("Data Found");
			structure.setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public ResponseStructure<List<Student>> findFailedStudents() {
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		List<Student> student=dao.findFailedStudents();
		if(student==null)
		{
			structure.setMessage("Data Not Found");
			structure.setData(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
		}
		else
		{
			structure.setMessage("Data Found");
			structure.setData(student);
			structure.setCode(HttpStatus.FOUND.value());
		}
		return structure;
	}

	public void deleteById(int id) {
		 dao.deleteById(id);
	}
}
