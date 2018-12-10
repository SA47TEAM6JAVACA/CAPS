package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.CAPS_TEAM6.model.*;
import sg.iss.CAPS_TEAM6.repo.*;
import sg.iss.CAPS_TEAM6.services.*;

@RequestMapping(value = "/student")
@Controller
public class StudentEnrollController {
	
	@Autowired
	CourseService service;
	
	@RequestMapping(value = "/enrollcourse", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("EnrollCourse");
		ArrayList<Course> courses = service.findAllCourse();
		mav.addObject("courses", courses);
		return mav;
	}
	
	
}
