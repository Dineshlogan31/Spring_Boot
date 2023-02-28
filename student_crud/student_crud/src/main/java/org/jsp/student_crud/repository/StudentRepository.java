package org.jsp.student_crud.repository;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	Student findByMobile(long mobile);
    @Query("select x from Student x where percentage >= 60 AND percentage <85")
	List<Student> findFirstClass();
    @Query("select x from Student x where percentage >=90")
	List<Student> findDistinction();
    @Query("select x from Student x where percentage < 40")
	List<Student> findFailedStudents();

}
