package com.lcomputerstudy1.example.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.lcomputerstudy1.example.domain.Pagination;
import com.lcomputerstudy1.example.domain.User;

public interface UserService extends UserDetailsService{
	public User readUser(String username);
	
	public List<User> selectUserList(Pagination pagination);
	
	public void createUser(User user);
	
	public void createAuthorities(User user);
	
	public int userCount(Pagination pagination);
	
	Collection<GrantedAuthority> getAuthoritites(String username);
}
