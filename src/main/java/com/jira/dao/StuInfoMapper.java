package com.jira.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jira.po.StuInfo;

@Mapper
public interface StuInfoMapper {
	// 返回学生信息集合
	List<StuInfo> getStu(StuInfo stu);

	// 返回学生信息集合
	List<StuInfo> total(StuInfo stu);

	// 删除一个学生的信息 根据sno
	void deletStuIf(StuInfo stu);
	// 删除一个学生的信息 根据gid或cid
	void delet(StuInfo stu);
	// 删除一个学生的信息 根据gid或cid
	void rdata(StuInfo stu);
	// 返回上一次操作受影响的行数
	int num();
	//根据sid得到一个学生对象
	StuInfo getOneStu(StuInfo stu);
	//根据gid或cid得到一个学生对象
	List<StuInfo> getListStu(StuInfo stu);
	//更新学生信息 依据sid
	void updateStu(StuInfo stu);
	//添加一个新学生数据
	void addStu(StuInfo stu);
	//根据sno查看一个学生
	StuInfo getOneStuBySno(StuInfo stu);
}
