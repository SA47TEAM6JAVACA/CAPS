package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Lecturer;
import sg.iss.CAPS_TEAM6.model.Student;
import sg.iss.CAPS_TEAM6.model.StudentCourse;
import sg.iss.CAPS_TEAM6.repo.CourseRepository;
import sg.iss.CAPS_TEAM6.repo.LecturerRepository;
import sg.iss.CAPS_TEAM6.repo.StudentCourseRepository;
import sg.iss.CAPS_TEAM6.repo.StudentRepository;




@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Resource
	StudentCourseRepository screpo;
	
	@Resource
	LecturerRepository lrepo;
	
	@Resource
	CourseRepository crepo;
	
	@Resource
	StudentRepository srepo;
	
	
	@Override
	@Transactional
	public ArrayList<StudentCourse> findAllenrols() {
		return (ArrayList<StudentCourse>) screpo.findAll();
	}

	@Override
	public StudentCourse findStudentCourseBySCID(int scid) {
		
		return screpo.findStudentCourseBySCID(scid);
	}

	@Override
	public StudentCourse createStudent(StudentCourse s) {
		screpo.save(s);
		return null;
	}

	@Override
	public StudentCourse updateStudent(StudentCourse s) {
		screpo.saveAndFlush(s);
		return null;
	}

	@Override
	@Transactional
	public void removeStudent(StudentCourse s) {
		screpo.delete(s);

	}

	@Override
	@Transactional
	public ArrayList<Student> listStudentsEnrolledForCourse(int cid) {
		return screpo.findStudentsEnrolledForCourse(cid);
		
	}
	
	
	@Override
	@Transactional
	public ArrayList<Course> listCoursesTaughtByLecturer(int lid) {
		return lrepo.findCoursesByLid(lid);
	}
	@Override
	@Transactional
	public ArrayList<StudentCourse> gradeCourse(int cid) {
		return screpo.findEnrolmentForCourse(cid);
	}
	@Transactional
	public ArrayList<StudentCourse> viewGrade(int stuid) {
		return screpo.findStudentBySTUID(stuid);
	}

	@Override
	public ArrayList<Lecturer> listLecturerByCourseID(int cid) {
		return lrepo.findLecturerByCid(cid);
		
	}


	}
	

