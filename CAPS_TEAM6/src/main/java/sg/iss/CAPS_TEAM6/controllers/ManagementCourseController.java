package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.services.ManageCourseService;

@Controller
@RequestMapping(value = "/Admin")
public class ManagementCourseController {

	@Autowired
	ManageCourseService mcservice;

	@RequestMapping(value = "/ManageCourse", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ArrayList<Course> clist = mcservice.findAllCourse();
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		return mav;
	}
	@RequestMapping(value="/newCoures", method = RequestMethod.GET)
    public ModelAndView newCoursePage() {
		ModelAndView mav = new ModelAndView("CourseFormNew", "course", new Course());
		return mav;		
	}
	@RequestMapping(value="/newCoures", method = RequestMethod.POST)
    public ModelAndView newCoursePage(@ModelAttribute Course course) {
		mcservice.updateCourse(course);
		ArrayList<Course> clist = mcservice.findAllCourse();
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		return mav;	
	}
	@RequestMapping(value="/editCoures/{cid}", method = RequestMethod.GET)
    public ModelAndView editCoursePage(@PathVariable Integer cid) {
		Course course = mcservice.findCourseById(cid);
		ModelAndView mav = new ModelAndView("CourseEdit", "course", course);
		return mav;		
	}
	@RequestMapping(value="/editCoures/{cid}", method = RequestMethod.POST)
    public ModelAndView editCoursePage(@PathVariable Integer cid,@ModelAttribute Course course) {
		mcservice.updateCourse(course);
		ArrayList<Course> clist = mcservice.findAllCourse();
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		return mav;	
	}
	@RequestMapping(value="/deleteCoures/{cid}", method = RequestMethod.POST)
    public ModelAndView deleteCoursePage(@PathVariable Integer cid) {
		Course course = mcservice.findCourseById(cid);
		mcservice.removeCourse(course);
		ArrayList<Course> clist = mcservice.findAllCourse();
		ModelAndView mav = new ModelAndView("CourseCRUD");
		mav.addObject("courses", clist);
		return mav;	
	}
}
