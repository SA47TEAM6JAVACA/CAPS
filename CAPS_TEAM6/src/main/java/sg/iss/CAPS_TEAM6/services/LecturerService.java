package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.model.Course;
import java.util.List; 

public interface LecturerService {
	 ArrayList<Lecturer> findAllenrols();

	 Lecturer FindLecturer(int lid);

	Lecturer CreateLecturer(Lecturer l);

	 Lecturer UpdateLecturer(Lecturer l);

	void RemoveLecturer(Lecturer l);
	void lecturerAddCourses(Lecturer l, Course c);
	public ArrayList<String> findAllLecturerIDs();

}


