package com.jira.controller;

import java.util.ArrayList;

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
@RequestMapping("/wxy")
public class StudentContorl {
	@Autowired
	private ClassService cservice;	
	@Autowired
	private GradeService gservice;
	@Autowired
	private StuInfoService sservice;
	@Autowired
	private ScoreService scservice;
	private Logger logger = Logger.getLogger(StudentContorl.class);

	@RequestMapping("/exit")
	public String exit(HttpServletRequest request) {
		logger.info("exit....");
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("password");
		request.getSession().setAttribute("username", "没人");
		request.getSession().setAttribute("password", "没密码");
		return "login";
	}

	@RequestMapping("/stuinfo")
	public String stuInfo(Model model) {
		logger.info("stuinfo....");
		Grade g=new Grade();
		ArrayList<Grade> gradelist=gservice.getGradeByState(g);
		System.out.println(gradelist);
		model.addAttribute("glist", gradelist);
		return "stuinfo";
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
			c.setcState(1);
			list=cservice.getClassInfoByState(c);
		}
		return list;
	}
	@RequestMapping("/score")
	public String score(Model model) {
		logger.info("score....");
		Grade g=new Grade();
		ArrayList<Grade> gradelist=gservice.getGradeByState(g);
		System.out.println(gradelist);
		model.addAttribute("glist", gradelist);
		return "score";
	}
	@RequestMapping("/table")
	@ResponseBody
	public ArrayList<StuInfo> table(HttpServletRequest request) {
		logger.info("table....");
		int allpage=1;
		String gradeName=request.getParameter("gradename").trim();
		String className=request.getParameter("classname").trim();
		String sno=request.getParameter("sno").trim();
		String place=request.getParameter("place").trim();
		String page=request.getParameter("page").trim();
		String begin=request.getParameter("begin").trim();
		String end=request.getParameter("end").trim();
		String state=request.getParameter("state").trim();
		String begin1=request.getParameter("begin1").trim();
		int currentpage=1;
		if(page!=null&&page!=""){
			currentpage=Integer.parseInt(page);
		}
		System.out.println("grage:"+gradeName+"  class:"+className+"    sno:"+sno+"   place:"+place);
		System.out.println("当前页==="+page);
		StuInfo s=new StuInfo();
		System.out.println(!gradeName.equals("请选择年级"));
		if(gradeName!=""&&!gradeName.equals("请选择年级")){
			s.setgId(Integer.parseInt(gradeName));
		}
		if(className!=""&&!className.equals("请选择班级")&&!className.equals("wxy")){
			s.setcName(className);
		}
		if(sno!=""){
			s.setsNo(sno);
		}
		if(place!=""){
			s.setPlace(place.trim());
		}
		if(begin!=""){
			s.setEntryTime(DateUtil.getDateFromStr(begin, "yyyy-MM-dd"));
		}
		if(begin1!=""){
			s.setEndEntryTime(DateUtil.getDateFromStr(begin1, "yyyy-MM-dd"));
		}
		if(end!=""){
			s.setLeaveTime(DateUtil.getDateFromStr(end, "yyyy-MM-dd"));
		}
		if(!state.equals("0")){
			s.setStuState(Integer.parseInt(state));
		}
		System.out.println("1==================="+s);
		ArrayList<StuInfo> total=sservice.total(s);
		ArrayList<StuInfo> stu=new ArrayList<StuInfo>();
		System.out.println("total:===="+total.size());
		int pagesize=5;//每页显示的条数
		int allcounts=total.size();//总条数
		if(allcounts!=0){
			allpage=(allcounts-1)/pagesize+1;//总页数
			s.setCurrentPage((currentpage-1)*pagesize);
			s.setPageCount(pagesize);
			System.out.println("2==================="+s);
			stu=sservice.getStu(s);
			stu.get(0).setTotalPage(allpage);
			stu.get(0).setCurrentPage(currentpage);
			stu.get(0).setPageCount(pagesize);
			stu.get(0).setTotalDate(allcounts);
		}
		System.out.println("stu======="+stu);
		return stu;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String  delete(HttpServletRequest request) {
		logger.info("delete....");
//		String currentpage=request.getParameter("page");
		String sid=request.getParameter("sid").trim();
		StuInfo stu=new StuInfo();
		System.out.println("   sid="+sid);
		stu.setsId(Integer.parseInt(sid));
		StuInfo st=sservice.getOneStu(stu);
		Score sc=new Score();
		sc.setsNo(st.getsNo());
		ArrayList<Score> scorelist=scservice.ifExit(sc);
		if(scorelist.size()>0){
			scservice.delet(sc);
		}
		sservice.delet(stu);
		return "1";
	}
	@RequestMapping("/rback")
	@ResponseBody
	public String  rback(HttpServletRequest request) {
		logger.info("rback....");
//		String currentpage=request.getParameter("page");
		String sid=request.getParameter("sid").trim();
		StuInfo stu=new StuInfo();
		System.out.println("   sid="+sid);
		stu.setsId(Integer.parseInt(sid));
		StuInfo st=sservice.getOneStu(stu);
		Score sc=new Score();
		sc.setsNo(st.getsNo());
		ArrayList<Score> scorelist=scservice.ifExit(sc);
		if(scorelist.size()>0){
			scservice.rdata(sc);
		}
		sservice.rdata(stu);
		return "1";
	}
	@RequestMapping("/update")
	@ResponseBody
	public StuInfo  update(HttpServletRequest request) {
		logger.info("update....");
//		String currentpage=request.getParameter("page");
		String sid=request.getParameter("sid");
		System.out.println("   sid="+sid);
		StuInfo stu=new StuInfo();
		stu.setsId(Integer.parseInt(sid));
		return sservice.getOneStu(stu);
	}
	@RequestMapping("/updateStuInfo")
	@ResponseBody
	public String  updateStuInfo(HttpServletRequest request) {
		logger.info("updateStuInfo....");
		String result="1";
		String sid=request.getParameter("sid");
		String gid=request.getParameter("gid").trim();
		String cid=request.getParameter("cid").trim();
		String sname=request.getParameter("sname").trim();
		String sex=request.getParameter("sex").trim();
		String phone=request.getParameter("phone").trim();
		String place=request.getParameter("place").trim();
		String time=request.getParameter("time").trim();
		String timeLeave=request.getParameter("time1").trim();
		StuInfo stu=new StuInfo();
		stu.setgId(Integer.parseInt(gid));
		stu.setcId(Integer.parseInt(cid));
		stu.setsName(sname);
		stu.setSex(Integer.parseInt(sex));
		stu.setsPhone(phone);
		stu.setPlace(place);
		stu.setEntryTime(DateUtil.getDateFromStr(time, "yyyy-MM-dd"));
		stu.setLeaveTime(DateUtil.getDateFromStr(timeLeave, "yyyy-MM-dd"));
		stu.setsId(Integer.parseInt(sid));
		System.out.println(stu);
		sservice.updateStu(stu);
		return result;
	}
	@RequestMapping("/sameSno")
	@ResponseBody
	public String  sameSno(HttpServletRequest request) {
		logger.info("sameSno....");
		String result="";
		String sno=request.getParameter("sno").trim();
		StuInfo stu=new StuInfo();
		stu.setsNo(sno);
		StuInfo s=sservice.getOneStuBySno(stu);
		if(s==null){
			result="0";
		}else{
			result="1";
		}
		return result;
	}
	@RequestMapping("/addStu")
	@ResponseBody
	public String  addStu(HttpServletRequest request) {
		logger.info("addStu....");
		String sno=request.getParameter("sno").trim();
		String gid=request.getParameter("gid").trim();
		String cid=request.getParameter("cid").trim();
		String sname=request.getParameter("sname").trim();
		String sex=request.getParameter("sex").trim();
		String phone=request.getParameter("phone").trim();
		String place=request.getParameter("place").trim();
		String time=request.getParameter("time").trim();
		String timeLeave=request.getParameter("time1").trim();
		StuInfo stu=new StuInfo();
		stu.setsNo(sno);
		stu.setgId(Integer.parseInt(gid));
		stu.setcId(Integer.parseInt(cid));
		stu.setsName(sname);
		stu.setSex(Integer.parseInt(sex));
		stu.setsPhone(phone);
		stu.setPlace(place);
		stu.setEntryTime(DateUtil.getDateFromStr(time, "yyyy-MM-dd"));
		stu.setLeaveTime(DateUtil.getDateFromStr(timeLeave, "yyyy-MM-dd"));
		sservice.addStu(stu);
		return "1";
	}
	@RequestMapping("/totalPage")
	@ResponseBody
	public int totalPage(HttpServletRequest request) {
		logger.info("totalPage....");
		int allpage=1;
		String gradeName=request.getParameter("gradename").trim();
		String className=request.getParameter("classname").trim();
		String sno=request.getParameter("sno").trim();
		String place=request.getParameter("place").trim();
		String begin=request.getParameter("begin").trim();
		String end=request.getParameter("end").trim();
		String state=request.getParameter("state").trim();
		System.out.println("grage:"+gradeName+"  class:"+className+"    sno:"+sno+"   place:"+place);
		StuInfo s=new StuInfo();
		if(gradeName!=""&&!gradeName.equals("请选择年级")){
			s.setgId(Integer.parseInt(gradeName));
		}
		if(className!=""&&!className.equals("请选择班级")&&!className.equals("wxy")){
			s.setcName(className);
		}
		if(sno!=""){
			s.setsNo(sno);
		}
		if(place!=""){
			s.setPlace(place.trim());
		}
		if(begin!=""){
			s.setEntryTime(DateUtil.getDateFromStr(begin, "yyyy-MM-dd"));
		}
		if(end!=""){
			s.setLeaveTime(DateUtil.getDateFromStr(end, "yyyy-MM-dd"));
		}
		if(!state.equals("0")){
			s.setStuState(Integer.parseInt(state));
		}
		System.out.println("1==================="+s);
		ArrayList<StuInfo> total=sservice.total(s);
		int pagesize=5;//每页显示的条数
		int allcounts=total.size();//总条数
		if(allcounts>0){
			allpage=(allcounts-1)/pagesize+1;//总页数
		}
		return allpage;
	}
}
