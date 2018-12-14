package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import sg.iss.CAPS_TEAM6.model.Course;

public interface ManageCourseService {
	ArrayList<Course> findAllCourse();

	Course findCourseById(Integer cid);

	ArrayList<Course> findCoursesByCriteria(Course c);

	int createCourse(Course c);

	int updateCourse(Course c);

	int removeCourse(Course c);
}
