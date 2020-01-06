package com.situ.eoa.role.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.eoa.base.domain.BaseClass;
@Alias("Role")
public class Role extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private String roleName;
	private Integer roleKind;
	private String roleInfo;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleKind() {
		return roleKind;
	}

	public void setRoleKind(Integer roleKind) {
		this.roleKind = roleKind;
	}

	public String getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
}
