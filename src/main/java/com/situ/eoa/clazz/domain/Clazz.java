package com.situ.eoa.clazz.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.eoa.base.domain.BaseClass;

/**
 * 班级类
 *
 */
@Alias("Clazz")
public class Clazz extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private String clazzName;// 班级名称
	private Integer stuCount;// 学生数量
	private String clazzInfo;// 班级简介

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public Integer getStuCount() {
		return stuCount;
	}

	public void setStuCount(Integer stuCount) {
		this.stuCount = stuCount;
	}

	public String getClazzInfo() {
		return clazzInfo;
	}

	public void setClazzInfo(String clazzInfo) {
		this.clazzInfo = clazzInfo;
	}

	@Override
	public String toString() {
		return "Clazz [clazzName=" + clazzName + ", stuCount=" + stuCount + ", clazzInfo=" + clazzInfo + "]";
	}
	
}
