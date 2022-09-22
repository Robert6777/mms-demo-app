package com.tsystems.mms.demoapp.exception_handling;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8654282130700525627L;
	

	public ResourceNotFoundException(String msg){
        super(msg);
    }

}
