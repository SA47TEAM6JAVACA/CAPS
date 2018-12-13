package sg.iss.CAPS_TEAM6.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.CAPS_TEAM6.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	ArrayList<String> findManagerNameByUID(String userId);

}
