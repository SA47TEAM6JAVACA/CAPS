package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.repo.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	CourseRepository repo;
	
	
	@Override
	@Transactional
	public ArrayList<Course> findAllCourse() {
		// TODO Auto-generated method stub

		return (ArrayList<Course>) repo.findAll();
	}


	@Override
	@Transactional
	public Course findeCourse(int cid) {
		// TODO Auto-generated method stub
		return (Course)repo.findById(cid).get();
	}
	
	@Override
	@Transactional
	public Course editCourse(Course c) {
		// TODO Auto-generated method stub
		return (Course)repo.saveAndFlush(c);
	}

}
