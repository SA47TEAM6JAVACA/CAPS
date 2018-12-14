package sg.iss.CAPS_TEAM6.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.CAPS_TEAM6.model.*;
import sg.iss.CAPS_TEAM6.repo.*;
import sg.iss.CAPS_TEAM6.services.*;

@RequestMapping(value = "/student")
@Controller
public class StudentEnrollController {

	@Autowired
	CourseService service;

	@Autowired
	StudentService sservice;

	@Autowired
	StudentCourseService scservice;
/*
	@ModelAttribute("courses")
	public ArrayList<Course> getCountryList() {

		return service.findAllCourse();
	}*/

	@RequestMapping(value = "/courselist", method = RequestMethod.GET)
	public ModelAndView listCourse() {
		ModelAndView mav = new ModelAndView("CourseList");
		ArrayList<Course> courselist = service.findAllcours();
		mav.addObject("courses", courselist);
		return mav;
	}
	
	
	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	public ModelAndView saveCourseEnroll(@ModelAttribute @Valid StudentCourse studentcourse,HttpSession ss) {
		ModelAndView mav = new ModelAndView("EnrollCourse");

		List<Course> courses = service.findAllCourse();
		ArrayList<String> cn = new ArrayList<>();
		for (Course course : courses) {
			cn.add(course.getCname());
		}
		int courseid = 0;
		

		String id=((MenuList)ss.getAttribute("USERSESSION")).getSessionId();
		
		
		
		Student s = sservice.findStudent(Integer.parseInt(id));
		
		double attendence = 0.0;
		System.out.println("course name " + studentcourse.getCourse().getCname());
Course cou=new Course();
		for (Course course : courses) {
			if (course.getCname().equalsIgnoreCase(studentcourse.getCourse().getCname()))
				{
				courseid = course.getCid();
				
				}
		}
		
		
		cou=service.findeCourse(courseid);
		int count=cou.getCurrentEnrollno()+1;
		cou.setCurrentEnrollno(count);
		System.out.println("course id "+cou.getCurrentEnrollno());
		
		
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();

		studentcourse.setAttendence(attendence);
		studentcourse.setStudent(s);
		studentcourse.setCourse(service.findeCourse(courseid));
		studentcourse.setEnrollDate(date);
		studentcourse.setScore(0.00);
		
		String message = "New studentcourse " + studentcourse.getScid() + " was successfully created.";

		scservice.createStudent(studentcourse);
		mav.setViewName("redirect:/student/enroll");
		
		
		service.editCourse(cou);
		

		// redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public ModelAndView saveEnrollCourse() {

		List<Course> courses = service.findAllCourse();
		ArrayList<String> cn = new ArrayList<>();
		for (Course course : courses) {
			cn.add(course.getCname());
		}

		System.out.println(getCurrentTimeUsingCalendar());

		System.out.println("Size of the course" + courses.size());
		ModelAndView mav = new ModelAndView("EnrollCourse");
		mav.addObject("courses", cn);

		// mav.addObject("listMapView",getMenu().getLink());

		mav.addObject("studentcourse", new StudentCourse());

		return mav;
	}

	public String getCurrentTimeUsingCalendar() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(date);

		return formattedDate;

	}

}
