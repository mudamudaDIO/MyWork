package ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.Answer;
import ssm.entity.Question;
import ssm.entity.ResultMsg;
import ssm.entity.Score;
import ssm.entity.Teacher;
import ssm.entity.User;
import ssm.service.TeacherService;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherservice;

	//修改教师密码
	@RequestMapping("/changeTeacherpass")
	@ResponseBody
	public ResultMsg changeTpass(String oldpassword,String newpass,HttpSession session) {
		User u = (User)session.getAttribute("user");
		Teacher teacher = new Teacher();
		teacher.setPassword(newpass);
		teacher.setTeacher_id(u.getUserId());
		Teacher teacher1 = teacherservice.FindTeacherMSG(u.getUserId());
		String oldpass = teacher1.getPassword();
		if(oldpassword.equals(oldpass)) {
			if(newpass.equals(oldpassword)) {
				return new ResultMsg(0, "不能与原密码一致！！");
			}else{
				int i = teacherservice.changepass(teacher);
				if(i>0) {
					return new ResultMsg(1, "密码修改成功！！");
				}else {
					return new ResultMsg(3, "密码修改失败！！");
				}
			}		
		}else {
				return new ResultMsg(2, "原密码错误！！");
		}
		 	
}
	
	//根据ID查找所有教师信息
	@RequestMapping("/allteachermsg")
	public ModelAndView list(HttpSession session) {
		User u = (User)session.getAttribute("user");
		List<Teacher> list = teacherservice.getteacherallmsg(u.getUserId());
		ModelAndView mv = new ModelAndView("teacher/Tperson");
		mv.addObject("teachermsg", list);
		return mv;
	}
	
	
	//教师对同行进行评价，将评价分数存入数据库
	@RequestMapping("/addvote")
	@ResponseBody
	public ResultMsg vote(int bevote_id,String id1,String id2,String id3,String id4,String id5
			,String id6,String id7,String id8,String id9
			,String id10,String text,HttpSession session) {
		User u = (User)session.getAttribute("user");
		int vote_id = u.getUserId();
		int type = u.getRole();
		//将前台评教结果获取并存入Answer实体类中
		Answer answer = new Answer();
		answer.setVote_id(vote_id);
		answer.setBevote_id(bevote_id);
		answer.setAnswer_1(id1);
		answer.setAnswer_2(id2);
		answer.setAnswer_3(id3);
		answer.setAnswer_4(id4);
		answer.setAnswer_5(id5);
		answer.setAnswer_6(id6);
		answer.setAnswer_7(id7);
		answer.setAnswer_8(id8);
		answer.setAnswer_9(id9);
		answer.setAnswer_10(id10);
		answer.setScore(Score.countScore(id1, id2, id3, id4, id5, id6, id7, id8, id9, id10));
		answer.setType(type);
		answer.setBeizu(text);
		//调取addvoteScore方法，将结果存入数据库
		int i = teacherservice.addVoteScore(answer);
		if(i>0) {
			return new ResultMsg(1, "评教成功！！");
		}else {
			return new ResultMsg(2, "评教失败！！");
		}
			
	}
	
	
	//获取所有问题
	@RequestMapping("/getquestion")
		public ModelAndView getquestion(int bevote_id) {
		List<Question> list = teacherservice.getQuestion();
		ModelAndView mv = new ModelAndView("teacher/Tvote");
		mv.addObject("getquestion", list);
		mv.addObject("bevote_id", bevote_id);
		return mv;
	}
	
	//获取同行对自己评价的分数
	@RequestMapping("/getscore")
		public ModelAndView getscore(HttpSession session) {
		User u = (User)session.getAttribute("user");
		int bevote_id = u.getUserId();
		List<Answer> list = teacherservice.getscore(bevote_id);
		ModelAndView mv = new ModelAndView("teacher/lookvote");
		mv.addObject("getscore", list);
		return mv;
	}
	
	//获取评教信息详情
	@RequestMapping("/getadventure")
	public ModelAndView getadventure(int vote_id,HttpSession session) {
		User u = (User)session.getAttribute("user");
		int bevote_id = u.getUserId();
		Answer an = new Answer();
		an.setVote_id(vote_id);
		an.setBevote_id(bevote_id);
		Answer a = teacherservice.getadventure(an);
		List<Question> list1 = teacherservice.getQuestion();
		
		list1.get(0).setAnswer(a.getAnswer_1());
		list1.get(1).setAnswer(a.getAnswer_2());
		list1.get(2).setAnswer(a.getAnswer_3());
		list1.get(3).setAnswer(a.getAnswer_4());
		list1.get(4).setAnswer(a.getAnswer_5());
		list1.get(5).setAnswer(a.getAnswer_6());
		list1.get(6).setAnswer(a.getAnswer_7());
		list1.get(7).setAnswer(a.getAnswer_8());
		list1.get(8).setAnswer(a.getAnswer_9());
		list1.get(9).setAnswer(a.getAnswer_10());

		ModelAndView mv = new ModelAndView("teacher/adventure");
		mv.addObject("adventure", a);
		mv.addObject("getqu", list1);
		return mv;
}
	//访问修改密码页面
		@RequestMapping("/changepass")
		public ModelAndView change() {
			ModelAndView mv = new ModelAndView("teacher/changepass");
			return mv; 
}
		
		//遍历所有教师
		@RequestMapping("/teacherList")
			public ModelAndView teacherList(HttpSession session){
			User u = (User)session.getAttribute("user");
			List<Teacher> teacher1 = teacherservice.getteacherallmsg(u.getUserId());
			String ins_name = teacher1.get(0).getIns().getIns_name();
			List<Teacher> list = teacherservice.teacherList(ins_name);
			List<Teacher> list1 = new ArrayList<>();//建立新的list集合，将非当前登录用户的信息存入新的集合中
			for(Teacher teacher:list) {
				if(teacher.getTeacher_id()!=u.getUserId()) {
					list1.add(teacher);
				}
			}
			List<Answer> answer = teacherservice.getIsvote(u.getUserId());
			for(Teacher teacher:list1) {
				teacher.setIsvote(false);
				for(Answer an:answer) {
					if(an.getBevote_id()==teacher.getTeacher_id()) {
						teacher.setIsvote(true);
					}
				}
			}
			ModelAndView mv = new ModelAndView("teacher/TeacherList");
				mv.addObject("teacherList", list1);
				return mv;
			}
		
		//获取所有教师分数信息，进行统计
		@RequestMapping("/echart")
		public ModelAndView echart() {
			List<Answer> list = teacherservice.getallscore();
			ModelAndView mv=new ModelAndView("echart");
			mv.addObject("echart", list);
			return mv;
		}
}
		
