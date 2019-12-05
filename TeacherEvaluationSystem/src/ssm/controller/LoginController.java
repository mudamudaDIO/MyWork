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

//��¼������
@Controller
public class LoginController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherservice;
	@Autowired
	private LoginService loginservice;
	//�����¼ҳ��
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView("login");//��ת��login.jspҳ��
		return mv;//����mv
	}

	//ѧ����¼����
	@RequestMapping("/Stuloginsub")
	@ResponseBody
	public ResultMsg loginsub(int username,String password,HttpSession session) {
		Student stu=new Student();//ʵ����
		stu.setStudent_id(username);//��ֵ
		stu.setPassword(password);
		boolean flag=studentService.login(stu);//�õ���¼����
		ResultMsg rs=null;
		if(flag) {
			Student student=studentService.getStudentByid(username);//����ѧ�ŵĵ�ѧ����������Ϣ
			
			User u=new User();
			u.setName(student.getStudent_name());
			u.setUserId(username);
			u.setRole(2);
			
			List<RolePermission> list=loginservice.getPerByRoleid(2);//��ȡѧ����Ȩ���б�
			session.setAttribute("user", u);
			session.setAttribute("permission", list);
			rs=new ResultMsg(1, "��¼�ɹ�");//�ɹ�
		}else {
			rs=new ResultMsg(0, "��¼ʧ��");//ʧ��
		}
		return rs;
	}
	
	
	//���ݽ�ʦID���ҽ�ʦ�Ƿ����
		@RequestMapping("/TeacherLogin")
		@ResponseBody
		public ResultMsg find(int username,String password,HttpSession session) {
			int i  = teacherservice.FindTeacher(username);
			Teacher teacher = teacherservice.FindTeacherMSG(username);//���ݹ��Ų���������Ϣ������teacherʵ����
			String pass = teacher.getPassword();//�����ݿ�ȡ����ǰ���Ž�ʦ������	
			if(i>0&&teacher.getRole_id()==1) {//���в�ѯ�жϣ������Ƿ����,1Ϊ��ʦ
				if(pass.equals(password)) {//���������жϣ������Ƿ���ȷ		
					User u=new User();//�û�ʵ�壬���ڴ������ݵ�ǰ��
					u.setName(teacher.getTeacher_name());
					u.setUserId(username);
					u.setRole(1);
					
					List<RolePermission> list=loginservice.getPerByRoleid(1);//��ȡ��ʦ��Ȩ���б�
					
					session.setAttribute("user", u);
					session.setAttribute("permission", list);
					return new ResultMsg(1, "��½�ɹ�����");//�Զ���ʵ����ķ�������
				}else {
					return new ResultMsg(2, "������󣡣�");
				}
			}
			return new ResultMsg(3, "���û��������ڣ���");
		}
		
	//����Ա��¼
		@RequestMapping("/adminLogin")
		@ResponseBody
		public ResultMsg admindLogin(int username,String password,HttpSession session) {
			int i  = teacherservice.FindTeacher(username);
			Teacher teacher = teacherservice.FindTeacherMSG(username);//���ݹ��Ų���������Ϣ������teacherʵ����
			String pass = teacher.getPassword();//�����ݿ�ȡ����ǰ���Ž�ʦ������		
			if(i>0&&teacher.getRole_id()==3) {//���в�ѯ�жϣ������Ƿ����,3Ϊ����Ա
				if(pass.equals(password)) {//���������жϣ������Ƿ���ȷ		
					User u=new User();//�û�ʵ�壬���ڴ������ݵ�ǰ��
					u.setName(teacher.getTeacher_name());
					u.setUserId(username);
					u.setRole(3);
					
					List<RolePermission> list=loginservice.getPerByRoleid(3);//��ȡ����Ա��Ȩ���б�
					
					session.setAttribute("user", u);
					session.setAttribute("permission", list);
					return new ResultMsg(1, "��½�ɹ�����");//�Զ���ʵ����ķ�������
				}else {
					return new ResultMsg(2, "������󣡣�");
				}
			}
			return new ResultMsg(3, "���û��������ڣ���");
		}
	//��¼�����ҳ
		@RequestMapping("/index")
		public ModelAndView index() {
			ModelAndView mv=new ModelAndView("index");//��ת��login.jspҳ��
			return mv;//����mv
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
