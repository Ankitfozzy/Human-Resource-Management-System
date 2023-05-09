package com.masai.exceptions;

@SuppressWarnings("serial")
public class SomeThingWentWrongException extends Exception{
	public SomeThingWentWrongException(String message){
		super(message);
	}
}
