<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i> 角色管理
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
									<select class="form-control" name="roleKind">
										<option value="">角色级别</option>
										<option value="1">一级</option>
										<option value="2">二级</option>
										<option value="3">三级</option>
									</select>
								</div>
								<div class="col-auto my-1">
									<input type="text" class="form-control" name="roleName" placeholder="角色名称">
								</div>
								<div class="col-auto my-1">
									<button type="reset" class="btn btn-dark">重置</button>
									<button type="button" class="btn btn-primary" id="button_search">搜索</button>
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
<div class="modal fade" id="modal_role" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
			
				<h5 class="modal-title" id="exampleModalLabel">角色<span id="action_info"></span></h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form id="form_role_add_edit">
			<div class="modal-body">
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">角色名称</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required,ajax[ajaxRoleName]]" id="roleName" name="roleName">
							
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">角色级别</label>
						<div class="col-sm-7">
							<select class="form-control" name="roleKind" id="roleKind">
								<option value="1">一级</option>
								<option value="2">二级</option>
								<option value="3">三级</option>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">角色简介</label>
						<div class="col-sm-7">
							<textarea rows="" cols="" class="form-control validate[required]" name="roleInfo" id="roleInfo"></textarea>
						</div>
					</div>
					<input type="hidden" id="rowId" name="rowId"/>
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
				<a class="btn btn-primary" href="javascript:;" id="button_submit">提交</a>
			</div>
			</form>
		</div>
	</div>
</div>
<script src="assert/page/eoa-role.js"></script>