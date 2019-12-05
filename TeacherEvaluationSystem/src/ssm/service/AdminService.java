package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.AdminDao;
import ssm.entity.Answer;
import ssm.entity.Classroom;
import ssm.entity.Ins;
import ssm.entity.Permission;
import ssm.entity.Question;
import ssm.entity.RolePermission;
import ssm.entity.Roles;
import ssm.entity.Student;
import ssm.entity.SubClass;
import ssm.entity.Subject;
import ssm.entity.Teacher;

@Service
public class AdminService {
	@Autowired
	private AdminDao admindao;
	
	/**
	 * 添加班级
	 * @param classroom
	 * @return int
	 */
	public int addClass(Classroom classroom) {
		return admindao.addClass(classroom);
	}
	/**
	 * 删除班级
	 * @param id
	 * @return int
	 */
	public int delClass(int id) {
		return admindao.delClassByid(id);
	}
	/**
	 * 查询班级
	 * @return list
	 */
	public List<Classroom> getClassroom(){
		return admindao.getClassroom();
	}
	/**
	 * 根据Id查询班级
	 */
	public Classroom getClassroomById(int id) {
		return admindao.getClassroomById(id);
	}
	
	/**
	 * 添加课程
	 * @param subject
	 * @return int
	 */
	public int addSubject(Subject subject) {
		return admindao.addSubject(subject);
	}
	/**
	 * 删除课程
	 * @param id
	 * @return int
	 */
	public int delSubjectByid(int id) {
		return admindao.delSubjectByid(id);
	}
	/**
	 * 修改课程
	 * @param subject
	 * @return int
	 */
	public int updateSubject(Subject subject) {
		return admindao.updateSubject(subject);
	}
	/**
	 * 查询所有课程
	 * @return list
	 */
	public List<Subject> getSubject(){
		return admindao.getSubject();
	}
	/**
	 * 根据Id查询课程
	 * @return subject
	 */
	public Subject getSubjectByID(int id){
		return admindao.getSubjectById(id);
	}
	
	/**
	 * 添加院系
	 * @param ins
	 * @return Int
	 */
	public int addIns(Ins ins) {
		return admindao.addIns(ins);
	}
	/**
	 * 删除院系
	 * @param id
	 * @return int
	 */
	public int delIns(int id) {
		return admindao.delInsByid(id);
	}
	/**
	 * 修改院系名
	 * @param ins
	 * @return
	 */
	public int updateIns(Ins ins) {
		return admindao.updateIns(ins);
	}
	/**
	 * 查询所有院系
	 * @return list
	 */
	public List<Ins> getIns(){
		return admindao.getIns();
	}
	/**
	 * 根据ID查询院系
	 * @return list
	 */
	public Ins getInsByID(int id){
		return admindao.getInsByID(id);
	}
	
	
	/**
	 * 添加问题
	 * @param q
	 * @return int
	 */
	public int addQuestion(Question q) {
		return admindao.addQuestion(q);
	}
	/**
	 * 删除问题
	 * @param id
	 * @return int
	 */
	public int delQuestion(int id) {
		return admindao.delQuestionByid(id);
	}
	/**
	 * 修改问题
	 * @param q
	 * @return int
	 */
	public int updateQuestion(Question q) {
		return admindao.updateQuestion(q);
	}
	/**
	 * 查询所有问题
	 * @return list
	 */
	public List<Question> getQuestion(){
		return admindao.getQUestin();
	}
	/**
	 * 根据ID查询问题
	 * @return list
	 */
	public Question getQuestionByID(int id){
		return admindao.getQUestinByID(id);
	}
	
	/**
	 * 添加学生
	 * @param stu
	 * @return int
	 */
	public int addStudent(Student stu) {
		return admindao.addStudent(stu);
	}
	
	/**
	 * 删除学生
	 * @param id
	 * @return int
	 */
	public int delStudent(int id) {
		return admindao.delStudentByid(id);
	}
	
	/**
	 * 重置学生密码
	 * @param stu
	 * @return int
	 */
	public int updateStuPass(Student stu) {
		return admindao.updateStuPassByid(stu);
	}
	
