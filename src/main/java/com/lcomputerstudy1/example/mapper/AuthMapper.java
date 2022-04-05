package com.lcomputerstudy1.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lcomputerstudy1.example.domain.Auth;

@Mapper
public interface AuthMapper {

	public void updateAuth(Auth auth);
	
}
