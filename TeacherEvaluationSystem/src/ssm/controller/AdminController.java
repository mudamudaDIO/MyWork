package ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ssm.dao.AdminDao;
import ssm.entity.*;
import ssm.service.AdminService;
import ssm.service.LoginService;
import ssm.service.StudentService;
import ssm.service.TeacherService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired 
	AdminService adminservice;
	@Autowired
	LoginService loginservice;
	@Autowired
	StudentService studentservice;
	@Autowired
	TeacherService teacherservice;
	/********************************�鿴��Ϣ��תҳ�濪ʼ**********************************************************/
	//�鿴ѧ��
	@RequestMapping("/lookStudents")
	public ModelAndView lookStudents() {
		List<Student> list=adminservice.getStudents();
		ModelAndView mv=new ModelAndView("admin/lookStudents");
		mv.addObject("students", list);
		return mv;
	}
	//����Id��ѯѧ��(�������鿴ѧ��)
	@RequestMapping("/lookstudentById")
	public ModelAndView lookStudentById(int id) {
		Student s=adminservice.getStudentByid(id);
		ModelAndView mv=new ModelAndView("admin/lookStudents");
		mv.addObject("student", s);
		return mv;
	}
	//�鿴��ʦ
	@RequestMapping("/lookTeachers")
	public ModelAndView lookTeachers() {
		List<Teacher> list=adminservice.getTeachers();
		ModelAndView mv=new ModelAndView("admin/lookTeachers");
		mv.addObject("Teachers", list);
		return mv;
	}
	//����Id��ѯ��ʦ(�������鿴��ʦ)
	@RequestMapping("/lookTeacherByID")
	public ModelAndView lookTeacherByID(int id) {
		Teacher t=adminservice.getTeacherById(id);
		ModelAndView mv=new ModelAndView("admin/lookTeachers");
		mv.addObject("teacher", t);
		return mv;
	}
	//�鿴Ժϵ
	@RequestMapping("/lookIns")
	public ModelAndView lookIns() {
		List<Ins> list=adminservice.getIns();
		ModelAndView mv=new ModelAndView("admin/lookIns");
		mv.addObject("ins", list);
		return mv;
	}
	//����Id��ѯѧԺ(�������鿴ѧԺ)
	@RequestMapping("/lookInsByID")
	public ModelAndView lookInsByID(int id) {
		Ins ins=adminservice.getInsByID(id);
		ModelAndView mv=new ModelAndView("admin/lookIns");
		mv.addObject("Ins", ins);
		return mv;
	}
	//�鿴�˵�
	@RequestMapping("/lookMenu")
	public ModelAndView lookMenu() {
		List<Permission> list=loginservice.getper();
		ModelAndView mv=new ModelAndView("admin/lookMenus");
		mv.addObject("menu", list);
		return mv;
	}
	//�鿴��ɫ
	@RequestMapping("/lookRoles")
	public ModelAndView lookRoles() {
		List<Roles> list=adminservice.getroles();
		ModelAndView mv=new ModelAndView("admin/lookRoles");
		mv.addObject("roles", list);
		return mv;
	}
	//�鿴�γ�
	@RequestMapping("/lookSubjects")
	public ModelAndView lookSubjects() {
		List<Subject> list=adminservice.getSubject();
		ModelAndView mv=new ModelAndView("admin/lookSubjects");
		mv.addObject("subject", list);
		return mv;
	}
	//����Id��ѯ�γ�(�������鿴�γ�)
	@RequestMapping("/lookSubjectByID")
	public ModelAndView lookSubjectByID(int id) {
		Subject sub=adminservice.getSubjectByID(id);
		ModelAndView mv=new ModelAndView("admin/lookSubjects");
		mv.addObject("sub", sub);
		return mv;
	}
	//�鿴����
	@RequestMapping("/lookTest")
	public ModelAndView lookTest() {
		List<Question> list=adminservice.getQuestion();
		ModelAndView mv=new ModelAndView("admin/lookTest");
		mv.addObject("question", list);
		return mv;
	}
	//�鿴�༶
	@RequestMapping("/lookClassRoom")
	public ModelAndView lookClass() {
		List<Classroom> classroom=adminservice.getClassroom();
		ModelAndView mv=new ModelAndView("admin/lookClassRoom");
		mv.addObject("classroom", classroom);
		return mv;
	}
	//��ɫ�˵�
	@RequestMapping("/RoleMeun")
	public ModelAndView RoleMenu() {
		List<RolePermission> StudentPer=loginservice.getPerByRoleid(2);
		List<RolePermission> TeacherPer=loginservice.getPerByRoleid(1);
		List<RolePermission> AdminPer=loginservice.getPerByRoleid(3);
		ModelAndView mv=new ModelAndView("admin/RoleMenu");
		mv.addObject("StudentPer", StudentPer);
		mv.addObject("TeacherPer", TeacherPer);
		mv.addObject("AdminPer", AdminPer);
		return mv;
	}
	//�༶�γ�
	@RequestMapping("/SubClass")
	public ModelAndView SubClass() {
		List<SubClass> list=adminservice.getSubClass();
		ModelAndView mv=new ModelAndView("admin/SubClass");
		mv.addObject("list", list);
		return mv;
	}
	//�鿴��ʦ�÷�ͳ��
	@RequestMapping("/echart")
	public ModelAndView echart() {
		List<Answer> list = teacherservice.getallscore();
		ModelAndView mv=new ModelAndView("echart");
		mv.addObject("echart", list);
		return mv;
	}
	//�鿴ѧ���Խ�ʦ������
	@RequestMapping("/stutotea")
	public ModelAndView stutotea() {
		List<Answer> answes=teacherservice.getStuToTea();
		ModelAndView mv=new ModelAndView("admin/lookStuToTea");
		mv.addObject("answers", answes);
		return mv;
	}
	//�鿴��ʦ�Խ�ʦ������
	@RequestMapping("/teatotea")
	public ModelAndView teatotea() {
		List<Answer> answes=teacherservice.getTeaToTea();
		List<Teacher> teachers=adminservice.getTeachers();
		ModelAndView mv=new ModelAndView("admin/lookTeaToTea");
		mv.addObject("answers", answes);
		mv.addObject("teachers", teachers);
		return mv;
	}
	//�鿴��������
	@RequestMapping("/lookAnswerInformation")
	public ModelAndView lookAnswerInformation(int vote_id,int bevote_id) {
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
		ModelAndView mv=new ModelAndView("admin/answerInformation");
		mv.addObject("answer", a);
		mv.addObject("getqu", list1);
		return mv;
	}
	/********************************�鿴��Ϣ��תҳ�����**********************************************************/
	/********************************����ҳ�濪ʼ***************************************************************/
	//����Ժϵ
	@RequestMapping("/addIns")
	public ModelAndView addIns() {	
		ModelAndView mv=new ModelAndView("admin/addIns");
		return mv;
	}
	//���Ӳ˵�
	@RequestMapping("/addMenu")
	public ModelAndView addMenu() {	
		ModelAndView mv=new ModelAndView("admin/addMenu");
		List<Permission> list=adminservice.getperByGrade(1);
		mv.addObject("parent", list);
		return mv;
	}
	//���ӽ�ɫ
	@RequestMapping("/addRoles")
	public ModelAndView addRoles() {	
		ModelAndView mv=new ModelAndView("admin/addRoles");
		return mv;
	}
	//����ѧ��
	@RequestMapping("/addStudent")
	public ModelAndView addStudent() {	
		List<Classroom> classroom=adminservice.getClassroom();
		List<Ins> ins=adminservice.getIns();
		ModelAndView mv=new ModelAndView("admin/addStudent");
		mv.addObject("classroom", classroom);
		mv.addObject("ins",ins);
		return mv;
	}
	//���ӿγ�
	@RequestMapping("/addSubject")
	public ModelAndView addSubject() {	
		ModelAndView mv=new ModelAndView("admin/addSubject");
		return mv;
	}
	//���ӽ�ʦ
	@RequestMapping("/addTeacher")
	public ModelAndView addTeacher() {	
		ModelAndView mv=new ModelAndView("admin/addTeacher");
		List<Ins> ins=adminservice.getIns();
		List<Subject> subject=adminservice.getSubject();
		mv.addObject("ins",ins);
		mv.addObject("sub", subject);
		return mv;
	}
	//��������
	@RequestMapping("/addTest")
	public ModelAndView addTest() {	
		ModelAndView mv=new ModelAndView("admin/addTest");
		return mv;
	}
	//���Ӱ༶
	@RequestMapping("/addClassRoom")
	public ModelAndView addClass() {
		ModelAndView mv=new ModelAndView("admin/addClassRoom");
		return mv;
	}
	//���ӽ�ɫ�˵�
	@RequestMapping("/addRolesMenu")
	public ModelAndView addRolesMenu() {
		List<Roles> role=adminservice.getroles();
		List<Permission> per=loginservice.getper();
		ModelAndView mv=new ModelAndView("admin/addRoleMenu");
		mv.addObject("role", role);
		mv.addObject("per", per);
		return mv;
	}
	//���Ӱ༶�γ�
	@RequestMapping("/addSubClass")
	public ModelAndView addSubClass() {
		List<Classroom> classrooms=adminservice.getClassroom();
		List<Subject> subjects=adminservice.getSubject();
		ModelAndView mv=new ModelAndView("admin/addSubClass");
		mv.addObject("classrooms", classrooms);
		mv.addObject("subjects",subjects);
		return mv;
	}
	/********************************����ҳ�����***************************************************************/
	
	/********************************�޸�ҳ����ת��ʼ************************************************************/
	//�޸Ľ�ʦ
	@RequestMapping("updateTeacher")
	public ModelAndView updateTeacher(int id) {
		ModelAndView mv=new ModelAndView("admin/updateTeacher");
		List<Ins> ins=adminservice.getIns();
		List<Subject> subject=adminservice.getSubject();
		mv.addObject("ins",ins);
		mv.addObject("sub", subject);
		mv.addObject("id",id);
		return mv;
	}
	//�޸�ѧ��
	@RequestMapping("updateStudent")
	public ModelAndView updateStudent(int id) {
		ModelAndView mv=new ModelAndView("admin/updateStudent");
		Student stu=studentservice.getStudentByid(id);
		List<Ins> ins=adminservice.getIns();
		List<Classroom> classroom=adminservice.getClassroom();
		mv.addObject("ins",ins);
		mv.addObject("classroom", classroom);
		mv.addObject("student",stu);
		return mv;
	}
	//�޸�����
	@RequestMapping("updateTest")
	public ModelAndView updateTest(int id) {
		Question q=adminservice.getQuestionByID(id);
		ModelAndView mv=new ModelAndView("admin/updateTest");
		mv.addObject("question", q);
		return mv;
	}
	//�޸�Ժϵ
	@RequestMapping("updateIns")
	public ModelAndView updateIns(int id) {
		Ins ins=adminservice.getInsByID(id);
		ModelAndView mv=new ModelAndView("admin/updateIns");
		mv.addObject("ins", ins);
		return mv;
	}
	//�޸Ŀγ�
	@RequestMapping("updateSubject")
	public ModelAndView updateSubject(int id) {
		Subject sub=adminservice.getSubjectByID(id);
		ModelAndView mv=new ModelAndView("admin/updateSubject");
		mv.addObject("sub", sub);
		return mv;
	}
	//�޸Ľ�ɫ
	@RequestMapping("updateRole")
	public ModelAndView updateRoles(int id) {
		Roles role=adminservice.getrolesById(id);
		ModelAndView mv=new ModelAndView("admin/updateRole");
		mv.addObject("role", role);
		return mv;
	}
	//�޸Ĳ˵�
	@RequestMapping("updateMenu")
	public ModelAndView updateMenu(int id) {
		List<Permission> list=adminservice.getperByGrade(1);
		Permission per=adminservice.getPerById(id);
		ModelAndView mv=new ModelAndView("admin/updateMenu");
		mv.addObject("per", per);
		mv.addObject("parent", list);
		return mv;
	}
	//�޸İ༶�γ�
	@RequestMapping("updateSubClass")
	public ModelAndView updateSubClass(int id) {
		SubClass sub=adminservice.getSubClassById(id);
		Classroom classroom=adminservice.getClassroomById(sub.getClassroom().getClass_id());
		List<Subject> list=adminservice.getSubject();
		ModelAndView mv=new ModelAndView("admin/updateSubClass");
		mv.addObject("list", list);
		mv.addObject("classroom", classroom);
		mv.addObject("id", sub.getId());
		return mv;
	}
	/********************************�޸�ҳ����ת����************************************************************/
	
	/********************************������Ϣ�����ݿ⿪ʼ*********************************************************/
	//����ѧ�������ݿ�
	@RequestMapping("addStudentSubmit")
	@ResponseBody
	public ResultMsg addStudentSubmit(int student_id,String student_name,int classroom,int ins) {
		Student stu=new Student();
		stu.setStudent_id(student_id);
		stu.setStudent_name(student_name);
		stu.setStudent_ins(ins);
		stu.setStudent_classid(classroom);
		stu.setRole_id(2);
		stu.setPassword(String.valueOf(student_id));//Ĭ������Ϊѧ��
		int i=adminservice.addStudent(stu);
		ResultMsg rs=null;
		if(i>0) {
			rs=new ResultMsg(1, "���ӳɹ�");
		}else {
			rs=new ResultMsg(2, "����ʧ��");
		}
		return rs;
		
	}
	
	//���ӽ�ʦ�����ݿ�
	@RequestMapping("/addTeacherSubmit")
	@ResponseBody
	public ResultMsg addTeacherSubmit(int teacher_id,String teacher_name,int ins,int teacher_subid) {
		Teacher teacher=new Teacher();
		teacher.setTeacher_insid(ins);
		teacher.setTeacher_id(teacher_id);
		teacher.setTeacher_name(teacher_name);
		teacher.setTeacher_subid(teacher_subid);
		teacher.setRole_id(1);
		teacher.setPassword(String.valueOf(teacher_id));
		int i=adminservice.addTeacher(teacher);
		ResultMsg rs=null;
		if(i>0) {
			rs=new ResultMsg(1, "���ӳɹ�");
		}else {
			rs=new ResultMsg(2, "����ʧ��");
		}
		return rs;
	}
	
	//�������⵽���ݿ�
		@RequestMapping("/AddTestSubmit")
		@ResponseBody
		public ResultMsg AddTestSubmit(String question,String answer_A,String answer_B,String answer_C,String answer_D) {
			Question q=new Question();
			q.setQuestion(question);
			q.setAnswer_A(answer_A);
			q.setAnswer_B(answer_B);
			q.setAnswer_C(answer_C);
			q.setAnswer_D(answer_D);
			int i=adminservice.addQuestion(q);
			ResultMsg rs=null;
			if(i>0) {
				rs=new ResultMsg(1, "���ӳɹ�");
			}else {
				rs=new ResultMsg(2, "����ʧ��");
			}
			return rs;
			
		}
	//����ѧԺ��Ϣ	
	@RequestMapping("/addInsSubmit")
	@ResponseBody
	public ResultMsg addInsSubmit(int ins_id,String ins_name) {
		Ins ins=new Ins();
		ins.setIns_id(ins_id);
		ins.setIns_name(ins_name);
		int i=adminservice.addIns(ins);
		ResultMsg rs=null;
		if(i>0) {
			rs=new ResultMsg(1, "���ӳɹ�");
		}else {
			rs=new ResultMsg(2, "����ʧ��");
		}
		return rs;
	}
	
	//���ӿγ���Ϣ
	@RequestMapping("/addSubjectSubmit")
	@ResponseBody
	public ResultMsg addSubjectSubmit(int sub_id,String sub_name) {
		Subject sub=new Subject();
		sub.setSubject_id(sub_id);
		sub.setSubject_name(sub_name);
		int i=adminservice.addSubject(sub);
		ResultMsg rs=null;
		if(i>0) {
			rs=new ResultMsg(1, "���ӳɹ�");
		}else {
			rs=new ResultMsg(2, "����ʧ��");
		}
		return rs;
	}
	//���ӽ�ɫ��Ϣ
	@RequestMapping("/addRoleSubmit")
	@ResponseBody
	public ResultMsg addRoleSubmit(int id,String name,String describe) {
		Roles role=new Roles();
		role.setRole_id(id);
		role.setRole_name(name);
		role.setDescribes(describe);
		int i=adminservice.addRole(role);
		ResultMsg rs=null;
		if(i>0) {
			rs=new ResultMsg(1, "���ӳɹ�");
		}else {
			rs=new ResultMsg(2, "����ʧ��");
		}
		return rs;
	}
	
	//���Ӳ˵���Ϣ
	@RequestMapping("/addMenuSubmit")
	@ResponseBody
	public ResultMsg addMenuSubmit(String name,String url,int grade,int parentnum,int sort,String describe) {
		Permission per=new Permission();
		per.setPermission_name(name);
		per.setUrl(url);
		per.setPermission_grade(grade);
		per.setParetn_num(parentnum);
		per.setSort(sort);
		per.setDescribes(describe);
		int i=adminservice.addPer(per);
		ResultMsg rs=null;
		if(i>0) {
			rs=new ResultMsg(1, "���ӳɹ�");
		}else {
			rs=new ResultMsg(2, "����ʧ��");
		}
		return rs;
	}
	
	//���Ӱ༶
		@RequestMapping("/addClass")
		@ResponseBody
		public ResultMsg addClass(int classid,String classname) {
			Classroom classroom=new Classroom();
			classroom.setClass_id(classid);
			classroom.setClass_name(classname);
			int i=adminservice.addClass(classroom);
			ResultMsg rs=null;
			if(i>0) {
				rs=new ResultMsg(1, "���ӳɹ�");
			}else {
				rs=new ResultMsg(0, "����ʧ��");
			}
			return rs;
		}
	//���ӽ�ɫ�˵�
		@RequestMapping("/addRoleMenuSubmit")
		@ResponseBody
		public ResultMsg addRoleMenuSubmit(Integer roleid,Integer perid) {
			RolePermission rp=new RolePermission();
			rp.setPer_id(perid);
			rp.setRole_id(roleid);
			int i=adminservice.addRolePer(rp);
			ResultMsg rs=null;
			if(i>0) {
				rs=new ResultMsg(1, "���ӳɹ�");
			}else {
				rs=new ResultMsg(0, "����ʧ��");
			}
			return rs;
		}
	//���Ӱ༶�γ�
		@RequestMapping("/addSubClassSubmit")
		@ResponseBody
		public ResultMsg addSubClassSubmit(Integer classid,Integer subid) {
			SubClass subclass=new SubClass();
			subclass.setClass_id(classid);
			subclass.setSub_id(subid);
			int i=adminservice.addSubClass(subclass);
			ResultMsg rs=null;
			if(i>0) {
				rs=new ResultMsg(1, "���ӳɹ�");
			}else {
				rs=new ResultMsg(0, "����ʧ��");
			}
			return rs;
		}
	/********************************������Ϣ�����ݿ����**********************************************************/
	/********************************ɾ����Ϣ��ʼ***************************************************************/
	
	//ɾ����ʦ
	@RequestMapping("delTeacher")
	@ResponseBody
	public ResultMsg delTeacher(int id) {
		ResultMsg rs=null;
		int i=adminservice.delTeacher(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ��ѧ��
	@RequestMapping("delStudent")
	@ResponseBody
	public ResultMsg delStudent(int id) {
		ResultMsg rs=null;
		int i=adminservice.delStudent(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ���γ�
	@RequestMapping("delSubject")
	@ResponseBody
	public ResultMsg delSubject(int id) {
		ResultMsg rs=null;
		int i=adminservice.delSubjectByid(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ������
	@RequestMapping("delQuestion")
	@ResponseBody
	public ResultMsg delQuestion(int id) {
		ResultMsg rs=null;
		int i=adminservice.delQuestion(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ��Ժϵ
	@RequestMapping("delIns")
	@ResponseBody
	public ResultMsg delIns(int id) {
		ResultMsg rs=null;
		int i=adminservice.delIns(id); 
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ����ɫ
	@RequestMapping("delRole")
	@ResponseBody
	public ResultMsg delRole(int id) {
		ResultMsg rs=null;
		int i=adminservice.delRole(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ���˵�
	@RequestMapping("delMenu")
	@ResponseBody
	public ResultMsg delMenu(int id) {
		ResultMsg rs=null;
		int i=adminservice.delper(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ���༶
	@RequestMapping("delClass")
	@ResponseBody
	public ResultMsg delClass(int id) {
		ResultMsg rs=null;
		int i=adminservice.delClass(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ����ɫ�˵�
	@RequestMapping("/delRoleMenu")
	@ResponseBody
	public ResultMsg delRoleMenu(int id) {
		ResultMsg rs=null;
		int i=adminservice.delRolePer(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//ɾ���༶�γ̹���
	@RequestMapping("delSubClass")
	@ResponseBody
	public ResultMsg delSubClass(int id) {
		ResultMsg rs=null;
		int i=adminservice.delSubClass(id);
		if(i>0) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	/********************************ɾ����Ϣ����***************************************************************/
		
	/********************************�޸���Ϣ��ʼ***************************************************************/
	//���ý�ʦ����
	@RequestMapping("/changePass")
	@ResponseBody
	public ResultMsg changePass(int id) {
		Teacher t=new Teacher();
		t.setTeacher_id(id);
		t.setPassword(String.valueOf(id));
		ResultMsg rs=null;
		int i=adminservice.updateTeacherPass(t);
		if(i>0) {
			rs=new ResultMsg(1, "���óɹ�");
		}else {
			rs=new ResultMsg(1, "����ʧ��");
		}
		return rs;
	}
	//����ѧ������
	@RequestMapping("changeStuPass")
	@ResponseBody
	public ResultMsg changeStuPass(int id) {
		Student stu=new Student();
		stu.setStudent_id(id);
		stu.setPassword(String.valueOf(id));
		ResultMsg rs=null;
		int i=adminservice.updateStuPass(stu);
		if(i>0) {
			rs=new ResultMsg(1, "���óɹ�");
		}else {
			rs=new ResultMsg(1, "����ʧ��");
		}
		return rs;
	}
	//�޸Ľ�ʦ����ѧԺ/���̿�Ŀ��Ϣ
	@RequestMapping("/changeTeacherInfo")
	@ResponseBody
	public ResultMsg changeTeacherInfo(int id,int ins,int teacher_subid) {
		Teacher t=new Teacher();
		t.setTeacher_id(id);
		t.setTeacher_insid(ins);
		t.setTeacher_subid(teacher_subid);
		ResultMsg rs=null;
		int i=adminservice.updateTeacher(t);
		if(i>0) {
			rs=new ResultMsg(1, "�޸ĳɹ�");
		}else {
			rs=new ResultMsg(2, "�޸�ʧ��");
		}
		return rs;
	}
	
	//�޸�ѧ����Ϣ
	@RequestMapping("/ChangeStudent")
	@ResponseBody
	public ResultMsg changerStudent(int id,int ins,int classroom,String student_name) {
		ResultMsg rs=null;
		Student stu=new Student();
		stu.setStudent_id(id);
		stu.setStudent_ins(ins);
		stu.setStudent_classid(classroom);
		stu.setStudent_name(student_name);
		int i=studentservice.changeStudent(stu);
		if(i>0) {
			rs=new ResultMsg(1, "�޸ĳɹ�");
		}else {
			rs=new ResultMsg(2, "�޸�ʧ��");
		}
		return rs;
	}
	
	//�޸�������Ϣ
	@RequestMapping("/ChangeTest")
	@ResponseBody
	public ResultMsg ChangeTest(int id,String question,String answer_A,String answer_B,String answer_C,String answer_D) {
		Question q=new Question();
		q.setQuestion_id(id);
		q.setQuestion(question);
		q.setAnswer_A(answer_A);
		q.setAnswer_B(answer_B);
		q.setAnswer_C(answer_C);
		q.setAnswer_D(answer_D);
		int i=adminservice.updateQuestion(q);
		ResultMsg rs=null;
		if(i>0) {
			rs=new ResultMsg(1, "�޸ĳɹ�");
		}else {
			rs=new ResultMsg(2, "�޸�ʧ��");
		}
		return rs;
	}
	//�޸�ѧԺ��
	@RequestMapping("/changeIns")
	@ResponseBody
	public ResultMsg ChangeIns(int id,String ins_name) {
		Ins ins=new Ins();
		ins.setIns_id(id);
		ins.setIns_name(ins_name);
		ResultMsg rs=null;
		int i=adminservice.updateIns(ins);
		if(i>0) {
			rs=new ResultMsg(1, "�޸ĳɹ�");
		}else {
			rs=new ResultMsg(2, "�޸�ʧ��");
		}
		return rs;
	}
	//�޸Ŀγ���
	@RequestMapping("/changeSub")
	@ResponseBody
	public ResultMsg ChangeSub(int id,String sub_name) {
		Subject sub=new Subject();
		sub.setSubject_id(id);
		sub.setSubject_name(sub_name);
		ResultMsg rs=null;
		int i=adminservice.updateSubject(sub);
		if(i>0) {
			rs=new ResultMsg(1, "�޸ĳɹ�");
		}else {
			rs=new ResultMsg(2, "�޸�ʧ��");
		}
		return rs;
	}
	
	//�޸Ľ�ɫ��
		@RequestMapping("/changeRole")
		@ResponseBody
		public ResultMsg changeRole(int id,String name,String describe) {
			Roles role=new Roles();
			role.setRole_id(id);
			role.setRole_name(name);
			role.setDescribes(describe);
			ResultMsg rs=null;
			int i=adminservice.updateRole(role);
			if(i>0) {
				rs=new ResultMsg(1, "�޸ĳɹ�");
			}else {
				rs=new ResultMsg(2, "�޸�ʧ��");
			}
			return rs;
		}
	//�޸Ĳ˵���Ϣ
		@RequestMapping("/changeMenu")
		@ResponseBody
		public ResultMsg changeMenu(int id,String name,String url,int grade,int parentnum,int sort,String describe) {
			Permission per=new Permission();
			per.setPermission_id(id);
			per.setPermission_name(name);
			per.setUrl(url);
			per.setPermission_grade(grade);
			per.setParetn_num(parentnum);
			per.setSort(sort);
			per.setDescribes(describe);
			int i=adminservice.updatePer(per);
			System.out.println(i);
			ResultMsg rs=null;
			if(i>0) {
				rs=new ResultMsg(1, "�޸ĳɹ�");
			}else {
				rs=new ResultMsg(2, "�޸�ʧ��");
			}
			return rs;
		}
	//�޸İ༶�γ�
		@RequestMapping("/changeSubClass")
		@ResponseBody
		public ResultMsg changeSubClass(int id,int subid) {
			SubClass subclass=new SubClass();
			subclass.setId(id);
			subclass.setSub_id(subid);
			int i=adminservice.updateSubClass(subclass);
			ResultMsg rs=null;
			if(i>0) {
				rs=new ResultMsg(1, "�޸ĳɹ�");
			}else {
				rs=new ResultMsg(2, "�޸�ʧ��");
			}
			return rs;
		}
	/********************************�޸���Ϣ����***************************************************************/
	/**********************************�������빦��***********************************************************/
	
	/**
	 * ���������ʦ	
	 * @param file
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/addMoreTeacher")
	@ResponseBody
	public ResultMsg addMoreTeacher(MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		boolean isadd=false;
		List<Teacher> teachers=null;
		try {
			teachers=ExcelUntil.readTeacherExcel(file.getInputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int s=0;s<teachers.size();s++) {	
			Teacher t=teachers.get(s);
			int i=adminservice.addTeacher(t);
			if(i>0) {
				isadd=true;
				System.out.println("��"+s+"�����ݲ���ɹ�");
			}else {
				isadd=false;
				System.out.println("��"+s+"�����ݲ���ʧ��");
			}
		}
		ResultMsg rs=null;
		if(isadd) {
			rs=new ResultMsg(1, "���ӳɹ�");
		}else {
			rs=new ResultMsg(2, "����ʧ��");
		}
		return rs;
	}
	
	/**
	 * ��������ѧ��
	 * @param file
	 * @param request
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/addMoreStudent")
	@ResponseBody
	public ResultMsg addMoreStudent(MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		boolean isadd=false;
		List<Student> students=null;
		try {
			students=ExcelUntil.readStudentExcel(file.getInputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int m=0;m<students.size();m++) {	
			Student s=students.get(m);
			int i=adminservice.addStudent(s);
			if(i>0) {
				isadd=true;
				System.out.println("��"+m+"�����ݲ���ɹ�");
			}else {
				isadd=false;
				System.out.println("��"+m+"�����ݲ���ʧ��");
			}
		}
		ResultMsg rs=null;
		if(isadd) {
			rs=new ResultMsg(1, "���ӳɹ�");
		}else {
			rs=new ResultMsg(2, "����ʧ��");
		}
		return rs;
	}
	
	/***********************************����ɾ��*********************************************************/
	//����ɾ����ʦ
	@RequestMapping("/delMoreTeacher")
	@ResponseBody
	public ResultMsg delmoreTeacher(int[] ids) {
		boolean isdel=false;
		for(int id:ids) {
			int i=adminservice.delTeacher(id);
			if(i>0) {
				isdel=true;
			}else {
				isdel=false;
			}
		}
		ResultMsg rs=null;
		if(isdel) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//����ɾ��ѧ��
	@RequestMapping("/delMoreStudent")
	@ResponseBody
	public ResultMsg delMoreStudent(int[] ids) {
		boolean isdel=false;
		for(int id:ids) {
			int i=adminservice.delStudent(id);
			if(i>0) {
				isdel=true;
			}else {
				isdel=false;
			}
		}
		ResultMsg rs=null;
		if(isdel) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//����ɾ���γ�
	@RequestMapping("/delMoreSubject")
	@ResponseBody
	public ResultMsg delMoreSubject(int[] ids) {
		boolean isdel=false;
		for(int id:ids) {
			int i=adminservice.delSubjectByid(id);
			if(i>0) {
				isdel=true;
			}else {
				isdel=false;
			}
		}
		ResultMsg rs=null;
		if(isdel) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//����ɾ��Ժϵ
	@RequestMapping("/delMoreIns")
	@ResponseBody
	public ResultMsg delMoreIns(int[] ids) {
		boolean isdel=false;
		for(int id:ids) {
			int i=adminservice.delIns(id);
			if(i>0) {
				isdel=true;
			}else {
				isdel=false;
			}
		}
		ResultMsg rs=null;
		if(isdel) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//����ɾ����ɫ�˵�
	@RequestMapping("/delMoreRolemenu")
	@ResponseBody
	public ResultMsg delMoreRolemenu(int[] ids) {
		boolean isdel=false;
		for(int id:ids) {
			int i=adminservice.delRolePer(id);
			if(i>0) {
				isdel=true;
			}else {
				isdel=false;
			}
		}
		ResultMsg rs=null;
		if(isdel) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//����ɾ���˵�
	@RequestMapping("/delMoreMenu")
	@ResponseBody
	public ResultMsg delMoreMenu(int[] ids) {
		boolean isdel=false;
		for(int id:ids) {
			int i=adminservice.delper(id);
			if(i>0) {
				isdel=true;
			}else {
				isdel=false;
			}
		}
		ResultMsg rs=null;
		if(isdel) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//����ɾ���༶
	@RequestMapping("/delMoreClass")
	@ResponseBody
	public ResultMsg delMoreClass(int[] ids) {
		boolean isdel=false;
		for(int id:ids) {
			int i=adminservice.delClass(id);
			if(i>0) {
				isdel=true;
			}else {
				isdel=false;
			}
		}
		ResultMsg rs=null;
		if(isdel) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
	//����ɾ���༶�γ�
	@RequestMapping("/delMoreSubClass")
	@ResponseBody
	public ResultMsg delMoreSubClass(int[] ids) {
		boolean isdel=false;
		for(int id:ids) {
			int i=adminservice.delSubClass(id);
			if(i>0) {
				isdel=true;
			}else {
				isdel=false;
			}
		}
		ResultMsg rs=null;
		if(isdel) {
			rs=new ResultMsg(1, "ɾ���ɹ�");
		}else {
			rs=new ResultMsg(2, "ɾ��ʧ��");
		}
		return rs;
	}
}