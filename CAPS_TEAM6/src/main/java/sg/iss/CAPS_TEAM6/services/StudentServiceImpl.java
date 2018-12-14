package sg.iss.CAPS_TEAM6.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.CAPS_TEAM6.model.Student;
import sg.iss.CAPS_TEAM6.repo.CourseRepository;
import sg.iss.CAPS_TEAM6.repo.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	StudentRepository repo;
	

	@Override
	@Transactional
	public Student findStudent(int id) {
		// TODO Auto-generated method stub
		return (Student)repo.findById(id).get();
	}
	
	@Override
	@Transactional
	public List<Student> findallstu() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	@Transactional
	public int findID(String username) {
		// TODO Auto-generated method stub
		return repo.findStuID(username);
	}
	

}






