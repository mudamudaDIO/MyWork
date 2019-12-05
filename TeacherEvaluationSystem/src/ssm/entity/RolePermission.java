package ssm.entity;

public class RolePermission {
	private int id;
	private int role_id;
	private int per_id;
	private Permission per;
	private Roles role;
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getPer_id() {
		return per_id;
	}
	public void setPer_id(int per_id) {
		this.per_id = per_id;
	}
	public Permission getPer() {
		return per;
	}
	public void setPer(Permission per) {
		this.per = per;
	}

	
}
