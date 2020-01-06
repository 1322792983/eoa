package com.situ.eoa.student.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.eoa.clazz.domain.Clazz;
import com.situ.eoa.clazz.service.ClazzService;
import com.situ.eoa.student.domain.Student;
import com.situ.eoa.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX_STUDENT = "student/student_index";
	private static final String PAGE_LIST_STUDENT = "student/student_list";

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClazzService clazzService;

	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX_STUDENT);
		return modelAndView;
	}

	/**
	 * @查询所有的记录
	 * @param pageNo 分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllRole(@PathVariable Integer pageNo,Student searchStu, ModelAndView modelAndView) {
		// 要展示的列表数据
		modelAndView.addObject("studentList", studentService.findByPage(pageNo,searchStu));
		// 分页信息
		modelAndView.addObject("pageData", studentService.buildPageData(pageNo,searchStu));
		modelAndView.setViewName(PAGE_LIST_STUDENT);
		return modelAndView;
	}

	/**
	 * @ 完成新增
	 * 
	 * @param student
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Long doAddRole(Student student) {
//		student.setStuBirthday(new Date());
		System.out.println(student);
		student.getStuBirthday();
//		将班级表修改人数
		Clazz clazz = new Clazz();
		clazz.setStuCount((clazzService.findOneById(student.getClazzId())).getStuCount() + 1);
		clazz.setRowId(student.getClazzId());
		clazzService.doUpdate(clazz);
		return studentService.save(student);
	}
	
	/**
	 * 执行删除
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Integer doDelete(@PathVariable("rowId")Long rowId) {
		Student student = studentService.findOneById(rowId);
//		将班级表修改人数
		Clazz clazz = new Clazz();
		clazz.setStuCount((clazzService.findOneById(student.getClazzId())).getStuCount() - 1);
		clazz.setRowId(student.getClazzId());
		clazzService.doUpdate(clazz);
		return studentService.doDelete(rowId);
	}
	
	/**
	 * @进修改
	 * @param rowId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Student goupdate(@PathVariable("rowId")Long rowId) {
		return studentService.findOneById(rowId);
	}
	
//	执行修改
	@ResponseBody
	@RequestMapping("/doupdate")
	public Integer doUpdate(Student student) {
		System.out.println(student);
		return studentService.doUpdate(student);
	}
	
//	搜索
	@ResponseBody
	@RequestMapping("/doselect")
	public ModelAndView doSelect(ModelAndView modelAndView,Student student) {
		System.out.println(student);
		modelAndView.addObject("studentList",studentService.selectByView(student));
		modelAndView.setViewName(PAGE_LIST_STUDENT);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("checkStudentCode")
	public String checkClazzName(String fieldId,String fieldValue) {
////		通过服务层判断此名称是否可以使用，true可以使用，false不可以使用
//		Boolean bool = studentService.checkRoleCode(fieldValue);
////		通过使用ObjectMapper开始封装需要返回的校验结果
//		ObjectMapper objectMapper = new ObjectMapper();
//		List<Object> list = new ArrayList<Object>();
//		list.add(fieldId);
//		list.add(bool);
//		try {
////			将封装好的校验结果转换成json格式的字符串并响应回去
//			return objectMapper.writeValueAsString(list);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		return studentService.checkRoleCode(fieldId,fieldValue);
	}
	

}
