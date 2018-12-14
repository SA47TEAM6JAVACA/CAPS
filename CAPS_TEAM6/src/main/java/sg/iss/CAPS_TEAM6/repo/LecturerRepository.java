package sg.iss.CAPS_TEAM6.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.CAPS_TEAM6.model.Course;
import sg.iss.CAPS_TEAM6.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer,Integer> {

	@Query("SELECT c.courses from Lecturer c WHERE c.lid = :lid")
    ArrayList<Course> findCoursesByLid(@Param("lid") Integer lid);

	@Query("SELECT DISTINCT e.lid FROM Lecturer e")
	ArrayList<String> findAllLecturerIDs();
	
}
