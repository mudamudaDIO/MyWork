package ssm.entity;

public class Teacher {
	private int teacher_id;
	private String teacher_name;
	private int teacher_insid;
	private int teacher_subid;
	private String password;
	private Ins ins;
	private Subject subject;
	private int role_id;
	
	private boolean isvote;
	public boolean isIsvote() {
		return isvote;
	}
	public void setIsvote(boolean isvote) {
		this.isvote = isvote;
	}
	public Ins getIns() {
		return ins;
	}
	public void setIns(Ins ins) {
		this.ins = ins;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public int getTeacher_insid() {
		return teacher_insid;
	}
	public void setTeacher_insid(int teacher_insid) {
		this.teacher_insid = teacher_insid;
	}
	public int getTeacher_subid() {
		return teacher_subid;
	}
	public void setTeacher_subid(int teacher_subid) {
		this.teacher_subid = teacher_subid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
}
