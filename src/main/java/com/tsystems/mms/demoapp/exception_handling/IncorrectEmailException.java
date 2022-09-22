package com.tsystems.mms.demoapp.exception_handling;

public class IncorrectEmailException extends RuntimeException {

	
	public IncorrectEmailException(String msg){
        super(msg);
    }
}
