package com.jira.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jira.dao.ScoreMapper;
import com.jira.po.Score;
import com.jira.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreMapper scMapper;

	/*
	 * 根据sno查看成绩表中是否有数据
	 * 
	 * @see com.demo.service.ScoreService#ifExit(com.demo.po.Score)
	 */
	@Override
	public ArrayList<Score> ifExit(Score s) {
		return (ArrayList<Score>) scMapper.ifExit(s);
	}

	/**
	 * 根据sno来删除一个学生的信息
	 */
	@Override
	public void deletScore(Score s) {
		scMapper.deletScore(s);
	}

	@Override
	public int num() {
		return scMapper.num();
	}

	/**
	 * 返回有成绩学生的信息
	 */
	@Override
	public ArrayList<Score> getScoreInfo(Score s) {
		return (ArrayList<Score>) scMapper.getScoreInfo(s);
	}

	/**
	 * 返回没有成绩学生的信息
	 */
	@Override
	public ArrayList<Score> getNoScoreInfo(Score s) {
		return (ArrayList<Score>) scMapper.getNoScoreInfo(s);
	}

	/**
	 * 返回有成绩学生的信息总数
	 */
	@Override
	public ArrayList<Score> totalScore(Score s) {
		return (ArrayList<Score>) scMapper.totalScore(s);
	}

	/**
	 * 返回没有成绩学生的信息总数
	 */
	@Override
	public ArrayList<Score> totalNoScore(Score s) {
		return (ArrayList<Score>) scMapper.totalNoScore(s);
	}
	/**
	 * 根据scid来删除某个学生的成绩信息
	 */
	@Override
	public void deletScoreByScid(Score s) {
		scMapper.deletScoreByScid(s);
	}
	/**
	 * 根据sicd来修改成绩
	 */
	@Override
	public void updateScore(Score s) {
		scMapper.updateScore(s);
	}
	/**
	 * 添加一条成绩信息
	 */
	@Override
	public void addScore(Score s) {
		scMapper.addScore(s);
	}
	/**
	 * 根据sid得到一条成绩的详细信息
	 */
	@Override
	public Score getOneScoreInfo(Score s) {
		return scMapper.getOneScoreInfo(s);
	}

	@Override
	public void delet(Score s) {
		scMapper.delet(s);
	}

	@Override
	public void rdata(Score s) {
		scMapper.rdata(s);
	}

	@Override
	public Score canAdd(Score s) {
		return scMapper.canAdd(s);
	}

	@Override
	public void updateBySno(Score s) {
		scMapper.updateBySno(s);
	}

	@Override
	public ArrayList<Score> getTimeBySno(Score s) {
		// TODO Auto-generated method stub
		return (ArrayList<Score>) scMapper.getTimeBySno(s);
	}
}
