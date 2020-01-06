$(document).ready(function() {
//	对表单绑定校验
	$('#form_student_add_edit').validationEngine('attach',{
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
//	先将班级主键查询放入到新增列表中
	findclazz();
	// 绑定新增按钮
	$('#button_add').off('click').on('click', function() {
		$('#form_student_add_edit')[0].reset();
		$('#modal_student').modal('show');
//		清空所有的校验信息
		$('.formError').remove();
//		尝试移出data-skip的属性（为了唯一性校验）
		$('#studentCode').removeAttr('data-skip');
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');

	});
	// 绑定Submit按钮
	$('#button_submit').off('click').on('click', function() {
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_student_add_edit').submit();
	});
	
//	绑定删除超链接
	$('#dataTable_wrapper').off('click','#delete').on('click','#delete',function(){
		var rowId = $(this).attr("data-rowId");
		if (confirm("你确定删除吗？")) {
			// alert(rowId);
			$.ajax({
				url : 'student/dodelete/' + rowId,
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
			url : 'student/goupdate/' + rowId,
			success : function(student) {
				console.log(student);
				$('#modal_student').modal('show');
// 	 			清空所有的校验信息
 	 			$('.formError').remove();
 	 			var stuCode = student.stuCode;
// 	 			在需要进行唯一性校验的filed中加入data-skip属性并赋值
 	 			$('#stuCode').val(stuCode).attr('data-skip',stuCode);
				$('#clazzId').val(student.clazzId);
				$('#stuCode').val(student.stuCode);
				$('#stuName').val(student.stuName);
				$('#stuSex').val(student.stuSex);
				$('#stuBirthday').val(student.stuBirthday);
				$('#rowId').val(student.rowId);
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
	if (rowId) {// 如果主键有信息，则判断是修改
		$.ajax({
			type : 'post',
			url : 'student/doupdate',
			data : $('#form_student_add_edit').serialize(),
			dataType : 'json',
			success : function(result) {
				if (result) {
					$('#modal_student').modal('hide');
					initTalbeData(1);
				}
			}
		});
	} else {// 判断是新增
		$.ajax({
			type : 'post',
			url : 'student/add',
			data : $('#form_student_add_edit').serialize(),
			dataType : 'json',
			success : function(result) {
				if (result) {
					$('#modal_student').modal('hide');
					initTalbeData(1);
				}
			}
		});
	}
}


function findclazz() {
	// 先将班级主键查询放入到新增列表中
	$.ajax({
		url : 'clazz/find1',
		success : function(htmlData) {
			$('#select_clazz_id').html(htmlData);
		}
	});
}

// init table data
// 查询全部信息
function initTalbeData(pageNo) {
	$.ajax({
		 type:'post',
		 url:'student/find/'+pageNo,
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
