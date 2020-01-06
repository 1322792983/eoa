package com.situ.eoa.clazz.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.clazz.dao.ClazzDao;
import com.situ.eoa.clazz.domain.Clazz;
import com.situ.eoa.clazz.service.ClazzService;
import com.situ.eoa.util.JSONUtils;
import com.situ.eoa.util.PageUtils;

@Service
public class ClazzServiceImpl implements Serializable, ClazzService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClazzDao clazzDao;

	@Override
	public Long save(Clazz clazz) {
		clazz.setStuCount(0);
		clazz.setActiveFlag(1);
		clazz.setCreateBy("admin");
		clazz.setCreateDate(new Date());
		return clazzDao.save(clazz);
	}

	@Override
	public List<Clazz> find() {
		return clazzDao.find();
	}

	@Override
	public Integer doDelete(Long rowId) {
		clazzDao.delete(rowId);
		return 1;
	}

	@Override
	public Clazz findOneById(Long rowId) {
		return clazzDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Clazz clazz) {
		clazz.setUpdateBy("admin");
		clazz.setUpdateDate(new Date());
		clazzDao.update(clazz);
		return 1;
	}

	@Override
	public List<Clazz> selectByView(String clazzName) {
		return clazzDao.selectByView(clazzName);
	}

	@Override
	public String checkRoleName(String fieldId, String fieldValue) {
		Clazz clazz = clazzDao.getByName(fieldValue);
		Boolean bool = clazz != null ? false : true;
		return JSONUtils.buildValidationInfo(fieldId, bool);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Clazz searchClazz) {
		// 查询出数据总数
		Integer dataCount = clazzDao.getCount(searchClazz);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public List<Clazz> findByPage(Integer pageNo, Clazz searchClazz) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return clazzDao.findByPage(searchClazz, firstResult, maxResults);
	}

}
