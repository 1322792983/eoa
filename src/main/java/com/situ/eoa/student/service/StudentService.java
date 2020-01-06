package com.situ.eoa.student.service;

import java.util.List;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.student.domain.Student;

public interface StudentService {
	Long save(Student student);

	List<Student> find();

	Integer doDelete(Long rowId);

	Student findOneById(Long rowId);

	Integer doUpdate(Student student);
	
	List<Student> selectByView(Student student);
	
	String checkRoleCode(String fieldId,String fieldValue);
	
	PageData buildPageData(Integer pageNo, Student searchStu);

	List<Student> findByPage(Integer pageNo, Student searchStu);
}
