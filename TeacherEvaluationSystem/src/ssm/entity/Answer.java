package ssm.entity;

public class Answer {
	private int id;
	private int vote_id;
	private int bevote_id;
	private String answer_1;
	private String answer_2;
	private String answer_3;
	private String answer_4;
	private String answer_5;
	private String answer_6;
	private String answer_7;
	private String answer_8;
	private String answer_9;
	private String answer_10;
	private float score;
	private int type;
	private String beizu;
	
	private Teacher teacher;
	private Student student;
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVote_id() {
		return vote_id;
	}
	public void setVote_id(int vote_id) {
		this.vote_id = vote_id;
	}
	public int getBevote_id() {
		return bevote_id;
	}
	public void setBevote_id(int bevote_id) {
		this.bevote_id = bevote_id;
	}
	public String getAnswer_1() {
		return answer_1;
	}
	public void setAnswer_1(String answer_1) {
		this.answer_1 = answer_1;
	}
	public String getAnswer_2() {
		return answer_2;
	}
	public void setAnswer_2(String answer_2) {
		this.answer_2 = answer_2;
	}
	public String getAnswer_3() {
		return answer_3;
	}
	public void setAnswer_3(String answer_3) {
		this.answer_3 = answer_3;
	}
	public String getAnswer_4() {
		return answer_4;
	}
	public void setAnswer_4(String answer_4) {
		this.answer_4 = answer_4;
	}
	public String getAnswer_5() {
		return answer_5;
	}
	public void setAnswer_5(String answer_5) {
		this.answer_5 = answer_5;
	}
	public String getAnswer_6() {
		return answer_6;
	}
	public void setAnswer_6(String answer_6) {
		this.answer_6 = answer_6;
	}
	public String getAnswer_7() {
		return answer_7;
	}
	public void setAnswer_7(String answer_7) {
		this.answer_7 = answer_7;
	}
	public String getAnswer_8() {
		return answer_8;
	}
	public void setAnswer_8(String answer_8) {
		this.answer_8 = answer_8;
	}
	public String getAnswer_9() {
		return answer_9;
	}
	public void setAnswer_9(String answer_9) {
		this.answer_9 = answer_9;
	}
	public String getAnswer_10() {
		return answer_10;
	}
	public void setAnswer_10(String answer_10) {
		this.answer_10 = answer_10;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBeizu() {
		return beizu;
	}
	public void setBeizu(String beizu) {
		this.beizu = beizu;
	}

}
