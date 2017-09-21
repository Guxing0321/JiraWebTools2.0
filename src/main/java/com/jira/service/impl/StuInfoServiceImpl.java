package com.jira.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jira.dao.StuInfoMapper;
import com.jira.po.StuInfo;
import com.jira.service.StuInfoService;
import com.jira.until.DateUtil;

@Service
public class StuInfoServiceImpl implements StuInfoService {

	@Autowired
	private StuInfoMapper stuInfoMapper;

	@Override
	public ArrayList<StuInfo> getStu(StuInfo stu) {
		return addSexString((ArrayList<StuInfo>) stuInfoMapper.getStu(stu));
	}
	
	public static  ArrayList<StuInfo> addSexString(ArrayList<StuInfo> stu){
		for(int i=0;i<stu.size();i++){
			if(stu.get(i).getSex()==0){
				stu.get(i).setSexString("男");
			}else{
				stu.get(i).setSexString("女");
			}
			stu.get(i).setTime(DateUtil.getStrFromDate(stu.get(i).getEntryTime(), "yyyy-MM-dd"));
			stu.get(i).setTimeLeave(DateUtil.getStrFromDate(stu.get(i).getLeaveTime(), "yyyy-MM-dd"));
//			System.out.println(stu.get(i));
		}
		return stu;
	}
	public static  StuInfo addTime(StuInfo stu){
		stu.setTime(DateUtil.getStrFromDate(stu.getEntryTime(), "yyyy-MM-dd"));
		stu.setTimeLeave(DateUtil.getStrFromDate(stu.getLeaveTime(), "yyyy-MM-dd"));
		return stu;
	}

	@Override
	public ArrayList<StuInfo> total(StuInfo stu) {
		return (ArrayList<StuInfo>) stuInfoMapper.total(stu);
	}

	@Override
	public int num() {
		return stuInfoMapper.num();
	}

	@Override
	public void deletStuIf(StuInfo stu) {
		stuInfoMapper.deletStuIf(stu);
	}

	@Override
	public StuInfo getOneStu(StuInfo stu) {
		return addTime(stuInfoMapper.getOneStu(stu));
	}

	@Override
	public void updateStu(StuInfo stu) {
		stuInfoMapper.updateStu(stu);
	}

	@Override
	public void addStu(StuInfo stu) {
		stuInfoMapper.addStu(stu);
	}

	@Override
	public StuInfo getOneStuBySno(StuInfo stu) {
		return stuInfoMapper.getOneStuBySno(stu);
	}

	@Override
	public ArrayList<StuInfo> getListStu(StuInfo stu) {
		return (ArrayList<StuInfo>) stuInfoMapper.getListStu(stu);
	}

	@Override
	public void delet(StuInfo stu) {
		stuInfoMapper.delet(stu);
	}

	@Override
	public void rdata(StuInfo stu) {
		stuInfoMapper.rdata(stu);
	}
}
