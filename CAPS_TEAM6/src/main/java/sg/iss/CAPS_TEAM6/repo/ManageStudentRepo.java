package sg.iss.CAPS_TEAM6.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.CAPS_TEAM6.model.Student;

public interface ManageStudentRepo extends JpaRepository<Student, Integer> {

}
