package com.situ.eoa.clazz.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.eoa.clazz.domain.Clazz;
import com.situ.eoa.clazz.service.ClazzService;

@Controller
@RequestMapping("/clazz")
public class ClazzController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX_CLAZZ = "clazz/clazz_index";
	private static final String PAGE_LIST_CLAZZ = "clazz/clazz_list";
	
	@Autowired
	private ClazzService clazzService;

	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX_CLAZZ);
		return modelAndView;
	}
	
	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllRole(@PathVariable Integer pageNo,Clazz searchClazz, ModelAndView modelAndView) {
		// 要展示的列表数据
		modelAndView.addObject("clazzList", clazzService.findByPage(pageNo,searchClazz));
		// 分页信息
		modelAndView.addObject("pageData", clazzService.buildPageData(pageNo,searchClazz));
		modelAndView.setViewName(PAGE_LIST_CLAZZ);
		return modelAndView;
	}
	
	/**
	 * 	查询所有的记录 当做学生新增的查询班级主键
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find1")
	public ModelAndView findAllRole1(ModelAndView modelAndView) {
		modelAndView.addObject("clazzList",clazzService.find());
		modelAndView.setViewName("student/student_select_clazz_id");
		return modelAndView;
	}
	
	/**
	 * @ 完成新增
	 * 
	 * @param clazz
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Long doAddRole(Clazz clazz) {
		return clazzService.save(clazz);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Integer doDelete(@PathVariable("rowId")Long rowId) {
		return clazzService.doDelete(rowId);
	}
	
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Clazz goupdate(@PathVariable("rowId")Long rowId) {
		return clazzService.findOneById(rowId);
	}
	
//	搜索
	@ResponseBody
	@RequestMapping("/doselect/{clazzName}")
	public ModelAndView doSelect(@PathVariable("clazzName")String clazzName,ModelAndView modelAndView) {
		modelAndView.addObject("clazzList",clazzService.selectByView(clazzName));
		modelAndView.setViewName(PAGE_LIST_CLAZZ);
		return modelAndView;
	}
	
//	当搜索框为空时查询全部
	@RequestMapping("/doselect")
	public ModelAndView doSelect(ModelAndView modelAndView) {
		modelAndView.addObject("clazzList",clazzService.find());
		modelAndView.setViewName(PAGE_LIST_CLAZZ);
		return modelAndView;
	}
	
//	执行修改
	@ResponseBody
	@RequestMapping("/doupdate")
	public Integer doUpdate(Clazz clazz) {
		return clazzService.doUpdate(clazz);
	}
	
	@ResponseBody
	@RequestMapping("checkClazzName")
	public String checkClazzName(String fieldId,String fieldValue) {
		return clazzService.checkRoleName(fieldId,fieldValue);
	}
}
