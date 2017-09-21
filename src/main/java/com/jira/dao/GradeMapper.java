package com.jira.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jira.po.Grade;

@Mapper
public interface GradeMapper {
	// 返回年级集合
	List<Grade> getGrade();
	// 返回年级集合
	List<Grade> getGradeByState(Grade g);
	// 分页查询
	List<Grade> getLimitGrade(Grade g);
	// 返回年级集合
	List<Grade> total(Grade g);
	// 根据gid更新
	void update(Grade g);
	// 根据gid更新
	void rdata(Grade g);
	// 根据gid删除
	void delet(Grade g);

	// 添加
	void insert(Grade g);

	// 是否年级名被使用
	Grade isExit(Grade g);

	// 根据gid查询一个对象
	Grade getOne(Grade g);
}
