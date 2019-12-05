package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.StudentDao;
import ssm.entity.Answer;
import ssm.entity.Student;
import ssm.entity.Subject;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentdao;
	
	/**
	 * 登录
	 * @param student
	 * @return boolean
	 */
	public boolean login(Student student) {
		Student stu= studentdao.getStudent(student);
		if(stu!=null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 修改密码
	 * @param student
	 * @return int
	 */
	public int changePass(Student student) {
		return studentdao.changePass(student);
	}
	
	/**
	 * 根据学号查询学生
	 * @param id
	 * @return student
	 */
	public Student getStudentByid(int id) {
		return studentdao.getStudentByid(id);
	}
	
	/**
	 * 添加评价
	 * @param answer
	 * @return int
	 */
	public int addAnswer(Answer answer) {
		return studentdao.addAnswer(answer);
	}
	
	/**
	 * 获取班级的所有课程
	 * @param classid
	 * @return
	 */
	public List<Subject> getSubjects(int classid){
		return studentdao.getSubjects(classid);
	}
	
	/**
	 * 获取学生所有的投票信息
	 * @param id
	 * @return List<Answer>
	 */
	public List<Answer> getAnswerByVoteId(int id){
		return studentdao.getAnswerByVoteId(id);
	}
	
	/**
	 * 修改学生信息
	 * @param stu
	 * @return
	 */
	public int changeStudent(Student stu) {
		return studentdao.changeStudent(stu);
	}
}
