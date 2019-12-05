package ssm.dao;

import java.util.List;
import java.util.Map;

import ssm.entity.Answer;
import ssm.entity.Question;
import ssm.entity.Teacher;

public interface TeacherDao {
	//���ݽ�ʦID��ѯ�ý�ʦ�Ƿ����
	int FindTeacher(int teacher_id);
	
	//���ݽ�ʦID��ѯTeacher���Ļ�����Ϣ
	Teacher FindTeacherMSG(int teacher_id);
	
	//���ݽ�ʦID����ͨ��ʵ�����޸Ľ�ʦ����
	int changepass(Teacher teacher);
	
	//��list����ʵ�ֶ����ѯ����ȡ��ʦ������Ϣ
	List<Teacher> getteacherallmsg(int teacher_id);
	
	//��ʦ���۴����������������
	int addVoteScore(Answer answer);
	
	//�鿴�Լ���ͬ�����۵ķ���
	List<Answer> getscore(int bevote_id);
	
	//��ȡ��������
	List<Question> getQuestion();
	
	//�������н�ʦ��Ϣ
	List<Teacher> teacherList(String ins_name);
	
	//����ѧԺ��γ̲��ҽ�ʦ
	Teacher getTeacherBysubclass(Teacher t);
	
	//��ȡ��ʦ���̵���ϸ��Ϣ
	Answer getadventure(Answer answer);
	
	//��ȡ��ǰ��¼��ɫ�Ƿ�����
	List<Answer> getIsvote(int vote_id);
	
	//�Խ�ʦ���ݽ���ͳ��
	List<Answer> getallscore();
	
	
	/*����answe�� by:lin*/
	List<Answer> getStuToTea();//��ȡѧ���Խ�ʦ������
	List<Answer> getTeaToTea();//��ȡ��ʦ�Խ�ʦ������
}