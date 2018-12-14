package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sg.iss.CAPS_TEAM6.model.Course;

public interface CourseService {

	 Course FindCourse(int cid);

	ArrayList<Course> findAllcours();

}


