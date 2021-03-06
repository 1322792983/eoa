$(document).ready(function() {
//	对表单绑定校验
	$('#form_clazz_add_edit').validationEngine('attach',{
		onValidationComplete:function(form,status) {
//			如果表单校验通过
			if(status) {
//				执行新增或修改
				saveOrUpdate();
			}
		}
	});
	// 查询所有的数据
	initTalbeData(1);
	// 绑定新增按钮
	$('#button_add').off('click').on('click', function() {
		$('#form_clazz_add_edit')[0].reset();
		$('#modal_clazz').modal('show');
//		清空所有的校验信息
		$('.formError').remove();
//		尝试移出data-skip的属性（为了唯一性校验）
		$('#clazzName').removeAttr('data-skip');
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
	});
	// 绑定Submit按钮
	$('#button_submit').off('click').on('click', function() {
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_clazz_add_edit').submit();
	});
//	绑定删除超链接
	$('#dataTable_wrapper').off('click','#delete').on('click','#delete',function(){
		var rowId = $(this).attr("data-rowId");
		if (confirm("你确定删除吗？")) {
			// alert(rowId);
			$.ajax({
				url : 'clazz/dodelete/' + rowId,
				dataType : 'json',
				success : function(result) {
					if (result) {
						// 调用查询table表单的数据
						initTalbeData(1);
					}
				}
			});
		}
	});
//	绑定修改超链接
	$('#dataTable_wrapper').off('click','#update').on('click','#update',function(){
		var rowId = $(this).attr("data-rowId");
		$.ajax({
			// role/goupdate/1
			url : 'clazz/goupdate/' + rowId,
			success : function(clazz) {
				console.log(clazz);
				$('#modal_clazz').modal('show');
// 	 			清空所有的校验信息
 	 			$('.formError').remove();
 	 			var clazzName = clazz.clazzName;
// 	 			在需要进行唯一性校验的filed中加入data-skip属性并赋值
 	 			$('#clazzName').val(clazzName).attr('data-skip',clazzName);
				$('#clazzName').val(clazz.clazzName);
				$('#clazzInfo').val(clazz.clazzInfo);
				$('#rowId').val(clazz.rowId);
				$('#action_info').html('修改');
			}
		});
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
			type : 'post',
			url : 'clazz/doupdate',
			data : $('#form_clazz_add_edit').serialize(),
			dataType : 'json',
			success : function(result) {
				if (result) {
					$('#modal_clazz').modal('hide');
					initTalbeData(1);
				}
			}
		});
	} else {//判断是新增
		$.ajax({
			type : 'post',
			url : 'clazz/add',
			data : $('#form_clazz_add_edit').serialize(),
			dataType : 'json',
			success : function(result) {
				if (result) {
					$('#modal_clazz').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}
}

// init table data
// 查询全部信息
function initTalbeData(pageNo) {
	$.ajax({
		 type:'post',
		 url:'clazz/find/'+pageNo,
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

//搜索
//function doselect() {
//	var clazzName = $('#select_clazzname').val();
////	alert(clazzName);
//	$.ajax({
//		// role/goupdate/1
//		url : 'clazz/doselect/' + clazzName,
//		success : function(htmlData) {
//			$('#dataTable_wrapper').html(htmlData);
//		}
//	});
//}
