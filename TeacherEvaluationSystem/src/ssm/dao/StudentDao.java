package ssm.dao;

import java.util.List;

import ssm.entity.Answer;
import ssm.entity.Student;
import ssm.entity.Subject;

public interface StudentDao {
	Student getStudent(Student student);//ȡ��ѧ��
	
	int changePass(Student student);//�޸�����
	
	Student getStudentByid(int id);//����ѧ�Ų�ѯѧ��
	
	int addAnswer(Answer answer);//��������
	
	List<Subject> getSubjects(int classid);//���ݰ༶��ȡ�γ�
	
	List<Answer> getAnswerByVoteId(int id);//�鿴ѧ�����������
	
	int changeStudent(Student s);//�޸���Ϣ
}