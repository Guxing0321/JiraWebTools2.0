package com.jira.service;

import java.util.ArrayList;

import com.jira.po.Grade;

public interface GradeService {
	// 返回年级集合
	ArrayList<Grade> getGrade();
	// 返回年级集合
	ArrayList<Grade> getGradeByState(Grade g);
	// 分页查询
	ArrayList<Grade> getLimitGrade(Grade g);
	// 返回年级集合
	ArrayList<Grade> total(Grade g);
	// 根据gid更新
	void update(Grade g);
	void rdata(Grade g);
	// 根据gid删除
	void delet(Grade g);

	// 添加
	void insert(Grade g);

	// 是否年级名被使用
	Grade isExit(Grade g);
	//根据gid查询一个对象
	Grade getOne(Grade g);
}
