package sg.iss.CAPS_TEAM6.repo;


import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.CAPS_TEAM6.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	

	//@Query("SELECT c from Course c WHERE c.lecturer.lid = :lid")
	 //ArrayList<Course> findCoursesByLid(@Param("lid") Integer lid);
	

}
