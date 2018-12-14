package sg.iss.CAPS_TEAM6.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sg.iss.CAPS_TEAM6.model.Admin;
import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.model.Student;
import sg.iss.CAPS_TEAM6.services.AdminService;
import sg.iss.CAPS_TEAM6.services.LecturerService;
import sg.iss.CAPS_TEAM6.services.StudentService;
import sg.iss.CAPS_TEAM6.validator.LoginValidator;

@RequestMapping(value = "/common")
@Controller
public class CommonController {

	@Autowired
	StudentService service;

	@Autowired
	LecturerService lservice;

	@Autowired
	StudentService sservice;

	@Autowired
	AdminService adservice;
	
	
	@Autowired
	LoginValidator lv;
	
	
	@InitBinder("LoginValidator")
	private void initLogin(WebDataBinder binder) {
		
		binder.addValidators(lv);
		
	}
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Model model) {

		return new ModelAndView("home");
	}

	@RequestMapping(value = "/login/{role}", method = RequestMethod.GET)
	public ModelAndView login( @ModelAttribute UserSession user,@PathVariable("role") String role, HttpSession session) {
		ModelAndView mav = new ModelAndView("login");
		
		user.setRole(role);

		mav.addObject("user", new UserSession());

		/*MenuList ml = getMenu(role);
		ml.setSessionId("user");

		session.setAttribute("USERSESSION", ml);
*/
		return mav;
	}

	@RequestMapping(value = "/authenticate/{role}", method = RequestMethod.POST)
	public ModelAndView logic( @Valid  @ModelAttribute("user") UserSession user,
			@PathVariable("role") String role, HttpSession session,BindingResult result,final  RedirectAttributes redirectAttibutes) {
		
		String error="";
		ModelAndView mav=new ModelAndView("login/"+role) ;
		if (result.hasErrors())
			{error="Error";
			return new ModelAndView("redirect:/common/home");
			}
		
		System.out.println("user authentication : " + user.getUsername() + role);

		mav = authenticate(user, role);
		mav.addObject("user", user);
		

		MenuList ml = getMenu(role);
		ml.setSessionId(String.valueOf(service.findID(user.getUsername())));
		
		session.setAttribute("USERSESSION", ml);
redirectAttibutes.addFlashAttribute("message",error);


		return mav;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav;
		session.removeAttribute("USERSESSION");
		mav = new ModelAndView("redirect:/common/home");
		return mav;
	}

	private ModelAndView authenticate(UserSession user, String role) {

		if (role.equalsIgnoreCase("student")) {
			List<Student> allstu;
			allstu = service.findallstu();

			for (Student student : allstu) {
				if (student.getSemail().equalsIgnoreCase(user.getUsername()))
					return new ModelAndView("redirect:/student/enroll");
			}
		} else if (role.equalsIgnoreCase("admin")) {
			List<Admin> alladmin;
			alladmin = adservice.findAllAdmin();

			for (Admin student : alladmin) {
				if (student.getAemail().equalsIgnoreCase(user.getUsername()))
					return new ModelAndView("redirect:/student/enroll");
			}
		} else if (role.equalsIgnoreCase("lecturer")) {
			List<Lecturer> alllect;
			alllect = lservice.findAllenrols();

			for (Lecturer student : alllect) {
				if (student.getLemail().equalsIgnoreCase(user.getUsername()))
					return new ModelAndView("redirect:/lecturer/list");
			}
		}

		return new ModelAndView("redirect/common/home");
	}

	public MenuList getMenu(String role) {
		MenuList ml = new MenuList();

		ArrayList<String> linkname = new ArrayList<>();

		HashMap<String, String> h=null;

		if (role.equalsIgnoreCase("admin")) {
		
			h = new HashMap<>();
			h.put("Manage Students", "/login.html");
			h.put("Manage Lecturers", "/login.html");
			h.put("Manage Courses", "CAPS_TEAM6/student/enroll");
			h.put("Manage Enrolment", "CAPS_TEAM6/student/enroll");

			h.put("Log Out", "http://localhost:8080/CAPS_TEAM6/common/home");

		} else if (role.equalsIgnoreCase("student")) {
			h = new HashMap<>();
			
			h.put("Grades and GPA", "/login.html");
			h.put("View Courses", "/login.html");
			h.put("Enroll for a Course", "http://localhost:8080/CAPS_TEAM6/student/enroll");
			h.put("Logout", "http://localhost:8080/CAPS_TEAM6/common/home");

		} else if (role.equalsIgnoreCase("lecturer")) {

			
			h = new HashMap<>();
			h.put("View Courses Taught", "/lecturer/list");
			h.put("View Course Enrolment", "/login.html");
			h.put("Grade a Course", "CAPS_TEAM6/student/enroll");
			h.put("View a Student Performance", "CAPS_TEAM6/student/enroll");
			h.put("Log Out", "http://localhost:8080/CAPS_TEAM6/common/home");

		}

		ml.setLink(h);

		return ml;
	}

}
