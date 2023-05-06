package com.masai.exceptions;

@SuppressWarnings("serial")
public class DepartmentNotFound extends Exception{
	public DepartmentNotFound(String message) {
		super(message);
	}
}
