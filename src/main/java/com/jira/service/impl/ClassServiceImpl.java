package com.jira.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jira.dao.ClassMapper;
import com.jira.po.ClassInfo;
import com.jira.service.ClassService;
import com.jira.until.DateUtil;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassMapper cMapper;

	@Override
	public ArrayList<ClassInfo> getClassInfo() {
		// TODO Auto-generated method stub
		return (ArrayList<ClassInfo>) cMapper.getClassInfo();
	}

	@Override
	public ArrayList<ClassInfo> getLimitClass(ClassInfo c) {
		// TODO Auto-generated method stub
		return addCTime((ArrayList<ClassInfo>) cMapper.getLimitClass(c));
	}

	@Override
	public void update(ClassInfo c) {
		cMapper.update(c);
	}

	@Override
	public void delet(ClassInfo c) {
		cMapper.delet(c);
	}

	@Override
	public void insert(ClassInfo c) {
		cMapper.insert(c);
	}

	@Override
	public ClassInfo isExit(ClassInfo c) {
		// TODO Auto-generated method stub
		return cMapper.isExit(c);
	}

	@Override
	public ClassInfo getOne(ClassInfo c) {
		// TODO Auto-generated method stub
		return cMapper.getOne(c);
	}

	@Override
	public void deletByGid(ClassInfo c) {
		cMapper.deletByGid(c);
	}

	@Override
	public ArrayList<ClassInfo> total(ClassInfo c) {
		// TODO Auto-generated method stub
		return (ArrayList<ClassInfo>) cMapper.total(c);
	}

	@Override
	public void rdata(ClassInfo c) {
		cMapper.rdata(c);
	}

	@Override
	public ArrayList<ClassInfo> getClassInfoByState(ClassInfo c) {
		// TODO Auto-generated method stub
		return (ArrayList<ClassInfo>) cMapper.getClassInfoByState(c);
	}

	public static ArrayList<ClassInfo> addCTime(ArrayList<ClassInfo> c) {
		for (int i = 0; i < c.size(); i++) {
			c.get(i).setAddcTime(DateUtil.getStrFromDate(c.get(i).getcDate(), "yyyy-MM-dd"));
		}
		return c;
	}

}
