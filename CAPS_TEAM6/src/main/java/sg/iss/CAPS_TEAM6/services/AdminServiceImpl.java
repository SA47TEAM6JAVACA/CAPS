package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.CAPS_TEAM6.model.Admin;
import sg.iss.CAPS_TEAM6.repo.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository ar;
	
	@Override
	public ArrayList<Admin> findAllAdmin() {
		// TODO Auto-generated method stub
		return (ArrayList<Admin>) ar.findAll();
	}
	
	@Override
	@Transactional
	public int findID(String username) {
		// TODO Auto-generated method stub
		return ar.findAdminID(username);
	}
	

}
