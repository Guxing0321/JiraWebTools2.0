package com.jira.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jira.po.Score;
import com.jira.po.StuInfo;
import com.jira.service.ScoreService;
import com.jira.service.StuInfoService;
import com.jira.until.DateUtil;

import io.swagger.annotations.Api;

@Api("Demo测试")
@Controller
@RequestMapping("/w")
public class ScoreControl {
	@Autowired
	private StuInfoService sservice;
	@Autowired
	private ScoreService scservice;
	private Logger logger = Logger.getLogger(ScoreControl.class);

	@RequestMapping("/score")
	@ResponseBody
	public ArrayList<Score> score(HttpServletRequest request) {
		logger.info("score....");
		int allpage = 1;
		String gradeName = request.getParameter("gradename").trim();
		String className = request.getParameter("classname").trim();
		String subjectName = request.getParameter("subjectname").trim();
		String sno = request.getParameter("sno").trim();
		String minscore = request.getParameter("minscore").trim();
		String maxscore = request.getParameter("maxscore").trim();
		String state=request.getParameter("state").trim();
		String page = request.getParameter("page").trim();
		int currentpage = 1;
		if (page != null && page != "") {
			currentpage = Integer.parseInt(page);
		}
		System.out.println("当前页===" + page);
		Score s = new Score();
		System.out.println(!gradeName.equals("请选择年级"));
		if (gradeName != "" && !gradeName.equals("请选择年级")) {
			s.setgId(Integer.parseInt(gradeName));
		}
		if (className !="" && !className.equals("请选择班级")&&!className.equals("wxy")) {
			s.setcId(Integer.parseInt(className));
		}
		if (subjectName != "" && !subjectName.equals("请选择学科")) {
			s.setSubjectName(subjectName);
		}
		if (sno != "") {
			s.setsNo(sno);
		}
		if (minscore != "") {
			s.setMinMarks(Double.parseDouble(minscore));
		}
		if (maxscore != "") {
			s.setMaxMarks(Double.parseDouble(maxscore));
		}
		if(!state.equals("0")){
			s.setScState(Integer.parseInt(state));
		}
		System.out.println("1===================" + s);
		ArrayList<Score> total = scservice.totalScore(s);
		ArrayList<Score> stu = new ArrayList<Score>();
		System.out.println("total:====" + total.size());
		int pagesize = 5;// 每页显示的条数
		int allcounts = total.size();// 总条数
		if (allcounts != 0) {
			allpage = (allcounts - 1) / pagesize + 1;// 总页数
			s.setLimita((currentpage - 1) * pagesize);
			s.setLimitb(pagesize);
			System.out.println("2===================" + s);
			stu = scservice.getScoreInfo(s);
			stu.get(0).setTotalPage(allpage);
			stu.get(0).setCurrentPage(currentpage);
			stu.get(0).setPageCount(pagesize);
			stu.get(0).setTotalDate(allcounts);
		}
		System.out.println("stu=======" + stu);
		return addDateToString(stu);
	}

