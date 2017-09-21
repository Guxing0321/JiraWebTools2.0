package com.jira.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jira.po.ClassInfo;
import com.jira.po.Grade;
import com.jira.po.Score;
import com.jira.po.StuInfo;
import com.jira.service.ClassService;
import com.jira.service.GradeService;
import com.jira.service.ScoreService;
import com.jira.service.StuInfoService;

import io.swagger.annotations.Api;

@Api("Demo测试")
@Controller
@RequestMapping("/gc")
public class GradeController {
	@Autowired
	private GradeService gservice;
	@Autowired
	private StuInfoService sservice;
	@Autowired
	private ClassService cservice;	
	@Autowired
	private ScoreService scservice;
	private Logger logger = Logger.getLogger(GradeController.class);
	
	@RequestMapping("/tograde")
	public String exit(Model model) {
		logger.info("tograde....");
		Grade g=new Grade();
		ArrayList<Grade> gradelist=gservice.getGradeByState(g);
		System.out.println(gradelist);
		model.addAttribute("glist", gradelist);
		return "grade";
	}
	@RequestMapping("/gradeName")
	@ResponseBody
	public ArrayList<Grade> gradeName(HttpServletRequest request) {
		logger.info("gradeName....");
		Grade g=new Grade();
//		g.setgState(1);
		ArrayList<Grade> stu=gservice.getGradeByState(g);
		System.out.println(stu);
		return stu;
	}
	
	@RequestMapping("/grade")
	@ResponseBody
	public ArrayList<Grade> grade(HttpServletRequest request) {
		logger.info("grade....");
		int allpage=1;//默认总页数为1
		int currentpage=1;//默认当前页为第一页
		String page=request.getParameter("page").trim();
		String gname=request.getParameter("gname").trim();
		String state=request.getParameter("gstate").trim();
		Grade gs=new Grade();
		if(!gname.equals("请选择年级")){
			gs.setgName(gname);
		}
		if(!state.equals("0")){
			gs.setgState(Integer.parseInt(state));
		}
		if(page!=null&&page!=""){
			currentpage=Integer.parseInt(page);
		}
		System.out.println("grade======"+gs);
		ArrayList<Grade> g=gservice.total(gs);
		int pagesize=2;//每页显示的条数
		int allcounts=g.size();//总条数
		System.out.println(" grade size="+allcounts);
		ArrayList<Grade> stu=new ArrayList<Grade>();
		if(allcounts!=0){
			allpage=(allcounts-1)/pagesize+1;//总页数
			gs.setLimita((currentpage-1)*pagesize);
			gs.setLimitb(pagesize);
			stu=gservice.getLimitGrade(gs);
			stu.get(0).setTotalPage(allpage);
			stu.get(0).setCurrentPage(currentpage);
			stu.get(0).setPageCount(pagesize);
			stu.get(0).setTotalDate(allcounts);
		}
		System.out.println("stu======="+stu);
		return stu;
	}
	@RequestMapping("/gtotalPage")
	@ResponseBody
	public int gtotalPage(HttpServletRequest request) {
		logger.info("gtotalPage....");
		String gname=request.getParameter("gname").trim();
		String state=request.getParameter("gstate").trim();
		Grade gs=new Grade();
		if(!gname.equals("请选择年级")){
			gs.setgName(gname);
		}
		if(!state.equals("0")){
			gs.setgState(Integer.parseInt(state));
		}
		int allpage=1;
		ArrayList<Grade> total=gservice.total(gs);
		int pagesize=2;//每页显示的条数
		int allcounts=total.size();//总条数
		if(allcounts>0){
			allpage=(allcounts-1)/pagesize+1;//总页数
		}
		System.out.println("总页数++++++++++++++++++++++++"+allpage );
		return allpage;
	}
	@RequestMapping("/gdelete")
	@ResponseBody
	public String  gdelete(HttpServletRequest request) {
		String gid=request.getParameter("gid").trim();
		Grade grade=new Grade();
		grade.setgId(Integer.parseInt(gid));
		StuInfo stu=new StuInfo();
		stu.setgId(Integer.parseInt(gid));
		ClassInfo c=new ClassInfo();
		c.setgId(Integer.parseInt(gid));
		Score sc=new Score();
		sc.setgId(Integer.parseInt(gid));
		scservice.delet(sc);
		sservice.delet(stu);
		cservice.delet(c);
		gservice.delet(grade);
		String s="1";
		return s;
	}
	@RequestMapping("/gr")
	@ResponseBody
	public String  gr(HttpServletRequest request) {
		String gid=request.getParameter("gid").trim();
		Grade grade=new Grade();
		grade.setgId(Integer.parseInt(gid));
		StuInfo stu=new StuInfo();
		stu.setgId(Integer.parseInt(gid));
		ClassInfo c=new ClassInfo();
		c.setgId(Integer.parseInt(gid));
		Score sc=new Score();
		sc.setgId(Integer.parseInt(gid));
		scservice.rdata(sc);
		sservice.rdata(stu);
		cservice.rdata(c);
		gservice.rdata(grade);
		String s="1";
		return s;
	}
	@RequestMapping("/gupdate")
	@ResponseBody
	public Grade  gupdate(HttpServletRequest request) {
		logger.info("gupdate....");
//		String currentpage=request.getParameter("page");
		String gid=request.getParameter("gid");
		System.out.println("   gid="+gid);
		Grade g=new Grade();
		g.setgId(Integer.parseInt(gid));
		return gservice.getOne(g);
	}
	@RequestMapping("/sameGname")
	@ResponseBody
	public String  sameGname(HttpServletRequest request) {
		logger.info("sameGname....");
		String result="";
		String gname=request.getParameter("gname").trim();
		Grade g=new Grade();
		g.setgName(gname);
		Grade s=gservice.isExit(g);
		if(s==null){
			result="0";
		}else{
			result="1";
		}
		return result;
	}
	@RequestMapping("/addGrade")
	@ResponseBody
	public String  addGrade(HttpServletRequest request) {
		logger.info("addStu....");
		String gname=request.getParameter("gname").trim();
		Grade g=new Grade();
		g.setgName(gname);
		g.setgState(1);
		g.setgDate(new Date());
		gservice.insert(g);
		return "1";
	}
	@RequestMapping("/updateGrade")
	@ResponseBody
	public String  updateGrade(HttpServletRequest request) {
		logger.info("updateGrade....");
		String gid=request.getParameter("gid");
		String gname=request.getParameter("gname");
		System.out.println("   gid="+gid+" gname="+gname);
		Grade g=new Grade();
		g.setgId(Integer.parseInt(gid));
		g.setgName(gname);
		gservice.update(g);
		return "1";
	}
}
