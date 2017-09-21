package com.jira.service.impl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jira.dao.GradeMapper;
import com.jira.po.Grade;
import com.jira.service.GradeService;
import com.jira.until.DateUtil;
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeMapper gm;
	
	@Override
	public ArrayList<Grade> getGrade() {
		// TODO Auto-generated method stub
		return (ArrayList<Grade>) gm.getGrade();
	}

	@Override
	public ArrayList<Grade> getLimitGrade(Grade g) {
		// TODO Auto-generated method stub
		return addGTime((ArrayList<Grade>) gm.getLimitGrade(g));
	}

	@Override
	public void update(Grade g) {
		gm.update(g);
	}

	@Override
	public void delet(Grade g) {
		gm.delet(g);
	}

	@Override
	public void insert(Grade g) {
		gm.insert(g);
	}

	@Override
	public Grade isExit(Grade g) {
		return gm.isExit(g);
	}

	@Override
	public Grade getOne(Grade g) {
		
		return gm.getOne(g);
	}

	@Override
	public ArrayList<Grade> getGradeByState(Grade g) {
		return (ArrayList<Grade>) gm.getGradeByState(g);
	}

	@Override
	public ArrayList<Grade> total(Grade g) {
		return (ArrayList<Grade>) gm.total(g);
	}

	@Override
	public void rdata(Grade g) {
		gm.rdata(g);
	}
	public static ArrayList<Grade> addGTime(ArrayList<Grade> g) {
		for (int i = 0; i < g.size(); i++) {
			g.get(i).setAddgTime(DateUtil.getStrFromDate(g.get(i).getgDate(), "yyyy-MM-dd"));
			System.out.println(g.get(i));
		}
		return g;
	}
}
