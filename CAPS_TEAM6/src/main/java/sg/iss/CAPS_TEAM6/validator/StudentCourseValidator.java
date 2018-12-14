package sg.iss.CAPS_TEAM6.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import sg.iss.CAPS_TEAM6.model.StudentCourse;
@Component
public class StudentCourseValidator implements Validator {


	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return StudentCourse.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		StudentCourse studentcourse=(StudentCourse)target;
	ValidationUtils.rejectIfEmpty(errors, "score", "Score can't be empty");

        double d=studentcourse.getScore();

		if(d>100||d<0){
			errors.rejectValue("score", null, "Score range: 0-100");
		}
//		if(d>100||d<0){
//			errors.rejectValue("score", null, "Score out of range");
//			}
//		System.out.println(studentcourse.toString());

	}

}
