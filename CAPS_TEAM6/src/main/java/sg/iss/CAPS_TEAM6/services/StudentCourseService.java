package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import sg.iss.CAPS_TEAM6.model.StudentCourse;
import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.model.Student;

public interface StudentCourseService {

	public StudentCourse createStudentCourse(StudentCourse s);

	public ArrayList<StudentCourse> findAllenrols();
	
	public ArrayList<Student> listStudentsEnrolledForCourse(int cid);
	public ArrayList<Course> listCoursesTaughtByLecturer(int lid);
	public ArrayList<Lecturer> listLecturerByCourseID(int cid);
	public ArrayList<StudentCourse> gradeCourse(int cid);
	StudentCourse findStudentCourseBySCID(int scid);

	StudentCourse createStudent(StudentCourse s);

	StudentCourse updateStudent(StudentCourse s);

    void removeStudent(StudentCourse s);


	
}
