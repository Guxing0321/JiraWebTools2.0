package com.jira.po;

import java.util.Date;

/*
 * 年级
 */
public class Grade {
	private int gId;//年级id
	private String gName;//年级名称
	private int gState;//年级是否有用状态
	private Date gDate;//创建年级时间
	private String addgTime;//年级时间
	private int limita;//分页limit
	private int limitb;//分页limit
	private int currentPage;//当前页
	private int pageCount;//每页显示的条数
	private int totalPage;//总页数
	private int totalDate;//总条数
	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public int getgState() {
		return gState;
	}
	public void setgState(int gState) {
		this.gState = gState;
	}
	public Date getgDate() {
		return gDate;
	}
	public void setgDate(Date gDate) {
		this.gDate = gDate;
	}
	public String getAddgTime() {
		return addgTime;
	}
	public void setAddgTime(String addgTime) {
		this.addgTime = addgTime;
	}
	public int getLimita() {
		return limita;
	}
	public void setLimita(int limita) {
		this.limita = limita;
	}
	public int getLimitb() {
		return limitb;
	}
	public void setLimitb(int limitb) {
		this.limitb = limitb;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalDate() {
		return totalDate;
	}
	public void setTotalDate(int totalDate) {
		this.totalDate = totalDate;
	}
	@Override
	public String toString() {
		return "Grade [gId=" + gId + ", gName=" + gName + ", gState=" + gState + ", gDate=" + gDate + ", addgTime="
				+ addgTime + ", limita=" + limita + ", limitb=" + limitb + ", currentPage=" + currentPage
				+ ", pageCount=" + pageCount + ", totalPage=" + totalPage + ", totalDate=" + totalDate + "]";
	}
}
