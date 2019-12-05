package ssm.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.entity.Classroom;
import ssm.entity.Ins;
import ssm.entity.Permission;
import ssm.entity.Question;
import ssm.entity.RolePermission;
import ssm.entity.Roles;
import ssm.entity.Student;
import ssm.entity.Subject;
import ssm.service.AdminService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class AdminServiceTest {
	@Autowired
	private AdminService adminservice;
	
	//²âÊÔ
	@Test
	public void test() {
//		Student stu=new Student();
//		stu.setStudent_id(169000925);
//		stu.setStudent_ins(1);
//		stu.setStudent_name("456");
//		stu.setStudent_classid(1690011);
//		stu.setPassword("169000925");
//		stu.setRole_id(2);
//		int i=adminservice.addStudent(stu);
		int i=adminservice.delStudent(169000925);
		if(i>0) {
			System.out.println("³É¹¦");
		}else {
			System.out.println("Ê§°Ü");
		}
//		List<Roles> list=adminservice.getroles();
//		for(Roles r:list) {
//			System.out.println(r.getRole_name());
//		}
		
	}
	
	 
}
