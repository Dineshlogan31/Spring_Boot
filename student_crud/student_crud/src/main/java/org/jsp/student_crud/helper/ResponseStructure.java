package org.jsp.student_crud.helper;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	int code;
	String message;
	T data;

}
