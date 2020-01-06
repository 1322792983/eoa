package com.situ.eoa.role.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.eoa.role.domain.Role;
import com.situ.eoa.role.service.RoleService;
import com.situ.eoa.util.PageUtils;

@Controller
@RequestMapping("/role")
public class RoleController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(RoleController.class);
	private static final String PAGE_INDEX_ROLE = "role/role_index";
	private static final String PAGE_LIST_ROLE = "role/role_list";
	@Autowired
	private RoleService roleService;

	/**
	 * @ 完成新增
	 * 
	 * @param role
	 * @return
	 */
	/*
	 * 如果页面提交过来的数据是个数组，可以使用数组接受 String[] userLike。
	 * 
	 * 如果想使用集合去接受数据，则需要将集合定义到domain类中。
	 * 
	 * 
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Long doAddRole(Role role) {
		return roleService.saveRole(role);
	}

	/**
	 * @进首页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX_ROLE);
		return modelAndView;
	}

	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllRole(@PathVariable Integer pageNo,Role searchRole, ModelAndView modelAndView) {
		LOG.debug("这是页面提交的查询条件"+searchRole);
		searchRole=PageUtils.buildSearchParam(searchRole);
		LOG.debug(searchRole);
		// 要展示的列表数据
		modelAndView.addObject("roleList", roleService.findByPage(pageNo,searchRole));
		// 分页信息
		modelAndView.addObject("pageData", roleService.buildPageData(pageNo,searchRole));
		modelAndView.setViewName(PAGE_LIST_ROLE);
		return modelAndView;
	}
	
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Role goupdate(@PathVariable("rowId")Long rowId) {
		return roleService.findOneById(rowId);
	}
	
//	执行修改
	@ResponseBody
	@RequestMapping("/doupdate")
	public Integer doUpdate(Role role) {
		return roleService.doUpdate(role);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Long doDelete(@PathVariable("rowId")Long rowId) {
		return roleService.doDelete(rowId);
	}
	
	/**
	 * @判断name是否被使用fieldId=roleName&fieldValue=%E5%BC%A0%E4%B8%89&_=1576485199991
	 */
	@ResponseBody
	@RequestMapping("checkRoleName")
	public String checkRoleName(String fieldId,String fieldValue) {
		return roleService.checkRoleName(fieldId,fieldValue);
	}
	
}
