package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/listgrade", method = RequestMethod.GET)
	public ModelAndView listGrade() {
		ArrayList<StudentCourse> elist = new ArrayList<StudentCourse>();
		elist = sService.gradeCourse(1);
		ModelAndView mav = new ModelAndView("ListGrade");
		mav.addObject("elist",elist);
		return mav;
	}
	
	@RequestMapping(value = "/listgrade/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editGrade(@PathVariable Integer id) {
		ArrayList<StudentCourse> elist = new ArrayList<StudentCourse>();
		elist = sService.gradeCourse(id);
		ModelAndView mav = new ModelAndView("Grade","StudentCourse",elist);
		mav.addObject("elist",elist);
		return mav;
	}
	
	@RequestMapping(value = "/listgrade/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editGrade(@ModelAttribute StudentCourse elist) {
		sService.updateStudent(elist);
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value = "/ListStudentEnrolledForCourse", method = RequestMethod.GET)
	public ModelAndView listStudent() {
		ArrayList<Student> slist = new ArrayList<Student>();
		slist = sService.listStudentsEnrolledForCourse(1);
		ModelAndView mav = new ModelAndView("ListStudentEnrolledForCourse");
		mav.addObject("slist",slist);
		return mav;
	}
	@RequestMapping(value = "/listCoursesTaughtByLecturer", method = RequestMethod.GET)
	public ModelAndView list() {
		ArrayList<Course> clist = new ArrayList<Course>();
		ModelAndView mav = new ModelAndView("listCoursesTaughtByLecturer");
     	clist = sService.listCoursesTaughtByLecturer(1);
	    mav.addObject("clist",clist);
		return mav;
	}
}
