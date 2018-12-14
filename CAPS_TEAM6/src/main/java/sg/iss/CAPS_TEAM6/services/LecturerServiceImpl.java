package sg.iss.CAPS_TEAM6.services;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.repo.LecturerRepository;
import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Resource
	LecturerRepository lrepo;
	
	@Override
	public ArrayList<Lecturer> findAllenrols() {
		ArrayList<Lecturer> llist=(ArrayList<Lecturer>)lrepo.findAll();
		return llist;
	}
	@Override
	public Lecturer FindLecturer(int lid) {
		
		return lrepo.findById(lid).get();
	}

	@Override
	public Lecturer CreateLecturer(Lecturer l) {
		lrepo.save(l);
		return null;
	}

	@Override
	public Lecturer UpdateLecturer(Lecturer l) {
		lrepo.saveAndFlush(l);
		return null;
	}

	@Override
	public void RemoveLecturer(Lecturer l) {
		lrepo.delete(l);

	}
	
	@Override
	public void lecturerAddCourses(Lecturer l, Course courses) {
		l.getCourses().add(courses);
		courses.getLecturers().add(l);
		lrepo.save(l);
	}
	
		
		@Override
	public ArrayList<String> findAllLecturerIDs(){
	    return lrepo.findAllLecturerIDs();
		}

}
