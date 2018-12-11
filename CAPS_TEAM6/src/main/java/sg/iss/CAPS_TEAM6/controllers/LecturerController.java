package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.model.StudentCourse;
import sg.iss.CAPS_TEAM6.services.LecturerService;

@Controller
@RequestMapping(value="/Lecturer")
public class LecturerController {
@Autowired
LecturerService lecturerservice;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("LectureCRUD");
		ArrayList<Lecturer> llist=lecturerservice.findAllenrols();
		mav.addObject("lecturers",llist);
		return mav;
	}
	
}
