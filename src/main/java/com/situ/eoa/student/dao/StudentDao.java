package com.situ.eoa.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.eoa.student.domain.Student;

@Repository
public interface StudentDao {
	Long save(Student student);

	void update(Student student);

	void delete(Long rowId);

	Student get(Long rowId);

	List<Student> find();
	
	List<Student> selectByView(Student student);
	
	Student getByCode(String stuCode);
	
	List<Student> findByPage(@Param("searchStu") Student searchStu, @Param("firstResult") Integer firstResult,
			@Param("maxResults") Integer maxResults);

	Integer getCount(@Param("searchStu") Student searchStu);
}
