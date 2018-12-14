package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.CAPS_TEAM6.services.CourseService;
import sg.iss.CAPS_TEAM6.services.StudentCourseService;

import sg.iss.CAPS_TEAM6.validator.StudentCourseValidator;

import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Student;
import sg.iss.CAPS_TEAM6.model.StudentCourse;


@RequestMapping(value = "/StudentCourse")
@Controller
public class StudentCourseController {

	@Autowired
	StudentCourseService sService;

	 @Autowired
	 private StudentCourseValidator scValidator;

	
	@Autowired
	CourseService courseservice;
	// @Autowired
	// private StudentValidator sValidator;

	
   @InitBinder("studentcourse")
   private void initStudentCourseBinder(WebDataBinder binder)
   {
   	binder.addValidators(scValidator);
   }

   
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

	@RequestMapping(value = "/listgrade", method = RequestMethod.POST)
	public ModelAndView QQlistGrade(@Valid @ModelAttribute ("studentcourse") StudentCourse studentcourse,
			BindingResult result,final RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors())
			return new ModelAndView("Grade");
		
		sService.createStudent(studentcourse);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/StudentCourse/listgrade");

		return mav;
	}

	


	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView ffeditGrade(@PathVariable Integer id) {
		StudentCourse studentcourse=sService.findStudentCourseBySCID(id);
		ModelAndView mav=new ModelAndView("Grade","studentcourse",studentcourse);
		return mav;
		
	
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editGrade(@Valid @ModelAttribute ("studentcourse") StudentCourse studentcourse,
			BindingResult result,final RedirectAttributes redirectAttributes) {

		if(result.hasErrors())
		{
			return new ModelAndView("ListGrade");
		}
		sService.createStudent(studentcourse);
		redirectAttributes.addFlashAttribute("message", "Error Rediection");
		ModelAndView mav = new ModelAndView();
		return mav;
		

	}
	
	@RequestMapping(value = "/viewper", method = RequestMethod.GET)
	public ModelAndView viewper(HttpSession sess) {
		
		MenuList usrsession=new MenuList();
		usrsession=(MenuList) sess.getAttribute("USERSESSION");
		
		
		ArrayList<StudentCourse> elist = new ArrayList<StudentCourse>();
		elist = sService.viewGrade(Integer.valueOf(usrsession.getSessionId()));
		ModelAndView mav = new ModelAndView("ViewPerformance");
		mav.addObject("elist",elist);
		return mav;
	}
	

	
	@RequestMapping(value = "/listgrade/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editGrade(@ModelAttribute StudentCourse elist) {
		sService.updateStudent(elist);
		ModelAndView mav = new ModelAndView();
		return mav;
	}

	
	
	
	@RequestMapping(value = "/Manageenrol/{id}", method = RequestMethod.GET)
	public ModelAndView ManageEnrol(@PathVariable String name, @ModelAttribute  @Valid  StudentCourse studentcourse) {
		ArrayList<StudentCourse> elist = new ArrayList<StudentCourse>();
		
		
		
		elist = sService.gradeCourse(1);

		elist = sService.getCoursebyname(name);

		ModelAndView mav = new ModelAndView("DeleteEnrollment");
		mav.addObject("elist",elist);
		
		
		
		ArrayList<Course> courselist= courseservice.findAllcours();
		ArrayList<String> cname=new ArrayList<>();
		ArrayList<Integer> cid=new ArrayList<>();
		for(Course c   :courselist)
		{
			cname.add(c.getCname());
			cid.add(c.getCid());
		}
		//mav.addObject("courselist", cid);
		
		
		int testcid=0;
		
		for(Course c   :courselist)
		{
			if(studentcourse.getCourse().getCname().equalsIgnoreCase(c.getCname()))
			testcid=c.getCid();
		}
		
		studentcourse.getCourse().setCid(testcid);

		mav.addObject("courseid",testcid);
		mav.addObject("courselist", cname);
	
		
		return mav;
	}
	
	@RequestMapping(value = "/Manageenrol/{id}/delete/{scid}", method = RequestMethod.GET)
	public ModelAndView deleteEnrol(@PathVariable Integer scid,@PathVariable Integer id) {
		StudentCourse list=sService.findStudentCourseBySCID(scid);
		sService.removeStudent(list);
		ArrayList<StudentCourse> elist = new ArrayList<StudentCourse>();
		elist = sService.gradeCourse(id);
		ModelAndView mav = new ModelAndView("DeleteEnrollment");
		mav.addObject("elist",elist);
		return mav;
	}
	
	
/*	@RequestMapping(value = "/selectcourse/{id}", method = RequestMethod.GET)
	public ModelAndView listStudent(@PathVariable Integer id) {
		ArrayList<Student> slist = new ArrayList<Student>();
		slist = sService.listStudentsEnrolledForCourse(id);
		ModelAndView mav = new ModelAndView("ListStudentEnrolledForCourse");
		mav.addObject("slist",slist);
		return mav;
	}
	*/
	
	@RequestMapping(value = "/listCoursesTaughtByLecturer", method = RequestMethod.GET)
	public ModelAndView list(HttpSession session) {
		MenuList menu=(MenuList)session.getAttribute("USERSESSION");
		ArrayList<Course> clist = new ArrayList<Course>();
		ModelAndView mav = new ModelAndView("listCoursesTaughtByLecturer");
     	clist = sService.listCoursesTaughtByLecturer(1);
	    mav.addObject("clist",clist);
		return mav;

	}

	
	
	@RequestMapping(value = "/selectcourse", method = RequestMethod.POST)
	public ModelAndView SelectLecturerPage(@ModelAttribute  @Valid  StudentCourse studentcourse) {
		ModelAndView mav = new ModelAndView("DeleteEnrollment") ;
		ArrayList<Course> courselist= courseservice.findAllcours();
		ArrayList<String> cname=new ArrayList<>();
		ArrayList<Integer> cid=new ArrayList<>();
		for(Course c   :courselist)
		{
			cname.add(c.getCname());
			cid.add(c.getCid());
		}
		mav.addObject("courselist", cname);
		//mav.addObject("courselist", cid);
		
		
		int testcid=0;
		
		for(Course c   :courselist)
		{
			if(studentcourse.getCourse().getCname().equalsIgnoreCase(c.getCname()))
			testcid=c.getCid();
		}
		
		return mav;
	}
		
	 @RequestMapping(value = "/selectcourse",method=RequestMethod.GET)
	  public ModelAndView listbook() {
	  List<Course> courses = courseservice.findAllcours();
	  ArrayList<String> cn=new ArrayList<>();
		  for (Course course : courses) {
			cn.add(course.getCname());  
		  }
		  ModelAndView mav = new ModelAndView("select","Course",courses);
			 mav.addObject("courses", cn); 
			 mav.addObject("studentcourse", new StudentCourse());
		return mav;
	}
	

}
