package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.services.CourseService;
import sg.iss.CAPS_TEAM6.services.LecturerService;
import sg.iss.CAPS_TEAM6.services.ManageCourseService;
import sg.iss.CAPS_TEAM6.services.StudentCourseService;

@Controller
@RequestMapping(value = "/Admin")
public class ManagementCourseController {

	@Autowired
	ManageCourseService mcservice;
	
	@Autowired
	LecturerService lecturerservice;
	
	@Autowired
	CourseService courseservice;
	
	@Autowired
	StudentCourseService sService;

	@RequestMapping(value = "/ManageCourse", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ArrayList<Course> clist = mcservice.findAllCourse();
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		return mav;
	}

	@RequestMapping(value = "/newCourse", method = RequestMethod.GET)
	public ModelAndView newCoursePage() {
		ModelAndView mav = new ModelAndView("CourseFormNew", "course", new Course());
		return mav;
	}

	@RequestMapping(value = "/newCourse", method = RequestMethod.POST)
	public ModelAndView newCoursePage(@ModelAttribute Course course) {
		mcservice.createCourse(course);
		ArrayList<Course> clist = mcservice.findAllCourse();
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		return mav;
	}

	@RequestMapping(value = "/editCourse/{cid}", method = RequestMethod.GET)
	public ModelAndView editCoursePage(@PathVariable Integer cid) {
		Course course = mcservice.findCourseById(cid);
		ModelAndView mav = new ModelAndView("CourseEdit", "course", course);
		ArrayList<Lecturer> llist = mcservice.findAlllecturer();
		mav.addObject("llist", llist);
		return mav;
	}

	@RequestMapping(value = "/editCourse/{cid}", method = RequestMethod.POST)
	public ModelAndView editCoursePage(@ModelAttribute Course course, @PathVariable Integer cid) {
		mcservice.updateCourse(course);
		ArrayList<Course> clist = mcservice.findAllCourse();
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		return mav;
	}

	@RequestMapping(value = "/deleteCourse/{cid}", method = RequestMethod.GET)
	public ModelAndView deleteCoursePage(@PathVariable Integer cid) {
		Course course = mcservice.findCourseById(cid);
		mcservice.removeCourse(course);
		ArrayList<Course> clist = mcservice.findAllCourse();
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		return mav;
	}
	@RequestMapping(value = "/addlecturer/{cid}", method = RequestMethod.GET)
	public ModelAndView addLecturerPage(@PathVariable Integer cid) {
		Course course = mcservice.findCourseById(cid);
		ModelAndView mav = new ModelAndView("CourseLecturerNew", "course", course);
		ArrayList<Lecturer> llist = mcservice.findAlllecturer();
		ArrayList<Lecturer> lclist = sService.listLecturerByCourseID(cid);
		mav.addObject("llist", llist);
		mav.addObject("lclist", lclist);
		return mav;
	}
	
	@RequestMapping(value = "/addlecturer/{cid}/{lid}", method = RequestMethod.GET)
	public ModelAndView addCourselecturerPage(@PathVariable Integer cid,@PathVariable Integer lid) {
		Lecturer lecturer = lecturerservice.FindLecturer(lid);
		Course course = courseservice.FindCourse(cid);
		lecturerservice.lecturerAddCourses(lecturer, course);
		ArrayList<Course> clist = mcservice.findAllCourse();
		
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		
		return mav;
	}
}
