package ssm.dao;

import java.util.List;
import java.util.Map;

import ssm.entity.Answer;
import ssm.entity.Question;
import ssm.entity.Teacher;

public interface TeacherDao {
	//根据教师ID查询该教师是否存在
	int FindTeacher(int teacher_id);
	
	//根据教师ID查询Teacher表的基本信息
	Teacher FindTeacherMSG(int teacher_id);
	
	//根据教师ID，再通过实体类修改教师密码
	int changepass(Teacher teacher);
	
	//用list集合实现多表查询，获取教师所有信息
	List<Teacher> getteacherallmsg(int teacher_id);
	
	//教师评价存入评价问题与分数
	int addVoteScore(Answer answer);
	
	//查看自己被同行评价的分数
	List<Answer> getscore(int bevote_id);
	
	//获取所有问题
	List<Question> getQuestion();
	
	//遍历所有教师信息
	List<Teacher> teacherList(String ins_name);
	
	//根据学院与课程查找教师
	Teacher getTeacherBysubclass(Teacher t);
	
	//获取教师评教的详细信息
	Answer getadventure(Answer answer);
	
	//获取当前登录角色是否评教
	List<Answer> getIsvote(int vote_id);
	
	//对教师数据进行统计
	List<Answer> getallscore();
	
	
	/*操作answe表 by:lin*/
	List<Answer> getStuToTea();//获取学生对教师的评价
	List<Answer> getTeaToTea();//获取教师对教师的评价
}
