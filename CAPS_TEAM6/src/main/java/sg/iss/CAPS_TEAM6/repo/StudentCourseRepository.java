package sg.iss.CAPS_TEAM6.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.CAPS_TEAM6.model.StudentCourse;
import sg.iss.CAPS_TEAM6.model.Student;




public interface StudentCourseRepository extends JpaRepository<StudentCourse,Integer > {
	
	@Query ("Select e from StudentCourse e where e.course.cid = :cid")
	ArrayList<StudentCourse> findEnrolmentForCourse(@Param("cid") int cid);
	
	@Query ("Select e.student from StudentCourse e where e.course.cid = :cid")
	ArrayList<Student> findStudentsEnrolledForCourse(@Param("cid") int cid);

	@Query("Select e from StudentCourse e where e.scid=:scid")
	StudentCourse findStudentCourseBySCID(@Param("scid") int scid);
	
	
	@Query("Select e from StudentCourse e where e.student.sid=:stuid")
	ArrayList<StudentCourse> findStudentBySTUID(@Param("stuid") int stuid);
	
}
