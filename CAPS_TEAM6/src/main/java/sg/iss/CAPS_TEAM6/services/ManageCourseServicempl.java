package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.repo.ManageCourseRepo;
import sg.iss.CAPS_TEAM6.repo.lecturerrepo;

@Service
public class ManageCourseServicempl implements ManageCourseService {

	@Resource
	ManageCourseRepo crepo;
	
	@Resource
	lecturerrepo lrepo;

	@Override
	public ArrayList<Course> findAllCourse() {
		ArrayList<Course> clist = (ArrayList<Course>)crepo.findAll();
		return clist;
	}

	@Override
	public Course findCourseById(Integer cid) {		
		return crepo.findById(cid).get();
	}

	@Override
	public ArrayList<Course> findCoursesByCriteria(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createCourse(Course c) {		
		crepo.save(c);
		return 0;
	}

	@Override
	public int updateCourse(Course c) {
		crepo.saveAndFlush(c);
		return 0;
	}

	@Override
	public int removeCourse(Course c) {
		crepo.delete(c);
		return 0;
	}

	@Override
	public ArrayList<Lecturer> findAlllecturer() {
		return lrepo.findAllLecturerID();
	}

	@Override
	public int addCourseLecturer(Lecturer l) {
		// TODO Auto-generated method stub
		return 0;
	}

}
