<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> 学生管理
		<button type="button" class="btn btn-info btn-sm float-right" id="button_add">新增</button>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<!-- 搜索页面开始 -->
				<div class="row">
					<div class="col-sm-12 col-md-12">
						<form id="form_search">
							<div class="form-row align-items-center">
								<div class="col-auto my-1">
									<select class="form-control" name="stuSex">
										<option value="">学生性别</option>
										<option value="1">男</option>
										<option value="0">女</option>
									</select>
								</div>
								<div class="col-auto my-1">
									<input type="text" class="form-control" name="stuName" id="inlineFormInputName" placeholder="学生名称">
								</div>
								<div class="col-auto my-1">
									<input type="text" class="form-control" name="stuCode" id="inlineFormInputName" placeholder="学生编号">
								</div>
								<div class="col-auto my-1">
									<button type="reset" class="btn btn-dark">重置</button>
									<button type="button" class="btn btn-primary"  id="button_search">搜索</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- 搜索页面结束 -->
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				
			</div>
		</div>
	</div>
</div>
<!-- Logout Modal-->
<div class="modal fade" id="modal_student" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">学生<span id="action_info"></span></h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form id="form_student_add_edit">
			<div class="modal-body">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">班级主键</label>
						<div class="col-sm-7" id="select_clazz_id">
							<!-- <input type="text" class="form-control" id="clazzId" name="clazzId"> -->
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">学生编号</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,ajax[ajaxStudentCode]]" id="stuCode" name="stuCode">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">学生名称</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required]" id="stuName" name="stuName">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">学生性别</label>
						<div class="col-sm-7">
							<select class="form-control" name="stuSex" id="stuSex">
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">学生生日</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" id="stuBirthday" name="stuBirthday">
						</div>
					</div>
					<input type="hidden" id="rowId" name="rowId"/>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
				<a class="btn btn-primary" href="javascript:;" id="button_submit">提交</a>
				<!-- <button class="btn btn-primary" type="button" id="button_update">修改</button> -->
			</div>
			</form>
		</div>
	</div>
</div>
<script src="assert/page/eoa-student.js"></script>