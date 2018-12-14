package sg.iss.CAPS_TEAM6.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.iss.CAPS_TEAM6.model.Lecturer;

public interface lecturerrepo extends JpaRepository<Lecturer, Integer> {

	@Query("SELECT c FROM Lecturer c")
	ArrayList<Lecturer> findAllLecturerID();
}
