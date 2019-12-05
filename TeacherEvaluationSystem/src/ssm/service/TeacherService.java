package ssm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.TeacherDao;
import ssm.entity.Answer;
import ssm.entity.Question;
import ssm.entity.Teacher;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao teacherdao;
	/**
	 * 查询教师工号
	 * @param teacher_id
	 * @return
	 */
	public int FindTeacher(int teacher_id) {
		return teacherdao.FindTeacher(teacher_id);
	}
	/**
	 * 查询教师所有信息
	 * @param teacher_id
	 * @return
	 */
	public Teacher FindTeacherMSG(int teacher_id) {
		return teacherdao.FindTeacherMSG(teacher_id);
	}
	
	/**
	 * 修改教师密码
	 * @param password
	 * @param teacher_id
	 * @return
	 */
	public int changepass(Teacher teacher) {
		return teacherdao.changepass(teacher);
	}
	
	
	/**
	 * 根据教师ID查询教师所有信息
	 * 包括所在院系  所教科目
	 * @return
	 */
	public List<Teacher> getteacherallmsg(int teacher_id){
		return teacherdao.getteacherallmsg(teacher_id);
	}
	
	
	/**
	 * 教师同行评价将结果及分数存入数据库
	 * @param answer
	 * @return
	 */
	public int addVoteScore(Answer answer) {
		return teacherdao.addVoteScore(answer);
	}
	
	/**
	 * 获取同行对自己的评价
	 * @param teacher_id
	 * @return
	 */
	public List<Answer> getscore(int bevote_id) {
		return teacherdao.getscore(bevote_id);
	}
	
	/**
	 * 获取所有问题
	 * @param question
	 * @return
	 */
	public List<Question> getQuestion(){
		return teacherdao.getQuestion();
	}
	
	/**
	 * 遍历所有教师
	 * @return
	 */
	public List<Teacher> teacherList(String ins_name){
		return teacherdao.teacherList(ins_name);
	}
	
	/**
	 * 根据学院与课程获取教师
	 * @param t
	 * @return
	 */
	public Teacher getTeacherBysubclass(Teacher t) {
		return teacherdao.getTeacherBysubclass(t);
	}
	
	/**
	 * 获取评教信息的详细信息
	 * @param answer
	 * @return
	 */
	public Answer getadventure(Answer answer) {
		return teacherdao.getadventure(answer);
	}
	
	
	/**
	 * 获取当前登录角色是否评教
	 * @param vote_id
	 * @return
	 */
	public List<Answer> getIsvote(int vote_id) {
		return teacherdao.getIsvote(vote_id);
	};
	
	
	/**
	 * 获取所有教师投票信息，进行数据统计
	 * @return
	 */
	public List<Answer> getallscore(){
		return teacherdao.getallscore();
	}
	
	/**
	 * 获取学生对教师的评价
	 * @return
	 */
	public List<Answer> getStuToTea(){
		return teacherdao.getStuToTea();
	}
	/**
	 * 获取教师对教师的评价
	 * @return
	 */
	public List<Answer> getTeaToTea(){
		return teacherdao.getTeaToTea();
	}
}
