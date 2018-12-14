package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import sg.iss.CAPS_TEAM6.model.Course;


public interface CourseService {

	ArrayList<Course> findAllCourse();
	
	Course findeCourse(int cid);
	
}
