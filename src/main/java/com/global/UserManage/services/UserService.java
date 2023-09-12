package com.global.UserManage.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.global.UserManage.entity.AppUser;
import com.global.UserManage.repository.UserRepo;
import com.global.UserManage.secEntity.UserDetail;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{
	
	private final UserRepo repo;
	private final PasswordEncoder passwordEncoder;

	public List<AppUser> findall() {

		return repo.findAll();
	}
	public boolean existByEmail(String email) {
		return repo.existsByEmail(email);
	}
	public AppUser save(AppUser entity) {
		 entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		return repo.save(entity);
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser userApp =  repo.findByEmail(username);

		if (userApp == null) {
			throw new UsernameNotFoundException("this user not found with selected user name :-  " + username);
		}
		return new UserDetail(userApp);
	}
}
