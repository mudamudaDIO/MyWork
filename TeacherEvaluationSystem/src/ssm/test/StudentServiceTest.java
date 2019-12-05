package ssm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.dao.StudentDao;
import ssm.entity.Answer;
import ssm.entity.Score;
import ssm.entity.Student;
import ssm.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentDao studentDao;
	
//	//测试学生登录
//	@Test
//	public void login() {
//		Student stu=new Student();
//		stu.setStudent_id(169000930);
//		stu.setPassword("169000930");
//		boolean flag=studentService.login(stu);
//		if(flag) {
//			System.out.println("成功");
//		}
//	}

	@Test
	public void changepass() {
		float i=Score.countScore("A", "A", "A", "A", "A", "D", "D", "B", "C", "D");
		System.out.println(i);
	}
	
	 
}
