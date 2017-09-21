package com.jira.service;

import java.util.ArrayList;

import com.jira.po.ClassInfo;

public interface ClassService {
	// 返回班级的集合
	ArrayList<ClassInfo> getClassInfo();
	// 返回班级的集合
	ArrayList<ClassInfo> getClassInfoByState(ClassInfo c);
	// 分页查询
	ArrayList<ClassInfo> getLimitClass(ClassInfo c);
	//根据条件的返回的集合
	ArrayList<ClassInfo> total(ClassInfo c);
	// 根据cid更新
	void update(ClassInfo c);
	// 根据cid更新
	void rdata(ClassInfo c);
	// 根据cid删除
	void delet(ClassInfo c);
	// 根据gid删除
	void deletByGid(ClassInfo c);
	// 添加
	void insert(ClassInfo c);

	// 是否班级名被使用
	ClassInfo isExit(ClassInfo c);

	// 根据gid查询一个对象
	ClassInfo getOne(ClassInfo c);
}