	@RequestMapping("/noScore")
	@ResponseBody
	public ArrayList<Score> noScore(HttpServletRequest request) {
		logger.info("noScore....");
		int allpage = 1;
		String gradeName = request.getParameter("gradename").trim();
		String className = request.getParameter("classname").trim();
		String state = request.getParameter("state").trim();
		String sno = request.getParameter("sno").trim();
		String page = request.getParameter("page").trim();
		String subjectname=request.getParameter("subjectname").trim();
		String year=request.getParameter("year").trim();
		String turn=request.getParameter("turn").trim();
		if(turn.equals("1")){
			year=year.concat("-01-01");
		}else{
			year=year.concat("-08-01");
		}
		int currentpage = 1;
		if (page != null && page != "") {
			currentpage = Integer.parseInt(page);
		}
		System.out.println("grage:" + gradeName + "  class:" + className +  "    sno:"
				+ sno + "  state"+state);
		System.out.println("noScore当前页===" + page);
		Score s = new Score();
		System.out.println(!gradeName.equals("请选择年级"));
		if (gradeName != "" && !gradeName.equals("请选择年级")) {
			s.setgId(Integer.parseInt(gradeName));
		}
		if (className !="" && !className.equals("请选择班级")&&!className.equals("wxy")) {
			s.setcId(Integer.parseInt(className));
		}
		if (sno != "") {
			s.setsNo(sno);
		}
		if(!state.equals("0")){
			s.setScState(Integer.parseInt(state));
		}
		ArrayList<Score> stu = new ArrayList<Score>();
		if(!subjectname.equals("请选择学科")){
			s.setSubjectName(subjectname);
			s.setMarksYear(DateUtil.getDateFromStr(year, "yyyy-mm-dd"));
			s.setTurn(Integer.parseInt(turn));
			System.out.println("1===================" + s);
			ArrayList<Score> total = scservice.totalNoScore(s);
			System.out.println("noScore    total:====" + total.size());
			int pagesize = 5;// 每页显示的条数
			int allcounts = total.size();// 总条数
			if (allcounts != 0) {
				allpage = (allcounts - 1) / pagesize + 1;// 总页数
				s.setLimita((currentpage - 1) * pagesize);
				s.setLimitb(pagesize);
				System.out.println("2===================" + s);
				stu = scservice.getNoScoreInfo(s);
				stu.get(0).setTotalPage(allpage);
				stu.get(0).setCurrentPage(currentpage);
				stu.get(0).setPageCount(pagesize);
				stu.get(0).setTotalDate(allcounts);
			}
			System.out.println("stu=======" + stu);
		}
		return stu;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(HttpServletRequest request) {
		logger.info("delete....");
		// String currentpage=request.getParameter("page");
		String scid = request.getParameter("scid").trim();
		Score s = new Score();
		System.out.println("   scid=" + scid);
		s.setScId(Integer.parseInt(scid));
		scservice.delet(s);
		return "1";
	}
	@RequestMapping("/rback")
	@ResponseBody
	public String rback(HttpServletRequest request) {
		logger.info("delete....");
		// String currentpage=request.getParameter("page");
		String scid = request.getParameter("scid").trim();
		Score s = new Score();
		System.out.println("   scid=" + scid);
		s.setScId(Integer.parseInt(scid));
		scservice.rdata(s);
		return "1";
	}

	@RequestMapping("/update")
	@ResponseBody
	public Score update(HttpServletRequest request) {
		logger.info("update....");
		// String currentpage=request.getParameter("page");
		String scid = request.getParameter("scid");
		System.out.println("   scid=" + scid);
		Score stu = new Score();
		stu.setScId(Integer.parseInt(scid));
		return getDateToString(scservice.getOneScoreInfo(stu));
	}

	@RequestMapping("/updateScore")
	@ResponseBody
	public String updateStuInfo(HttpServletRequest request) {
		logger.info("updateScore....");
		String scid = request.getParameter("scid");
		String marks = request.getParameter("marks");
		System.out.println("   scid=" + scid + " marks=" + marks);
		Score stu = new Score();
		stu.setScId(Integer.parseInt(scid));
		stu.setMarks(Double.parseDouble(marks));
		scservice.updateScore(stu);
		return "1";
	}

	@RequestMapping("/add")
	@ResponseBody
	public StuInfo add(HttpServletRequest request) {
		logger.info("add....");
		String sid = request.getParameter("sid");
		System.out.println("   sid=" + sid);
		StuInfo s = new StuInfo();
		s.setsId(Integer.parseInt(sid));
		StuInfo stu = sservice.getOneStu(s);
		return stu;
	}

	@RequestMapping("/addScore")
	@ResponseBody
	public String addScore(HttpServletRequest request) {
		logger.info("addScore....");
		String asno = request.getParameter("asno").trim();
		String marks=request.getParameter("marks").trim();
		String subjectname=request.getParameter("subjectname").trim();
		String year=request.getParameter("year").trim();
		String turn=request.getParameter("turn").trim();
		String gid=request.getParameter("gid").trim();
		String cid=request.getParameter("cid").trim();
		if(turn.equals("1")){
			year=year.concat("-01-01");
		}else{
			year=year.concat("-08-01");
		}
		Score s=new Score();
		s.setgId(Integer.parseInt(gid));
		s.setcId(Integer.parseInt(cid));
		s.setsNo(asno);
		s.setMarksYear(DateUtil.getDateFromStr(year, "yyyy-mm-dd"));
		s.setSubjectName(subjectname);
		s.setMarks(Double.parseDouble(marks));
		s.setTurn(Integer.parseInt(turn));
		scservice.addScore(s);
		return "1";
	}
	
	@RequestMapping("/totalPage")
	@ResponseBody
	public int totalPage(HttpServletRequest request) {
		logger.info("totalPage....");
		int allpage = 1;
		String gradeName = request.getParameter("gradename").trim();
		String className = request.getParameter("classname").trim();
		String subjectName = request.getParameter("subjectname").trim();
		String sno = request.getParameter("sno").trim();
		String minscore = request.getParameter("minscore").trim();
		String maxscore = request.getParameter("maxscore").trim();
		String state=request.getParameter("state").trim();
		Score s = new Score();
		System.out.println(!gradeName.equals("请选择年级"));
		if (gradeName != "" && !gradeName.equals("请选择年级")) {
			s.setgId(Integer.parseInt(gradeName));
		}
		if (className !="" && !className.equals("请选择班级")&&!className.equals("wxy")) {
			s.setcId(Integer.parseInt(className));
		}
		if (subjectName != "" && !subjectName.equals("请选择学科")) {
			s.setSubjectName(subjectName);
		}
		if (sno != "") {
			s.setsNo(sno);
		}
		if (minscore != "") {
			s.setMinMarks(Double.parseDouble(minscore));
		}
		if (maxscore != "") {
			s.setMaxMarks(Double.parseDouble(maxscore));
		}
		if(!state.equals("0")){
			s.setScState(Integer.parseInt(state));
		}
		System.out.println("1===================" + s);
		ArrayList<Score> total = scservice.totalScore(s);
		System.out.println("total:====" + total.size());
		int pagesize = 5;// 每页显示的条数
		int allcounts = total.size();// 总条数
		if (allcounts > 0) {
			allpage = (allcounts - 1) / pagesize + 1;// 总页数
		}
		return allpage;
	}

	public static ArrayList<Score> addDateToString(ArrayList<Score> s) {
		for (int i = 0; i < s.size(); i++) {
			s.get(i).setTimeMarks(DateUtil.getStrFromDate(s.get(i).getMarksYear(), "yyyy"));
		}
		return s;
	}

	public static Score getDateToString(Score s) {
		s.setTimeMarks(DateUtil.getStrFromDate(s.getMarksYear(), "yyyy"));
		return s;
	}
}
