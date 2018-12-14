package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import sg.iss.CAPS_TEAM6.model.StudentCourse;

public interface StudentCourseService {

	public StudentCourse createStudentCourse(StudentCourse s);

	public ArrayList<StudentCourse> findAllenrols();
	
	
	
}
