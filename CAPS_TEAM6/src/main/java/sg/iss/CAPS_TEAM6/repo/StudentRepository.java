package sg.iss.CAPS_TEAM6.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.CAPS_TEAM6.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	@Query("SELECT c.sid from Student c WHERE c.semail = :name")
	int findStuID(@Param("name") String name);
}
