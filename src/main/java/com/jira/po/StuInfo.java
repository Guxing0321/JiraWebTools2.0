package com.jira.po;

import java.util.Date;

public class StuInfo {
	private int sId;//学生id
	private int cId;//班级id
	private String cName;//班级名称
	private int cState;//班级是否有用状态
	private int gId;//年级id
	private String gName;//年级名称
	private int gState;//年级是否有用状态
	private String sNo;//学生学号
	private String sName;//学生姓名
	private int sex;//学生性别
	private String sPhone;//学生电话
	private String place;//办公地点
	private Date entryTime;//入学时间
	private String time;//入学时间
	private Date endEntryTime;
	private Date leaveTime;//离开时间
	private String timeLeave;//离开时间
	private int stuState;//学生信息是否有用状态
	private String sexString;//性别中文
	private int currentPage;//当前页
	private int pageCount;//每页显示的条数
	private int totalPage;//总页数
	private int totalDate;//总条数
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getcState() {
		return cState;
	}
	public void setcState(int cState) {
		this.cState = cState;
	}
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
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getEndEntryTime() {
		return endEntryTime;
	}
	public void setEndEntryTime(Date endEntryTime) {
		this.endEntryTime = endEntryTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getTimeLeave() {
		return timeLeave;
	}
	public void setTimeLeave(String timeLeave) {
		this.timeLeave = timeLeave;
	}
	public int getStuState() {
		return stuState;
	}
	public void setStuState(int stuState) {
		this.stuState = stuState;
	}
	public String getSexString() {
		return sexString;
	}
	public void setSexString(String sexString) {
		this.sexString = sexString;
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
		return "StuInfo [sId=" + sId + ", cId=" + cId + ", cName=" + cName + ", cState=" + cState + ", gId=" + gId
				+ ", gName=" + gName + ", gState=" + gState + ", sNo=" + sNo + ", sName=" + sName + ", sex=" + sex
				+ ", sPhone=" + sPhone + ", place=" + place + ", entryTime=" + entryTime + ", time=" + time
				+ ", endEntryTime=" + endEntryTime + ", leaveTime=" + leaveTime + ", timeLeave=" + timeLeave
				+ ", stuState=" + stuState + ", sexString=" + sexString + ", currentPage=" + currentPage
				+ ", pageCount=" + pageCount + ", totalPage=" + totalPage + ", totalDate=" + totalDate + "]";
	}
}
