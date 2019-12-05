package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.LoginDao;
import ssm.entity.Permission;
import ssm.entity.RolePermission;



@Service
public class LoginService {
	@Autowired
	private LoginDao logindao;
	
	/**
	 * 获取权限列表
	 * @return
	 */
	public List<Permission> getper(){
		return logindao.getpers();
	}
	
	/**
	 * 获取角色-权限中间表
	 * @param roleid
	 * @return
	 */
	public List<RolePermission> getPerByRoleid(int roleid){
		return logindao.getPerByRoleid(roleid);
	}
}
