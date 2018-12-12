package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.services.LecturerService;

@Controller
@RequestMapping(value="/lecturer")
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
	
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public ModelAndView newLecturerPage() {
		ModelAndView mav = new ModelAndView("LecturerNewForm", "lecturer", new Lecturer());
		return mav;
		
	}
	
	
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ModelAndView newLecturerPage(@ModelAttribute Lecturer lecturer)
	{
		lecturerservice.UpdateLecturer(lecturer);
		ModelAndView mav = new ModelAndView("LectureCRUD");
		ArrayList<Lecturer> llist=lecturerservice.findAllenrols();
		mav.addObject("lecturers",llist);
		return mav;
	}
	
	@RequestMapping(value="/edit/{lid}",method=RequestMethod.GET)
	public ModelAndView editLecturerPage(@PathVariable Integer lid)
	{
		Lecturer lecturer=lecturerservice.FindLecturer(lid);
		ModelAndView mav=new ModelAndView("LecturerEditForm","lecturer",lecturer);
		return mav;
	}
	@RequestMapping(value="/edit/{lid}",method=RequestMethod.POST)
	public ModelAndView editLecturerPage(@PathVariable Integer lid,@ModelAttribute Lecturer lecturer)
	{
		lecturerservice.UpdateLecturer(lecturer);
		ModelAndView mav = new ModelAndView("LectureCRUD");
		ArrayList<Lecturer> llist=lecturerservice.findAllenrols();
		mav.addObject("lecturers",llist);
		return mav;
	}
	
	@RequestMapping(value="/delete/{lid}",method=RequestMethod.GET)
	public ModelAndView deleteLecturer(@PathVariable Integer lid)
	{
		Lecturer lecturer=lecturerservice.FindLecturer(lid);
		lecturerservice.RemoveLecturer(lecturer);
		ModelAndView mav = new ModelAndView("LectureCRUD");
		ArrayList<Lecturer> llist=lecturerservice.findAllenrols();
		mav.addObject("lecturers",llist);
		return mav;
	}
}
