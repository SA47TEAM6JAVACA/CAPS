package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import sg.iss.CAPS_TEAM6.model.Student;

public interface ManageStudentService {
	ArrayList<Student> findAllStudent();

	Student findStudentById(Integer cid);

	ArrayList<Student> findStudentsByCriteria(Student s);

	int createStudent(Student s);

	int updateStudent(Student s);

	int removeStudent(Student s);
}
