package com.jira.service;

import com.jira.po.User;

public interface UserService {
	// 根据用户名和密码查找一个用户
	User findUser(User user);

	// 根据用户名来查找一个对象
	User findUserByName(User user);

	// 创建一个用户
	void addUser(User user);
}
