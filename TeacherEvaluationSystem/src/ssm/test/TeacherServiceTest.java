package ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.dao.TeacherDao;
import ssm.entity.Answer;
import ssm.entity.Teacher;
import ssm.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class TeacherServiceTest {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeacherDao teacherDao;
	
//	@Test
//	public void login() {
//		int i=teacherService.FindTeacher(20200606);
//		Teacher teacher=teacherService.FindTeacherMSG(20200606);
//		if(i>0) {
//			System.out.println("12");
//			System.out.println(teacher.getTeacher_id()+","+teacher.getTeacher_name());
//		}
//	}
//	
//	
//	//�����޸Ľ�ʦ����
//	@Test
//	public void changeTeacherpass() {
//		Teacher teacher = new Teacher();
//		teacher.setPassword("123456");
//		teacher.setTeacher_id(16900012);
//		int i = teacherService.changepass(teacher);
//		if(i>0) {
//			System.out.println(123);
//		}
//	}
//	@Test
//	public void addvote() {
//		Answer answer = new Answer();
//		answer.setVote_id(16900015);
//		answer.setBevote_id(16900013);
//		answer.setAnswer_1("A");
//		answer.setAnswer_2("B");
//		answer.setAnswer_3("A");
//		answer.setAnswer_4("C");
//		answer.setAnswer_5("A");
//		answer.setAnswer_6("D");
//		answer.setAnswer_7("A");
//		answer.setAnswer_8("B");
//		answer.setAnswer_9("B");
//		answer.setAnswer_10("A");
//		answer.setScore(50);
//		int i = teacherService.addVoteScore(answer);
//		if(i>0) {
//			System.out.println("���̳ɹ�����");
//		}else {
//			System.out.println("����ʧ�ܣ���");
//		}
//	}
	
//	@Test
//	public void getscore() {
//		List<Answer> list = teacherService.getscore(20200101);
//		if(list!=null) {
//			System.out.println(list);
//		}
//	}
	
	@Test
	public void getallscore() {
		List<Answer> list = teacherService.getallscore();
		if(list!=null) {
			System.out.println(list);
		}
	}
}
