package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	

	  @ModelAttribute("courses")
	   public ArrayList<Course> getCountryList() {
		  
	      return  service.findAllCourse();
	   }
	  
	  @RequestMapping(value = "/enroll",method=RequestMethod.POST)
	  public ModelAndView saveBook(@ModelAttribute  @Valid  StudentCourse studentcourse) {
		  ModelAndView mav = new ModelAndView("EnrollCourse");

			//sService.createStudent(student);
			//String message = "New student " + student.getNric() + " was successfully created.";
		  List<Course> courses = service.findAllCourse();
		  ArrayList<String> cn=new ArrayList<>();
		  for (Course course : courses) {
			cn.add(course.getCname());
		}		  
		 int courseid=0;
		 Student s=sservice.findStudent(1);
		 double attendence=0.0; 
		 System.out.println("course name "+studentcourse.getCourse().getCname());
		  
		 for (Course course : courses) {
		 if(course.getCname().equalsIgnoreCase(studentcourse.getCourse().getCname()))
			 courseid=course.getCid();
		 }
		
		 studentcourse.setAttendence(attendence);
		 studentcourse.setStudent(s);
		 studentcourse.setCourse(service.findeCourse(courseid));
		
	
			String message = "New studentcourse " +studentcourse.getScid() + " was successfully created.";

			scservice.createStudentCourse(studentcourse);
			mav.setViewName("redirect:/student/enroll");

			//redirectAttributes.addFlashAttribute("message", message);
			return mav;
		  }
	  
	
	  
	  @RequestMapping(value = "/enroll",method=RequestMethod.GET)
	  public ModelAndView listBooks() {
	
	  List<Course> courses = service.findAllCourse();
	  ArrayList<String> cn=new ArrayList<>();
	  for (Course course : courses) {
		cn.add(course.getCname());
	}
	  
	  
	  System.out.println("Size of the course"+courses.size());
	  ModelAndView mav = new ModelAndView("EnrollCourse");
	 mav.addObject("courses", cn);
	 
	 
	 mav.addObject("studentcourse", new StudentCourse());
	  
	  return mav;
	  }
	  
}