package com.situ.eoa.clazz.service;

import java.util.List;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.clazz.domain.Clazz;

public interface ClazzService {
	
	Long save(Clazz clazz);
	
	List<Clazz> find();
	
	List<Clazz> selectByView(String clazzName);
	
	Integer doDelete(Long rowId);
	
	Clazz findOneById(Long rowId);
	
	Integer doUpdate(Clazz clazz);
	
	String checkRoleName(String fieldId,String fieldValue);
	
	PageData buildPageData(Integer pageNo, Clazz searchClazz);

	List<Clazz> findByPage(Integer pageNo, Clazz searchClazz);
}
