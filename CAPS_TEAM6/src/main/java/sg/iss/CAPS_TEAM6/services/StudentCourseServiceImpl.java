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
	StudentCourseRepository sr;
	
	@Override
	@Transactional
	public StudentCourse createStudentCourse(StudentCourse s) {
		return sr.saveAndFlush(s);
	
	}

	@Override
	public ArrayList<StudentCourse> findAllenrols() {
		// TODO Auto-generated method stub
		return null;
	}

}
