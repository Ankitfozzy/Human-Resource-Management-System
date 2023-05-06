package com.masai.exceptions;

@SuppressWarnings("serial")
public class EmployeeNotFound extends Exception{
	public EmployeeNotFound(String message) {
		super(message);
	}
}
