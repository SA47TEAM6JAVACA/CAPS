package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import sg.iss.CAPS_TEAM6.model.Student;
import sg.iss.CAPS_TEAM6.repo.ManageStudentRepo;
@Service
public class ManageStudentservicempl implements ManageStudentService {
	@Resource
	ManageStudentRepo srepo;

	@Override
	public ArrayList<Student> findAllStudent() {
		ArrayList<Student> slist = (ArrayList<Student>)srepo.findAll();
		return slist;
	}

	@Override
	public Student findStudentById(Integer sid) {
		return srepo.findById(sid).get();
	}

	@Override
	public ArrayList<Student> findStudentsByCriteria(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createStudent(Student s) {
		srepo.save(s);
		return 0;
	}

	@Override
	public int updateStudent(Student s) {
		srepo.saveAndFlush(s);
		return 0;
	}

	@Override
	public int removeStudent(Student s) {
		srepo.delete(s);
		return 0;
	}

}
