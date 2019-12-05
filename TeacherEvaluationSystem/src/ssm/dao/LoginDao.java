package ssm.dao;

import java.util.List;

import ssm.entity.Permission;
import ssm.entity.RolePermission;

public interface LoginDao {
	List<Permission> getpers();//获取所有权限
	
	List<RolePermission> getPerByRoleid(int roleid);//获取特定角色权限
}
