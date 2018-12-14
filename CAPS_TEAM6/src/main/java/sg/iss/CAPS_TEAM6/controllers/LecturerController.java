package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.services.LecturerService;
import sg.iss.CAPS_TEAM6.validator.LecturerValidator;

@Controller
@RequestMapping(value="/lecturer")
public class LecturerController {
@Autowired
LecturerService lecturerservice;
	
@Autowired
private LecturerValidator lValidator;

@InitBinder
private void initLecturerBinder(WebDataBinder binder)
{
	binder.addValidators(lValidator);
}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView mav = new ModelAndView("LectureCRUD");
		ArrayList<Lecturer> llist=lecturerservice.findAllenrols();
		mav.addObject("lecturers",llist);
		return mav;
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ModelAndView neffwLecturerPage(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			final RedirectAttributes redirectAttributes)
	{
		if(result.hasErrors())
			return new ModelAndView("LecturerEditForm");
		lecturerservice.CreateLecturer(lecturer);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/lecturer/list");
		return mav;
	}
	
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public ModelAndView newLecturerPage() {
		ModelAndView mav = new ModelAndView("LecturerNewForm", "lecturer", new Lecturer());
		return mav;
		
	}
	
//	@RequestMapping(value="/new",method=RequestMethod.POST)
//	public ModelAndView newLecturerPage(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
//			final RedirectAttributes redirectAttributes)
//	{
//		if(result.hasErrors())
//			return new ModelAndView("LecturerNewForm");
//		lecturerservice.CreateLecturer(lecturer);
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("redirect:/lecturer/list");
//		return mav;
//	}
	
	@RequestMapping(value="/edit/{lid}",method=RequestMethod.GET)
	public ModelAndView editLecturerPage(@PathVariable Integer lid)
	{
		Lecturer lecturer=lecturerservice.FindLecturer(lid);
		ModelAndView mav=new ModelAndView("LecturerEditForm","lecturer",lecturer);
		return mav;
	}
	
	@RequestMapping(value="/edit/{lid}",method=RequestMethod.POST)
	public ModelAndView editLecturerPage(@ModelAttribute @Valid Lecturer lecturer, BindingResult result,
			final RedirectAttributes redirectAttributes)
	{
		
		if(result.hasErrors())
		{System.err.println("dwaojdoapiwdjqwdjqopdjwqpdjqpdijqodjwqidqd");
			return new ModelAndView("LecturerEditForm");}
		lecturerservice.CreateLecturer(lecturer);
		ModelAndView mav=new ModelAndView();
		redirectAttributes.addFlashAttribute("message", "Error Rediection");
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
