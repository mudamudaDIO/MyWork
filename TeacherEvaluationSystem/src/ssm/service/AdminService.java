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
	 * ���Ӱ༶
	 * @param classroom
	 * @return int
	 */
	public int addClass(Classroom classroom) {
		return admindao.addClass(classroom);
	}
	/**
	 * ɾ���༶
	 * @param id
	 * @return int
	 */
	public int delClass(int id) {
		return admindao.delClassByid(id);
	}
	/**
	 * ��ѯ�༶
	 * @return list
	 */
	public List<Classroom> getClassroom(){
		return admindao.getClassroom();
	}
	/**
	 * ����Id��ѯ�༶
	 */
	public Classroom getClassroomById(int id) {
		return admindao.getClassroomById(id);
	}
	
	/**
	 * ���ӿγ�
	 * @param subject
	 * @return int
	 */
	public int addSubject(Subject subject) {
		return admindao.addSubject(subject);
	}
	/**
	 * ɾ���γ�
	 * @param id
	 * @return int
	 */
	public int delSubjectByid(int id) {
		return admindao.delSubjectByid(id);
	}
	/**
	 * �޸Ŀγ�
	 * @param subject
	 * @return int
	 */
	public int updateSubject(Subject subject) {
		return admindao.updateSubject(subject);
	}
	/**
	 * ��ѯ���пγ�
	 * @return list
	 */
	public List<Subject> getSubject(){
		return admindao.getSubject();
	}
	/**
	 * ����Id��ѯ�γ�
	 * @return subject
	 */
	public Subject getSubjectByID(int id){
		return admindao.getSubjectById(id);
	}
	
	/**
	 * ����Ժϵ
	 * @param ins
	 * @return Int
	 */
	public int addIns(Ins ins) {
		return admindao.addIns(ins);
	}
	/**
	 * ɾ��Ժϵ
	 * @param id
	 * @return int
	 */
	public int delIns(int id) {
		return admindao.delInsByid(id);
	}
	/**
	 * �޸�Ժϵ��
	 * @param ins
	 * @return
	 */
	public int updateIns(Ins ins) {
		return admindao.updateIns(ins);
	}
	/**
	 * ��ѯ����Ժϵ
	 * @return list
	 */
	public List<Ins> getIns(){
		return admindao.getIns();
	}
	/**
	 * ����ID��ѯԺϵ
	 * @return list
	 */
	public Ins getInsByID(int id){
		return admindao.getInsByID(id);
	}
	
	
	/**
	 * ��������
	 * @param q
	 * @return int
	 */
	public int addQuestion(Question q) {
		return admindao.addQuestion(q);
	}
	/**
	 * ɾ������
	 * @param id
	 * @return int
	 */
	public int delQuestion(int id) {
		return admindao.delQuestionByid(id);
	}
	/**
	 * �޸�����
	 * @param q
	 * @return int
	 */
	public int updateQuestion(Question q) {
		return admindao.updateQuestion(q);
	}
	/**
	 * ��ѯ��������
	 * @return list
	 */
	public List<Question> getQuestion(){
		return admindao.getQUestin();
	}
	/**
	 * ����ID��ѯ����
	 * @return list
	 */
	public Question getQuestionByID(int id){
		return admindao.getQUestinByID(id);
	}
	
	/**
	 * ����ѧ��
	 * @param stu
	 * @return int
	 */
	public int addStudent(Student stu) {
		return admindao.addStudent(stu);
	}
	
	/**
	 * ɾ��ѧ��
	 * @param id
	 * @return int
	 */
	public int delStudent(int id) {
		return admindao.delStudentByid(id);
	}
	
	/**
	 * ����ѧ������
	 * @param stu
	 * @return int
	 */
	public int updateStuPass(Student stu) {
		return admindao.updateStuPassByid(stu);
	}
	
	/**
	 * ��ѯѧ��
	 * @return list
	 */
	public List<Student> getStudents(){
		return admindao.getStudents();
	}
	/**
	 * ����Id��ѯѧ��
	 */
	public Student getStudentByid(int id) {
		return admindao.getStudentById(id);
	}
	
	/**
	 * ���ӽ�ʦ
	 * @param stu
	 * @return int
	 */
	public int addTeacher(Teacher teacher) {
		return admindao.addTeacher(teacher);
	}
	
	/**
	 * ɾ����ʦ
	 * @param id
	 * @return int
	 */
	public int delTeacher(int id) {
		return admindao.delTeacherByid(id);
	}
	
	/**
	 * ���ý�ʦ����
	 * @param stu
	 * @return int
	 */
	public int updateTeacherPass(Teacher teacher) {
		return admindao.updateTeacherPassByid(teacher);
	}
	/**
	 * �޸Ľ�ʦ��Ϣ
	 * @param teacher
	 * @return int
	 */
	public int updateTeacher(Teacher teacher) {
		return admindao.updateTeacher(teacher);
	}
	/**
	 * ����Id��ȡ��ʦ
	 * @param id
	 * @return
	 */
	public Teacher getTeacherById(int id) {
		return admindao.getTeacherById(id);
	}
	/**
	 * ��ѯ��ʦ
	 * @return list
	 */
	public List<Teacher> getTeachers(){
		return admindao.getTeachers();
	}
	
	/**
	 * ���ӽ�ɫ
	 * @param role
	 * @return int
	 */
	public int addRole(Roles role) {
		return admindao.addRole(role);
	}
	
	/**
	 * ɾ����ɫ
	 * @param id
	 * @return int
	 */
	public int delRole(int id) {
		return admindao.delRole(id);
	}
	
	/**
	 * �޸Ľ�ɫ��Ϣ
	 * @param role
	 * @return
	 */
	public int updateRole(Roles role) {
		return admindao.updateRole(role);
	}
	
	/**
	 * ��ȡ���н�ɫ
	 * @return List
	 */
	public List<Roles> getroles(){
		return admindao.getRoles();
	}
	/**
	 * ����ID��ȡ��ɫ
	 * @return Role��
	 */
	public Roles getrolesById(int id){
		return admindao.getRolesById(id);
	}
	
	/**
	 * ���Ӳ˵�
	 * @param per
	 * @return
	 */
	public int addPer(Permission per) {
		return admindao.addPer(per);
	}
	/**
	 * ɾ���˵�
	 * @param id
	 * @return int
	 */
	public int delper(int id) {
		return admindao.delPer(id);
	}
	/**
	 * �޸Ĳ˵�
	 * @param per
	 * @return int
	 */
	public int updatePer(Permission per) {
		return admindao.updatePer(per);
	}
	/**
	 * ����ID���Ҳ˵�
	 * @param id
	 * @return Permission
	 */
	public Permission getPerById(int id) {
		return admindao.getpersById(id);
	}
	/**
	 * ���ݲ˵��ȼ����Ҳ˵�
	 * @param gade
	 * @return list
	 */
	public List<Permission> getperByGrade(int gade){
		return admindao.getpersByGrade(gade);
	}
	
	/**
	 * ���ӽ�ɫ
	 * @param rolePer
	 * @return int
	 */
	public int addRolePer(RolePermission rolePer) {
		return admindao.addRolePer(rolePer);
	}
	/**
	 * ɾ����ɫ
	 * @param id
	 * @return int
	 */
	public int delRolePer(int id) {
		return admindao.delRolePer(id);
	}
	/**
	 * �޸Ľ�ɫ
	 * @param rolePer
	 * @return int
	 */
	public int updateRolePer(RolePermission rolePer) {
		return admindao.updateRolePer(rolePer);
	}
	
	/**
	 * �����༶��γ�
	 * @param subclass
	 * @return
	 */
	public int addSubClass(SubClass subclass) {
		return admindao.addSubClass(subclass);
	}
	/**
	 * ɾ���༶��γ̵Ĺ���
	 * @param id
	 * @return
	 */
	public int delSubClass(int id) {
		return admindao.delSubClass(id);
	}
	/**
	 * �޸İ༶��γ̵Ĺ���
	 * @param subclass
	 * @return
	 */
	public int updateSubClass(SubClass subclass) {
		return admindao.updateSubClass(subclass);
	}
	/**
	 * ��ѯ�༶��γ̵Ĺ���
	 * @return
	 */
	public List<SubClass> getSubClass(){
		return admindao.getSubClass();
	}
	/**
	 * ����Id��ѯһ������
	 * @return
	 */
	public SubClass getSubClassById(int id) {
		return admindao.getSubClassById(id);
	}
	

}