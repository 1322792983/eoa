package com.situ.eoa.role.service;

import java.util.List;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.role.domain.Role;

public interface RoleService {
	Long saveRole(Role role);

	List<Role> find();

	Role findOneById(Long rowId);

	Integer doUpdate(Role role);

	Long doDelete(Long rowId);

	String checkRoleName(String fieldId,String fieldValue);

	PageData buildPageData(Integer pageNo, Role searchRole);

	List<Role> findByPage(Integer pageNo, Role searchRole);
}
