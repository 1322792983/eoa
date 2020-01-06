$(document).ready(function(){
//	对表单绑定校验
	$('#form_role_add_edit').validationEngine('attach',{
		onValidationComplete:function(form,status) {
//			如果表单校验通过
			if(status) {
//				执行新增或修改
				saveOrUpdate();
			}
		}
	});
	//查询所有的数据
	initTalbeData(1);
	//绑定新增按钮
	$('#button_add').off('click').on('click',function(){
		$('#form_role_add_edit')[0].reset();
		$('#modal_role').modal('show');
//		清空所有的校验信息
		$('.formError').remove();
//		尝试移出data-skip的属性（为了唯一性校验）
		$('#roleName').removeAttr('data-skip');
//		$('#rowId').val('');
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
	});
	//绑定Submit按钮
	$('#button_submit').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_role_add_edit').submit();
	});
	
//	绑定删除超链接事件
	$('#dataTable_wrapper').off('click','#deleteA').on('click','#deleteA',function(){
		var rowId = $(this).attr("data-rowId");
		if (confirm("你确定删除吗？")) {
			$.ajax({
				url : 'role/dodelete/' + rowId,
				dataType : 'json',
				success : function(result) {
//					alert("11");
					if (result) {
						// 调用查询table表单的数据
						initTalbeData(1);
					}
				}
			});
		}
	});
	
//	绑定搜索按钮
	$('#button_search').on('click',function(){
		initTalbeData(1);
	});
	
});


function saveOrUpdate() {
	var rowId = $('#rowId').val();
	if(rowId){//如果主键有信息，则判断是修改
		$.ajax({
			type:'post',
			url:'role/doupdate',
			data:$('#form_role_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_role').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}else{//判断是新增
		$.ajax({
			type:'post',
			url:'role/add',
			data:$('#form_role_add_edit').serialize(),
			dataType:'json',
			success:function(result){
				if(result){
					$('#modal_role').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}
}

//init table data
 function initTalbeData(pageNo){
	 $.ajax({
		 type:'post',
		 url:'role/find/'+pageNo,
		 data:$('#form_search').serialize(),
		 success:function(htmlData){
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
 }
 
//响应分页
 function page_select(pageNo){
	 initTalbeData(pageNo);
 }
 //上一页
 function page_prev(){
	var current_page = $('#ul_pagination').find('.active').find('span').text();
	//console.log(current_page);
	initTalbeData(current_page-1);
 }
 //下一页
 function page_next(){
	 var current_page = $('#ul_pagination').find('.active').find('span').text();
	 initTalbeData(parseInt(current_page)+1);
 }
 
//进修改
 function goUpdate(rowId) {
 	$.ajax({
 		// role/goupdate/1
 		url : 'role/goupdate/' + rowId,
 		success : function(role) {
// 			if(true)	js代表true的
 			if(role) {
// 				console.log(role);
 	 			$('#modal_role').modal('show');
// 	 			清空所有的校验信息
 	 			$('.formError').remove();
// 	 			$('#roleName').val(role.roleName);
 	 			var roleName = role.roleName;
// 	 			在需要进行唯一性校验的filed中加入data-skip属性并赋值
 	 			$('#roleName').val(roleName).attr('data-skip',roleName);
 	 			$('#roleKind').val(role.roleKind);
 	 			$('#roleInfo').val(role.roleInfo);
 	 			$('#rowId').val(role.rowId);
 	 			$('#action_info').html('修改');
 			}
 		}
 	});
 }