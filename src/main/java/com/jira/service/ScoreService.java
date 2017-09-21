package com.jira.service;

import java.util.ArrayList;
import java.util.List;

import com.jira.po.Score;

public interface ScoreService {
	// 根据sno来查询一个人的成绩信息
	ArrayList<Score> ifExit(Score s);

	// 根据sno来删除某个学生的成绩信息
	void deletScore(Score s);
	// 根据gid或cid来删除某个学生的成绩信息
	void delet(Score s);
	//根据sid或cid更新
	void rdata(Score s);
	void updateBySno(Score s);
	// 返回上一次操作受影响的行数
	int num();
	
	ArrayList<Score> getTimeBySno(Score s);
	// 根据多条件查询有成绩的学生成绩信息加分页
	ArrayList<Score> getScoreInfo(Score s);

	// 根据多条件查询没有成绩的学生成绩信息加分页
	ArrayList<Score> getNoScoreInfo(Score s);

	// 根据多条件查询有成绩的学生成绩信息的总数
	ArrayList<Score> totalScore(Score s);

	// 根据多条件查询没有成绩的学生成绩信息的总数
	ArrayList<Score> totalNoScore(Score s);

	// 根据scid来删除某个学生的成绩信息
	void deletScoreByScid(Score s);

	// 根据sicd来修改成绩
	void updateScore(Score s);
	

	// 添加一条成绩信息
	void addScore(Score s);

	// 根据sid得到一条成绩的详细信息
	Score getOneScoreInfo(Score s);
	//判断一个记录是否已经添加
	Score canAdd(Score s);
}
