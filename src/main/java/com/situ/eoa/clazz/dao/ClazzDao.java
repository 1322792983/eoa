package com.situ.eoa.clazz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.eoa.clazz.domain.Clazz;

@Repository
public interface ClazzDao {
	Long save(Clazz clazz);

	void update(Clazz clazz);

	void delete(Long rowId);

	Clazz get(Long rowId);

	List<Clazz> find();

	List<Clazz> selectByView(String clazzName);

	Clazz getByName(String clazzName);

	List<Clazz> findByPage(@Param("searchClazz") Clazz searchClazz, @Param("firstResult") Integer firstResult,
			@Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchClazz") Clazz searchClazz);
}
