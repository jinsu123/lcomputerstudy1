package com.lcomputerstudy1.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcomputerstudy1.example.domain.Auth;
import com.lcomputerstudy1.example.mapper.AuthMapper;


@Service
public class AuthServiceImpl implements AuthService{

	@Autowired AuthMapper authMapper;

	@Override
	public void updateAuth(Auth auth){
		authMapper.updateAuth(auth);
	}
	
}
