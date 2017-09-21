package com.jira.service;

import java.util.ArrayList;

import com.jira.po.StuInfo;

public interface StuInfoService {
	// 返回学生信息集合
	ArrayList<StuInfo> getStu(StuInfo stu);

	// 返回学生信息集合
	ArrayList<StuInfo> total(StuInfo stu);

	// 删除一个学生的信息 根据gid或cid
	void delet(StuInfo stu);

	// 删除一个学生的信息 根据gid或cid
	void rdata(StuInfo stu);

	// 删除一个学生的信息 根据sno
	void deletStuIf(StuInfo stu);

	// 返回上一次操作受影响的行数
	int num();

	// 根据sid得到一个学生对象
	StuInfo getOneStu(StuInfo stu);

	// 更新学生信息 依据sid
	void updateStu(StuInfo stu);

	// 添加一个新学生数据
	void addStu(StuInfo stu);

	// 根据sno查看一个学生
	StuInfo getOneStuBySno(StuInfo stu);

	// 根据gid或cid得到一个学生对象
	ArrayList<StuInfo> getListStu(StuInfo stu);
}
