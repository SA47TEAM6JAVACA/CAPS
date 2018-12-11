package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.CAPS_TEAM6.model.StudentCourse;
import sg.iss.CAPS_TEAM6.repo.StudentCourseRepository;



@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Resource
	StudentCourseRepository screpo;
	
	
	@Override
	@Transactional
	public ArrayList<StudentCourse> findAllenrols() {
		return (ArrayList<StudentCourse>) screpo.findAll();
	}

	@Override
	public StudentCourse findStudent(int stuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentCourse createStudent(StudentCourse s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentCourse updateStudent(StudentCourse s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStudent(StudentCourse s) {
		// TODO Auto-generated method stub

	}

}
