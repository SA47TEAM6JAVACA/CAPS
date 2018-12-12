package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.CAPS_TEAM6.model.StudentCourse;
import sg.iss.CAPS_TEAM6.services.StudentCourseService;
import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Student;



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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("ManageEnrol");
		ArrayList<StudentCourse> enrolment = sService.findAllenrols();
		mav.addObject("enrolments", enrolment);
		return mav;
	}
	
	@RequestMapping(value = "/listStudent", method = RequestMethod.GET)
	public ModelAndView listStudent() {
		ArrayList<StudentCourse> elist = new ArrayList<StudentCourse>();
		ArrayList<Student> slist = new ArrayList<Student>();
		ArrayList<Course> clist = new ArrayList<Course>();
		ModelAndView mav = new ModelAndView("Enrollment");
		slist = sService.listStudentsEnrolledForCourse(1);
//		clist = sService.listCoursesTaughtByLecturer(1);
		elist = sService.gradeCourse(1);
//		mav.addObject("clist",clist);
		mav.addObject("slist",slist);
		mav.addObject("elist",elist);
		return mav;
	}
}
