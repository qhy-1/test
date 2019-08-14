$(function() {
	layui.use([ 'table', 'form' ], function() {
		var table = layui.table;
		var form = layui.form;
		table.render({
			elem : '#table',
			url : 'list',
			cols : [ [ {
				field : 'stuId',
				title : '学生编号',
				align : 'center',
				width : '10%'
			}, {
				field : 'stuName',
				title : '学生姓名',
				align : 'center'
			}, {
				field : 'stuSex',
				title : '学生性别',
				align : 'center',
				width : '15%'
			}, {
				field : 'stuAge',
				title : '学生年龄',
				align : 'center'
			}, {
				field : 'clsName',
				title : '所在班级',
				align : 'center'
			}, {
				fixed : 'right',
				title : '操作',
				width : 378,
				align : 'center',
				toolbar : '#barDemo'
			} ] ],
			page : true,
			limit : 5,
		});

		// 增加
		form.on('submit(add_formDemo)', function(data) {
			var student = data.field;
			$.ajax({
				url : 'studentAdd',
				type : 'POST',
				dataType : 'JSON',
				data : {
					"stuName" : student.addstuName,
					"stuSex" : student.addstuSex,
					"stuAge" : student.addstuAge,
					"clazz" : student.classSelect
				},
				success : function(data) {
					if (data) {
						window.location.href = "stuList.html";
					} else {
						$.ajax({
							url : 'clazzSelect',
							dataType : 'json',
							type : 'post',
							success : function(data) {
								$.each(data, function(index, item) {
									for (var i = 0; i <= index.length; i++) {
										$('#selectId').append(
												new Option(item[i].clsName,
														item[i].clsId));// 往下拉菜单里添加元素
									}
								})
								form.render();
							}
						});
						layer.open({
							type : 1,
							title : "增加学生信息",
							area : [ '420px', '500px' ],
							content : $("#add_form")
						});
					}
				}
			});
			return false;
		});

		// 监听工具条
		table.on('tool(demo)', function(obj) {
			var data = obj.data;
			if (obj.event === 'del') {
				layer.confirm('真的删除行么', function(index) {
					layer.close(index);
					$.ajax({
						url : "studentDelete",
						type : "POST",
						data : {
							"stuId" : data.stuId
						},
						dataType : "json",
						success : function(data) {
							if (data) {
								window.location.href = "stuList.html";
							}
						}
					});
				});
			} else if (obj.event === 'edit') {
				var clsId = data.clsId;
				$.ajax({
					url : 'clazzSelect',
					dataType : 'json',
					type : 'post',
					success : function(data) {
						$.each(data, function(index, item) {
							for (var i = 0; i <= index.length; i++) {
								$('#selectId2').append(
										new Option(item[i].clsName,
												item[i].clsId));// 往下拉菜单里添加元素
								$("#selectId2").find("option[value=" + clsId + "]").prop("selected", true);// 默认选中下拉框
							}
						})
						form.render();
					}
				});
				$("#stuId").val(data.stuId);
				$("#stuName").val(data.stuName);
				$("#stuAge").val(data.stuAge);
				$("input[name=stuSex][value='男']").attr("checked",data.stuSex == "男" ? true : false);
				$("input[name=stuSex][value='女']").attr("checked",data.stuSex == "女" ? true : false);
				form.render(); // 更新全部
				layer.open({
					type : 1,
					title : "修改学生信息",
					area : [ '420px', '500px' ],
					content : $("#edit_form"),// 引用的弹出层的页面层的方式加载修改界面表单
					end : function() {
						$("#edit_form").css("display", "none");
					}
				});
			}
		});

		// 学生修改
		form.on('submit(formDemo)', function(data) {
			var student = data.field;
			$.ajax({
				url : 'studentUpdate',
				type : 'POST',
				dataType : 'JSON',
				data : {
					"stuId" : student.stuId,
					"stuName" : student.stuName,
					"stuSex" : student.stuSex,
					"stuAge" : student.stuAge,
					"clazz" : student.classId
				},
				success : function(data) {
					alert(data);
					layer.msg('修改成功', {
						time : 1500, // 1500ms后自动关闭
					});
				}
			});
		});

	});
	$("#add").click(
			function() {
				var form = layui.form;
				$.ajax({
					url : 'clazzSelect',
					dataType : 'json',
					type : 'post',
					success : function(data) {
						$.each(data, function(index, item) {
							for (var i = 0; i <= index.length; i++) {
								$('#selectId').append(
										new Option(item[i].clsName,
												item[i].clsId));// 往下拉菜单里添加元素
							}
						})
						form.render();
					}
				});
				layer.open({
					type : 1,
					title : "增加学生信息",
					area : [ '420px', '500px' ],
					content : $("#add_form"),
					end : function() {
						$("#add_form").css("display", "none");
					}
				});
			});
});