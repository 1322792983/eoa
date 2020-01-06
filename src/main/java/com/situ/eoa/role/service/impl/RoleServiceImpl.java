package com.situ.eoa.role.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.	role.dao.RoleDao;
import com.situ.eoa.role.domain.Role;
import com.situ.eoa.role.service.RoleService;
import com.situ.eoa.util.JSONUtils;
import com.situ.eoa.util.PageUtils;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public Long saveRole(Role role) {
		role.setActiveFlag(1);
		role.setCreateBy("admin");
		role.setCreateDate(new Date());
		return roleDao.save(role);
	}

	@Override
	public List<Role> find() {
		return roleDao.find();
	}

	@Override
	public Role findOneById(Long rowId) {
		return roleDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Role role) {
		role.setUpdateBy("admin");
		role.setUpdateDate(new Date());
		roleDao.update(role);
		return 1;
	}

	@Override
	public Long doDelete(Long rowId) {
		roleDao.delete(rowId);
		return 1L;
	}

	@Override
	public String checkRoleName(String fieldId,String fieldValue) {
		Role role = roleDao.getByName(fieldValue);
		Boolean bool = role != null ? false : true;
		return JSONUtils.buildValidationInfo(fieldId, bool);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Role searchRole) {
		// 查询出数据总数
		Integer dataCount = roleDao.getCount(searchRole);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	/**
	 * 分页查询记录
	 */
	@Override
	public List<Role> findByPage(Integer pageNo, Role searchRole) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return roleDao.findByPage(searchRole, firstResult, maxResults);
	}

}
