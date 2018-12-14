package sg.iss.CAPS_TEAM6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.CAPS_TEAM6.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {


	@Query("SELECT c.aid from Admin c WHERE c.aemail = :name")
	int findAdminID(@Param("name") String name);
}
