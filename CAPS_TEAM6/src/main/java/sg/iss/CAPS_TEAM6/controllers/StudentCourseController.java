package sg.iss.CAPS_TEAM6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.iss.CAPS_TEAM6.services.StudentCourseService;



@RequestMapping(value = "/StudentCourse")
@Controller
public class StudentCourseController {

	@Autowired
	StudentCourseService sService;
	// @Autowired
	// private StudentValidator sValidator;
	
   //@InitBinder("student")
   //private void initDepartmentBinder(WebDataBinder binder) {
   //		binder.addValidators(sValidator);
   //	}

	/*@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("ManageEnrol");
		ArrayList<StudentCourse> enrolment = sService.findAllenrols();
		mav.addObject("enrolments", enrolment);
		return mav;
	}*/
	
	
}
