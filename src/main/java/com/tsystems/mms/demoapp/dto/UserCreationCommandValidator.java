package com.tsystems.mms.demoapp.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserCreationCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		 return UserCreationCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 UserCreationCommand command = (UserCreationCommand) target;
		 if(command.getEmail()==null) {
			 errors.rejectValue("email", "Your E-mail address cannot be empty!");
		 }else if(!command.getEmail().contains("@")) {
			 errors.rejectValue("email", "Your E-mail address seems to be incorrect!");
		 }
		
	}

	

}
