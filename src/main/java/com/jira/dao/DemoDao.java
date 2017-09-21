package com.jira.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jira.po.User;

@Mapper
public interface DemoDao {
	User findUser(User user);
}
