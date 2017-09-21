package com.jira.po;

import java.util.Date;

public class Score {
	private int scId;//成绩id
	private String sNo;//学生学号
	private String subjectName;//学科名称
	private double marks;//分数
	private Date marksYear;//录入分数时间
	private String timeMarks;//录入分数时间
	private int turn;//学期
	private int scState;//分数是否可查看状态
	private int sId;//学生id
	private int cId;//班级id
	private String cName;//班级名称
	private int cState;//班级是否有用状态
	private int gId;//年级id
	private String gName;//年级名称
	private String usNo;
	public String getUsNo() {
		return usNo;
	}
	public void setUsNo(String usNo) {
		this.usNo = usNo;
	}
	private int gState;//年级是否有用状态
	private String sName;//学生姓名
	private int sex;//学生性别
	private String sPhone;//学生电话
	private String place;//办公地点
	private Date entryTime;//入学时间
	private String time;//入学时间
	private Date leaveTime;//离开时间
	private String timeLeave;//离开时间
	private int stuState;//学生信息是否有用状态
	private String sexString;//性别中文
	private int currentPage;//当前页
	private int pageCount;//每页显示的条数
	private int totalPage;//总页数
	private int totalDate;//总条数
	private int limita;//limit前面条件
	private int limitb;//limit后面条件
	private double minMarks;//分数
	private double maxMarks;//分数
	public int getScId() {
		return scId;
	}
	public void setScId(int scId) {
		this.scId = scId;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Date getMarksYear() {
		return marksYear;
	}
	public void setMarksYear(Date marksYear) {
		this.marksYear = marksYear;
	}
	public String getTimeMarks() {
		return timeMarks;
	}
	public void setTimeMarks(String timeMarks) {
		this.timeMarks = timeMarks;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public int getScState() {
		return scState;
	}
	public void setScState(int scState) {
		this.scState = scState;
	}
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
	public double getMinMarks() {
		return minMarks;
	}
	public void setMinMarks(double minMarks) {
		this.minMarks = minMarks;
	}
	public double getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(double maxMarks) {
		this.maxMarks = maxMarks;
	}
	@Override
	public String toString() {
		return "Score [scId=" + scId + ", sNo=" + sNo + ", subjectName=" + subjectName + ", marks=" + marks
				+ ", marksYear=" + marksYear + ", timeMarks=" + timeMarks + ", turn=" + turn + ", scState=" + scState
				+ ", sId=" + sId + ", cId=" + cId + ", cName=" + cName + ", cState=" + cState + ", gId=" + gId
				+ ", gName=" + gName + ", gState=" + gState + ", sName=" + sName + ", sex=" + sex + ", sPhone=" + sPhone
				+ ", place=" + place + ", entryTime=" + entryTime + ", time=" + time + ", leaveTime=" + leaveTime
				+ ", timeLeave=" + timeLeave + ", stuState=" + stuState + ", sexString=" + sexString + ", currentPage="
				+ currentPage + ", pageCount=" + pageCount + ", totalPage=" + totalPage + ", totalDate=" + totalDate
				+ ", limita=" + limita + ", limitb=" + limitb + ", minMarks=" + minMarks + ", maxMarks=" + maxMarks
				+ "]";
	}
}
