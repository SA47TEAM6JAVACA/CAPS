package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sg.iss.CAPS_TEAM6.model.Student;
import sg.iss.CAPS_TEAM6.services.ManageStudentService;

@Controller
@RequestMapping(value = "/AdminStudent")
public class ManagementStudentController {
	@Autowired
	ManageStudentService msservice;

	@RequestMapping(value = "/ManageStudent", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ArrayList<Student> slist = msservice.findAllStudent();
		ModelAndView mav = new ModelAndView("StudentCRUD");
		mav.addObject("Students", slist);
		return mav;
	}
	@RequestMapping(value="/newStudent", method = RequestMethod.GET)
    public ModelAndView newStudentPage() {
		ModelAndView mav = new ModelAndView("StudentFormNew", "Student", new Student());
		return mav;		
	}
	@RequestMapping(value="/newStudent", method = RequestMethod.POST)
    public ModelAndView newStudentPage(@ModelAttribute Student Student) {
		msservice.createStudent(Student);
		ArrayList<Student> slist = msservice.findAllStudent();
		ModelAndView mav = new ModelAndView("StudentCRUD");
		mav.addObject("Students", slist);
		return mav;	
	}
	
	@RequestMapping(value="/editStudent/{sid}", method = RequestMethod.GET)
    public ModelAndView editStudentPage(@PathVariable Integer sid) {
		Student Student = msservice.findStudentById(sid);
		ModelAndView mav = new ModelAndView("StudentFormEdit", "Student", Student);
		return mav;		
	}
	@RequestMapping(value="/editStudent/{sid}", method = RequestMethod.POST)
    public ModelAndView editStudentPage(@ModelAttribute Student Student,@PathVariable Integer sid) {
		msservice.updateStudent(Student);
		ArrayList<Student> slist = msservice.findAllStudent();
		ModelAndView mav = new ModelAndView("StudentCRUD");
		mav.addObject("Students", slist);
		return mav;
	}
	@RequestMapping(value="/deleteStudent/{sid}", method = RequestMethod.GET)
    public ModelAndView deleteStudentPage(@PathVariable Integer sid) {
		Student Student = msservice.findStudentById(sid);
		msservice.removeStudent(Student);
		ArrayList<Student> slist = msservice.findAllStudent();
		ModelAndView mav = new ModelAndView("StudentCRUD");
		mav.addObject("Students", slist);
		return mav;	
	}
}
