package com.jira.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jira.po.User;

@Mapper
public interface UserMapper {
	// 根据用户名和密码查找一个用户
	User findUser(User user);

	// 根据用户名来查找一个对象
	User findUserByName(User user);

	// 创建一个用户
	void addUser(User user);
	
	List<User> allUser();
}
