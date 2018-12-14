package sg.iss.CAPS_TEAM6.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.CAPS_TEAM6.controllers.UserSession;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserSession.class.isAssignableFrom(clazz);
	}

	public LoginValidator() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UserSession user=(UserSession)target;
		ValidationUtils.rejectIfEmpty(errors, "username", "Fill username");
		ValidationUtils.rejectIfEmpty(errors, "pass", "Fill password");
		
		
		errors.rejectValue("username", "type password");

	}

}
