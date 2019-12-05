package ssm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssm.entity.ResultMsg;
import ssm.entity.RolePermission;
import ssm.entity.Student;
import ssm.entity.Teacher;
import ssm.entity.User;
import ssm.service.LoginService;
import ssm.service.StudentService;
import ssm.service.TeacherService;

//登录控制器
@Controller
public class LoginController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherservice;
	@Autowired
	private LoginService loginservice;
	//进入登录页面
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView("login");//跳转到login.jsp页面
		return mv;//返回mv
	}

	//学生登录反馈
	@RequestMapping("/Stuloginsub")
	@ResponseBody
	public ResultMsg loginsub(int username,String password,HttpSession session) {
		Student stu=new Student();//实例化
		stu.setStudent_id(username);//传值
		stu.setPassword(password);
		boolean flag=studentService.login(stu);//得到登录反馈
		ResultMsg rs=null;
		if(flag) {
			Student student=studentService.getStudentByid(username);//根据学号的到学生的所有信息
			
			User u=new User();
			u.setName(student.getStudent_name());
			u.setUserId(username);
			u.setRole(2);
			
			List<RolePermission> list=loginservice.getPerByRoleid(2);//获取学生的权限列表
			session.setAttribute("user", u);
			session.setAttribute("permission", list);
			rs=new ResultMsg(1, "登录成功");//成功
		}else {
			rs=new ResultMsg(0, "登录失败");//失败
		}
		return rs;
	}
	
	
	//根据教师ID查找教师是否存在
		@RequestMapping("/TeacherLogin")
		@ResponseBody
		public ResultMsg find(int username,String password,HttpSession session) {
			int i  = teacherservice.FindTeacher(username);
			Teacher teacher = teacherservice.FindTeacherMSG(username);//根据工号查找所有信息并存入teacher实体类
			String pass = teacher.getPassword();//从数据库取出当前工号教师的密码	
			if(i>0&&teacher.getRole_id()==1) {//进行查询判断，工号是否存在,1为教师
				if(pass.equals(password)) {//进行密码判断，密码是否正确		
					User u=new User();//用户实体，用于传送数据到前端
					u.setName(teacher.getTeacher_name());
					u.setUserId(username);
					u.setRole(1);
					
					List<RolePermission> list=loginservice.getPerByRoleid(1);//获取教师的权限列表
					
					session.setAttribute("user", u);
					session.setAttribute("permission", list);
					return new ResultMsg(1, "登陆成功！！");//自定义实体类的返回类型
				}else {
					return new ResultMsg(2, "密码错误！！");
				}
			}
			return new ResultMsg(3, "该用户名不存在！！");
		}
		
	//管理员登录
		@RequestMapping("/adminLogin")
		@ResponseBody
		public ResultMsg admindLogin(int username,String password,HttpSession session) {
			int i  = teacherservice.FindTeacher(username);
			Teacher teacher = teacherservice.FindTeacherMSG(username);//根据工号查找所有信息并存入teacher实体类
			String pass = teacher.getPassword();//从数据库取出当前工号教师的密码		
			if(i>0&&teacher.getRole_id()==3) {//进行查询判断，工号是否存在,3为管理员
				if(pass.equals(password)) {//进行密码判断，密码是否正确		
					User u=new User();//用户实体，用于传送数据到前端
					u.setName(teacher.getTeacher_name());
					u.setUserId(username);
					u.setRole(3);
					
					List<RolePermission> list=loginservice.getPerByRoleid(3);//获取管理员的权限列表
					
					session.setAttribute("user", u);
					session.setAttribute("permission", list);
					return new ResultMsg(1, "登陆成功！！");//自定义实体类的返回类型
				}else {
					return new ResultMsg(2, "密码错误！！");
				}
			}
			return new ResultMsg(3, "该用户名不存在！！");
		}
	//登录后的主页
		@RequestMapping("/index")
		public ModelAndView index() {
			ModelAndView mv=new ModelAndView("index");//跳转到login.jsp页面
			return mv;//返回mv
		}
	//welcome
		@RequestMapping("welcome")
		public ModelAndView index2() {
			ModelAndView mv=new ModelAndView("welcome");
			return mv;
		}
	//echart
		@RequestMapping("echart")
		public ModelAndView index3() {
			ModelAndView mv=new ModelAndView("echart");
			return mv;
		}

}
