package sg.iss.CAPS_TEAM6.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.CAPS_TEAM6.model.Role;
import sg.iss.CAPS_TEAM6.repo.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleRepository roleRepository;
	


	/* (non-Javadoc)
	 * @see edu.iss.cats.service.RoleService#findAllRoles()
	 */
	@Override
	@Transactional
	public ArrayList<Role> findAllRoles() {
		ArrayList<Role> ul = (ArrayList<Role>) roleRepository.findAll();
		return ul;
	}
	

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.RoleService#findRole(java.lang.String)
	 */
	@Override
	@Transactional
	public Role findRole(String roleId) {
		return roleRepository.findOne(roleId);

	}


	/* (non-Javadoc)
	 * @see edu.iss.cats.service.RoleService#createRole(edu.iss.cats.model.Role)
	 */
	@Override
	@Transactional
	public Role createRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.RoleService#changeRole(edu.iss.cats.model.Role)
	 */
	@Override
	@Transactional
	public Role changeRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}



	/* (non-Javadoc)
	 * @see edu.iss.cats.service.RoleService#removeRole(edu.iss.cats.model.Role)
	 */
	@Override
	@Transactional
	public void removeRole(Role role) {
		roleRepository.delete(role);
	}

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.RoleService#findAllRolesNames()
	 */
	@Override
	@Transactional
	public ArrayList<String> findAllRolesNames() {
		return roleRepository.findAllRolesNames();
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.cats.service.RoleService#findRoleByName(java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Role> findRoleByName(String name) {
		return roleRepository.findRoleByName(name);
	}
}
