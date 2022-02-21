package com.lcomputerstudy1.example.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


public class UserServicelmpl implements UserService{
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		return null;
	}
}
