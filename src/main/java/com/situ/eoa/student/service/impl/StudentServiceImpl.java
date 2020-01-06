package com.situ.eoa.student.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.student.dao.StudentDao;
import com.situ.eoa.student.domain.Student;
import com.situ.eoa.student.service.StudentService;
import com.situ.eoa.util.JSONUtils;
import com.situ.eoa.util.PageUtils;

@Service
public class StudentServiceImpl implements Serializable, StudentService {

	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentDao studentDao;

	@Override
	public Long save(Student student) {
		student.setActiveFlag(1);
		student.setCreateBy("admin");
		student.setCreateDate(new Date());
		return studentDao.save(student);
	}

	@Override
	public List<Student> find() {
		return studentDao.find();
	}

	@Override
	public Integer doDelete(Long rowId) {
		studentDao.delete(rowId);
		return 1;
	}

	@Override
	public Student findOneById(Long rowId) {
		return studentDao.get(rowId);
	}

	@Override
	public Integer doUpdate(Student student) {
		student.setUpdateBy("admin");
		student.setUpdateDate(new Date());
		studentDao.update(student);
		return 1;
	}

	@Override
	public List<Student> selectByView(Student student) {
		return studentDao.selectByView(student);
	}

	@Override
	public String checkRoleCode(String fieldId, String fieldValue) {
		Student student = studentDao.getByCode(fieldValue);
		Boolean bool = student != null ? false : true;
		return JSONUtils.buildValidationInfo(fieldId, bool);
	}

	@Override
	public PageData buildPageData(Integer pageNo, Student searchStu) {
		// 查询出数据总数
		Integer dataCount = studentDao.getCount(searchStu);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public List<Student> findByPage(Integer pageNo, Student searchStu) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return studentDao.findByPage(searchStu, firstResult, maxResults);
	}

}
