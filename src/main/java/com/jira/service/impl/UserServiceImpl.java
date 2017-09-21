package com.jira.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jira.dao.UserMapper;
import com.jira.po.User;
import com.jira.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUser(User user) {
		return userMapper.findUser(user);
	}

	@Override
	public User findUserByName(User user) {
		return userMapper.findUserByName(user);
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);
	}

}
