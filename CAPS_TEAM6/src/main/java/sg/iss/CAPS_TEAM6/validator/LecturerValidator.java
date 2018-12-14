package sg.iss.CAPS_TEAM6.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.iss.CAPS_TEAM6.model.Lecturer;

@Component
public class LecturerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Lecturer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Lecturer lecturer=(Lecturer)target;
		ValidationUtils.rejectIfEmpty(errors, "lpassword", "Password can't be empty");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "Last can't be empty");
		ValidationUtils.rejectIfEmpty(errors, "lemail", "Email can't be empty");
		ValidationUtils.rejectIfEmpty(errors, "firstmiddlename", "First can't be empty");
		
		if(!lecturer.getLemail().contains("@")){
			errors.rejectValue("lemail", null, "Email should contain @");
			}
		if(lecturer.getLpassword().length()<4){
			errors.rejectValue("lpassword", null, "Password's length should be more than 4 strings");
			}
		
		System.out.println(lecturer.toString());

	}

}
