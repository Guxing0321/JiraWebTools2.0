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
import com.jira.until.DateUtil;

import io.swagger.annotations.Api;

@Api("Demo测试")
@Controller
@RequestMapping("/cg")
public class ClassController {
	@Autowired
	private GradeService gservice;
	@Autowired
	private ClassService cservice;	
	@Autowired
	private StuInfoService sservice;
	@Autowired
	private ScoreService scservice;
	private Logger logger = Logger.getLogger(ClassController.class);
	@RequestMapping("/toclass")
	public String exit(Model model) {
		logger.info("tograde....");
		Grade g=new Grade(); ArrayList<Grade> gradelist=gservice.getGradeByState(g);
		System.out.println(gradelist);
		model.addAttribute("glist", gradelist);
		return "class";
	}
	@RequestMapping("/cName")
	@ResponseBody
	public ArrayList<ClassInfo> gradeName(HttpServletRequest request) {
		logger.info("cName....");
		String gid=request.getParameter("gid").trim();
		ClassInfo c=new ClassInfo();
		ArrayList<ClassInfo> list=new ArrayList<ClassInfo>();
		if(!gid.equals("请选择年级")){
			c.setgId(Integer.parseInt(gid));
//			c.setcState(1);
			list=cservice.getClassInfoByState(c);
		}
		System.out.println(list);
		return list;
	}
	@RequestMapping("/grade")
	@ResponseBody
	public ArrayList<ClassInfo> grade(HttpServletRequest request) {
		logger.info("grade....");
		int allpage=1;//默认总页数为1
		int currentpage=1;//默认当前页为第一页
		String page=request.getParameter("page").trim();
		String gid=request.getParameter("gid").trim();
		String cname=request.getParameter("cname").trim();
		String state=request.getParameter("cstate").trim();
		ClassInfo c=new ClassInfo();
		System.out.println(gid+"  ===="+cname+"=      "+state);
		System.out.println(cname!=null);
		if(page!=null&&page!=""){
			currentpage=Integer.parseInt(page);
		}
		if(!gid.equals("请选择年级")){
			c.setgId(Integer.parseInt(gid));
		}
		if(!cname.equals("请选择班级")&&!cname.equals("wxy")){
			c.setcName(cname);
		}
		if(!state.equals("0")){
			c.setcState(Integer.parseInt(state));
		}
		System.out.println(c);
		ArrayList<ClassInfo> g=cservice.total(c);
		int pagesize=2;//每页显示的条数
		int allcounts=g.size();//总条数
		System.out.println(" grade size="+allcounts);
		ArrayList<ClassInfo> stu=new ArrayList<ClassInfo>();
		if(allcounts!=0){
			allpage=(allcounts-1)/pagesize+1;//总页数
			c.setLimita((currentpage-1)*pagesize);
			c.setLimitb(pagesize);
			stu=cservice.getLimitClass(c);
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
		int allpage=1;
		String gid=request.getParameter("gid").trim();
		String cname=request.getParameter("cname").trim();
		String state=request.getParameter("cstate").trim();
		ClassInfo c=new ClassInfo();
		if(!gid.equals("请选择年级")){
			c.setgId(Integer.parseInt(gid));
		}
		if(!cname.equals("请选择班级")&&!cname.equals("wxy")){
			c.setcName(cname);
		}
		if(!state.equals("0")){
			c.setcState(Integer.parseInt(state));
		}
		System.out.println(c);
		ArrayList<ClassInfo> total=cservice.total(c);
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
		logger.info("gdelete....");
		String cid=request.getParameter("cid").trim();
		ClassInfo c=new ClassInfo();
		c.setcId(Integer.parseInt(cid));
		StuInfo stu=new StuInfo();
		stu.setcId(Integer.parseInt(cid));
		Score s=new Score();
		s.setcId(Integer.parseInt(cid));
		scservice.delet(s);
		sservice.delet(stu);
		cservice.delet(c);
		return "1";
	}
	@RequestMapping("/rback")
	@ResponseBody
	public String  rback(HttpServletRequest request) {
		logger.info("gdelete....");
		String cid=request.getParameter("cid").trim();
		ClassInfo c=new ClassInfo();
		c.setcId(Integer.parseInt(cid));
		StuInfo stu=new StuInfo();
		stu.setcId(Integer.parseInt(cid));
		Score s=new Score();
		s.setcId(Integer.parseInt(cid));
		scservice.rdata(s);
		sservice.rdata(stu);
		cservice.rdata(c);
		return "1";
	}
	@RequestMapping("/gupdate")
	@ResponseBody
	public ClassInfo  gupdate(HttpServletRequest request) {
		logger.info("gupdate....");
//		String currentpage=request.getParameter("page");
		String cid=request.getParameter("cid");
		System.out.println("   cid="+cid);
		ClassInfo c=new ClassInfo();
		c.setcId(Integer.parseInt(cid));
		return cservice.getOne(c);
	}
	@RequestMapping("/sameCname")
	@ResponseBody
	public String  sameCname(HttpServletRequest request) {
		logger.info("sameCname....");
		String result="";
		String cname=request.getParameter("cname").trim();
		String gid=request.getParameter("gid").trim();
		ClassInfo c=new ClassInfo();
		c.setcName(cname);
		c.setgId(Integer.parseInt(gid));
		System.out.println(c);
		ClassInfo s=cservice.isExit(c);
		if(s==null){
			result="0";
		}else{
			result="1";
		}
		return result;
	}
	@RequestMapping("/addClass")
	@ResponseBody
	public String  addClass(HttpServletRequest request) {
		logger.info("addClass....");
		String cname=request.getParameter("cname").trim();
		String gid=request.getParameter("gid").trim();
		ClassInfo c=new ClassInfo();
		c.setcName(cname);
		c.setgId(Integer.parseInt(gid));
		c.setcState(1);
		Date d=new Date();
		System.out.println(DateUtil.getStrFromDate(d, "yyyy-mm-dd"));
		c.setcDate(d);
		cservice.insert(c);
		return "1";
	}
	@RequestMapping("/updateGrade")
	@ResponseBody
	public String  updateGrade(HttpServletRequest request) {
		logger.info("updateGrade....");
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		String gid=request.getParameter("gid");
		System.out.println("   cid="+cid+" cname="+cname+"   "+gid);
		ClassInfo c=new ClassInfo();
		c.setcId(Integer.parseInt(cid));
		c.setcName(cname);
		c.setgId(Integer.parseInt(gid));
		cservice.update(c);
		return "1";
	}
}
