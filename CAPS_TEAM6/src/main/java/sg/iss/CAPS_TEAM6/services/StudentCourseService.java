package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import sg.iss.CAPS_TEAM6.model.StudentCourse;


public interface StudentCourseService {

	ArrayList<StudentCourse> findAllenrols();

	StudentCourse findStudent(int stuid);

	StudentCourse createStudent(StudentCourse s);

	StudentCourse updateStudent(StudentCourse s);

	void removeStudent(StudentCourse s);

	
}
