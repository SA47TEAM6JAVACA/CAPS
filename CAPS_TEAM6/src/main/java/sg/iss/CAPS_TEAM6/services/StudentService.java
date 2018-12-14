package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;
import java.util.List;

import sg.iss.CAPS_TEAM6.model.Student;

public interface StudentService {

	
	public int findID(String username);
	
	Student findStudent(int nric);

	List<Student> findallstu();
}
