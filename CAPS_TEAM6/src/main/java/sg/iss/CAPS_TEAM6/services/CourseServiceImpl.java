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
	CourseRepository crepo;
	
	
	@Override
	@Transactional
	public ArrayList<Course> findAllCourse() {
		// TODO Auto-generated method stub

		return (ArrayList<Course>) crepo.findAll();
	}


	@Override
	@Transactional
	public Course findeCourse(int cid) {
		// TODO Auto-generated method stub
		return (Course)crepo.findById(cid).get();
	}


	@Override
	public Course FindCourse(int cid) {
		System.out.println(cid);
		return crepo.findById(cid).get();
	}
	
	public ArrayList<Course> findAllcours(){
	return (ArrayList<Course>) crepo.findAll();
	}

}
