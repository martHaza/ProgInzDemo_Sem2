package lv.venta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import lv.venta.config.MyUserDetails;
import lv.venta.model.MyUser;
import lv.venta.repo.IMyUserRepo;

@Service
public class MyUserDetailsManagerServiceImpl implements UserDetailsManager {
	
	@Autowired 
	private IMyUserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ( userRepo.existsByUsername(username)) {
			MyUser user = userRepo.findByUsername(username);
			MyUserDetails userDetails = new MyUserDetails(user);
			return userDetails;
		} else {
			throw new UsernameNotFoundException(username + " is not found!");
		}
			
			
	}

	//TODO pabeigt CRUD
	
	@Override
	public void createUser(UserDetails user) {
		
		
	}

	@Override
	public void updateUser(UserDetails user) {
		
		
	}

	@Override
	public void deleteUser(String username) {
		
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		
		
	}

	@Override
	public boolean userExists(String username) {
		
		return false;
	}
	

}