	/**
	 * 查询学生
	 * @return list
	 */
	public List<Student> getStudents(){
		return admindao.getStudents();
	}
	/**
	 * 根据Id查询学生
	 */
	public Student getStudentByid(int id) {
		return admindao.getStudentById(id);
	}
	
	/**
	 * 添加教师
	 * @param stu
	 * @return int
	 */
	public int addTeacher(Teacher teacher) {
		return admindao.addTeacher(teacher);
	}
	
	/**
	 * 删除教师
	 * @param id
	 * @return int
	 */
	public int delTeacher(int id) {
		return admindao.delTeacherByid(id);
	}
	
	/**
	 * 重置教师密码
	 * @param stu
	 * @return int
	 */
	public int updateTeacherPass(Teacher teacher) {
		return admindao.updateTeacherPassByid(teacher);
	}
	/**
	 * 修改教师信息
	 * @param teacher
	 * @return int
	 */
	public int updateTeacher(Teacher teacher) {
		return admindao.updateTeacher(teacher);
	}
	/**
	 * 根据Id获取教师
	 * @param id
	 * @return
	 */
	public Teacher getTeacherById(int id) {
		return admindao.getTeacherById(id);
	}
	/**
	 * 查询教师
	 * @return list
	 */
	public List<Teacher> getTeachers(){
		return admindao.getTeachers();
	}
	
	/**
	 * 添加角色
	 * @param role
	 * @return int
	 */
	public int addRole(Roles role) {
		return admindao.addRole(role);
	}
	
	/**
	 * 删除角色
	 * @param id
	 * @return int
	 */
	public int delRole(int id) {
		return admindao.delRole(id);
	}
	
	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 */
	public int updateRole(Roles role) {
		return admindao.updateRole(role);
	}
	
	/**
	 * 获取所有角色
	 * @return List
	 */
	public List<Roles> getroles(){
		return admindao.getRoles();
	}
	/**
	 * 根据ID获取角色
	 * @return Role是
	 */
	public Roles getrolesById(int id){
		return admindao.getRolesById(id);
	}
	
	/**
	 * 添加菜单
	 * @param per
	 * @return
	 */
	public int addPer(Permission per) {
		return admindao.addPer(per);
	}
	/**
	 * 删除菜单
	 * @param id
	 * @return int
	 */
	public int delper(int id) {
		return admindao.delPer(id);
	}
	/**
	 * 修改菜单
	 * @param per
	 * @return int
	 */
	public int updatePer(Permission per) {
		return admindao.updatePer(per);
	}
	/**
	 * 根据ID查找菜单
	 * @param id
	 * @return Permission
	 */
	public Permission getPerById(int id) {
		return admindao.getpersById(id);
	}
	/**
	 * 根据菜单等级查找菜单
	 * @param gade
	 * @return list
	 */
	public List<Permission> getperByGrade(int gade){
		return admindao.getpersByGrade(gade);
	}
	
	/**
	 * 添加角色
	 * @param rolePer
	 * @return int
	 */
	public int addRolePer(RolePermission rolePer) {
		return admindao.addRolePer(rolePer);
	}
	/**
	 * 删除角色
	 * @param id
	 * @return int
	 */
	public int delRolePer(int id) {
		return admindao.delRolePer(id);
	}
	/**
	 * 修改角色
	 * @param rolePer
	 * @return int
	 */
	public int updateRolePer(RolePermission rolePer) {
		return admindao.updateRolePer(rolePer);
	}
	
	/**
	 * 关联班级与课程
	 * @param subclass
	 * @return
	 */
	public int addSubClass(SubClass subclass) {
		return admindao.addSubClass(subclass);
	}
	/**
	 * 删除班级与课程的关联
	 * @param id
	 * @return
	 */
	public int delSubClass(int id) {
		return admindao.delSubClass(id);
	}
	/**
	 * 修改班级与课程的关联
	 * @param subclass
	 * @return
	 */
	public int updateSubClass(SubClass subclass) {
		return admindao.updateSubClass(subclass);
	}
	/**
	 * 查询班级与课程的关联
	 * @return
	 */
	public List<SubClass> getSubClass(){
		return admindao.getSubClass();
	}
	/**
	 * 根据Id查询一条数据
	 * @return
	 */
	public SubClass getSubClassById(int id) {
		return admindao.getSubClassById(id);
	}
	

}
