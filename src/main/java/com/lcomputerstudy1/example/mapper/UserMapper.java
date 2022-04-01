package com.lcomputerstudy1.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.lcomputerstudy1.example.domain.Pagination;
import com.lcomputerstudy1.example.domain.User;

@Mapper
public interface UserMapper {
	
	public User readUser(String username);
	
	public void createUser(User user);
	
	public List<GrantedAuthority> readAuthorities(String username);
	
	public int userCount(Pagination pagination);
	
	public void createAuthority(User user);

	public List<User> selectUserList(Pagination pagination);
}
