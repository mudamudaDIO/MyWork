package ssm.dao;

import java.util.List;

import ssm.entity.Permission;
import ssm.entity.RolePermission;

public interface LoginDao {
	List<Permission> getpers();//��ȡ����Ȩ��
	
	List<RolePermission> getPerByRoleid(int roleid);//��ȡ�ض���ɫȨ��
}
