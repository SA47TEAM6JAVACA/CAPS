package sg.iss.CAPS_TEAM6.services;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Resource
	CourseRepository crepo;
	
	@Override
	public Course FindCourse(int cid) {
		System.out.println(cid);
		return crepo.findById(cid).get();
	}
	
	public ArrayList<Course> findAllcours(){
	return (ArrayList<Course>) crepo.findAll();
	}
}
