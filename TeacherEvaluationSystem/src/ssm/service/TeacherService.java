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
	 * ��ѯ��ʦ����
	 * @param teacher_id
	 * @return
	 */
	public int FindTeacher(int teacher_id) {
		return teacherdao.FindTeacher(teacher_id);
	}
	/**
	 * ��ѯ��ʦ������Ϣ
	 * @param teacher_id
	 * @return
	 */
	public Teacher FindTeacherMSG(int teacher_id) {
		return teacherdao.FindTeacherMSG(teacher_id);
	}
	
	/**
	 * �޸Ľ�ʦ����
	 * @param password
	 * @param teacher_id
	 * @return
	 */
	public int changepass(Teacher teacher) {
		return teacherdao.changepass(teacher);
	}
	
	
	/**
	 * ���ݽ�ʦID��ѯ��ʦ������Ϣ
	 * ��������Ժϵ  ���̿�Ŀ
	 * @return
	 */
	public List<Teacher> getteacherallmsg(int teacher_id){
		return teacherdao.getteacherallmsg(teacher_id);
	}
	
	
	/**
	 * ��ʦͬ�����۽�����������������ݿ�
	 * @param answer
	 * @return
	 */
	public int addVoteScore(Answer answer) {
		return teacherdao.addVoteScore(answer);
	}
	
	/**
	 * ��ȡͬ�ж��Լ�������
	 * @param teacher_id
	 * @return
	 */
	public List<Answer> getscore(int bevote_id) {
		return teacherdao.getscore(bevote_id);
	}
	
	/**
	 * ��ȡ��������
	 * @param question
	 * @return
	 */
	public List<Question> getQuestion(){
		return teacherdao.getQuestion();
	}
	
	/**
	 * �������н�ʦ
	 * @return
	 */
	public List<Teacher> teacherList(String ins_name){
		return teacherdao.teacherList(ins_name);
	}
	
	/**
	 * ����ѧԺ��γ̻�ȡ��ʦ
	 * @param t
	 * @return
	 */
	public Teacher getTeacherBysubclass(Teacher t) {
		return teacherdao.getTeacherBysubclass(t);
	}
	
	/**
	 * ��ȡ������Ϣ����ϸ��Ϣ
	 * @param answer
	 * @return
	 */
	public Answer getadventure(Answer answer) {
		return teacherdao.getadventure(answer);
	}
	
	
	/**
	 * ��ȡ��ǰ��¼��ɫ�Ƿ�����
	 * @param vote_id
	 * @return
	 */
	public List<Answer> getIsvote(int vote_id) {
		return teacherdao.getIsvote(vote_id);
	};
	
	
	/**
	 * ��ȡ���н�ʦͶƱ��Ϣ����������ͳ��
	 * @return
	 */
	public List<Answer> getallscore(){
		return teacherdao.getallscore();
	}
	
	/**
	 * ��ȡѧ���Խ�ʦ������
	 * @return
	 */
	public List<Answer> getStuToTea(){
		return teacherdao.getStuToTea();
	}
	/**
	 * ��ȡ��ʦ�Խ�ʦ������
	 * @return
	 */
	public List<Answer> getTeaToTea(){
		return teacherdao.getTeaToTea();
	}
}