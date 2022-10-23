// // $('.modal').on('hidden.bs.modal', function () {
// // 	alert('关闭了')
// // });
//
// // 监听添加按钮事件
// $('#addUserBtn').click(function() {
// 	// 添加按钮被点击之后，展示modal框
// 	$('#modal-form-add').modal('show');
// })
//
// // 查询
// $('#findBtn').click(function () {
// 	// 发送GET异步请求
// 	$.ajax({
// 		type: 'GET',
// 		url: '/user/select',
// 		data: {
// 			'search': $('#search').val()
// 		},
// 		success: function (data) {
// 			// 局部刷新数据显示部分的div
// 			$('#userTable').html(data)
// 		},
// 		error: function (err) {
// 			console.log(err)
// 			alert('操作失败，请刷新重新尝试！')
// 		}
// 	})
// })
//
// // 添加
// $('#addSubmitBtn').click(function () {
// 	var username = $('#addUserName').val()
// 	var nickname = $('#addNickname').val()
// 	var password = $("#addPassword").val()
//
// 	// 非空效验
// 	if (username.length == 0){
// 		alert("用户名不能为空")
// 	}else if(nickname.length == 0){
// 		alert("昵称不能为空")
// 	}else if (password.length == 0){
// 		alert("密码不能为空")
// 	}else {
// 		$.ajax({
// 			type: 'POST',
// 			url: '/user/insert',
// 			data: {
// 				'username': username, //用户名
// 				'nickname': nickname, //昵称
// 				'password': password //密码
// 			},
// 			success: function (data) {
// 				// 关闭modal框
// 				$('#modal-form-add').modal('hide')
// 				// 清空modal框里上一次的数据
// 				document.getElementById("addForm").reset()
// 				// 局部刷新
// 				$('#userTable').html(data)
// 			},
// 			error: function (err) {
// 				console.log(err)
// 				alert("操作失败，请刷新重新尝试！")
// 			}
// 		})
// 	}
// })
//
// // 修改提交
// $('#updateSubmitBtn').click(function () {
// 	var id = $('#updateUserId').val()
// 	var username = $('#updateUsername').val()
// 	var nickname = $('#updateNickname').val()
// 	var password = $("#updatePassword").val()
//
// 	if (username.length ==0) {
// 		alert('用户名不能为空')
// 	}else if (nickname.length == 0) {
// 		alert('昵称不能为空')
// 	}else if (password.length == 0) {
// 		alert('密码不能为空')
// 	}else {
// 		$.ajax({
// 			type: 'POST',
// 			url: '/user/update',
// 			data: {
// 				'id': id,
// 				'username': username,
// 				'nickname': nickname,
// 				'password': password
// 			},
// 			success: function (data) {
// 				// 关闭modal框
// 				$('#modal-form-update').modal('hide')
// 				// 清空modal框里上一次的数据
// 				document.getElementById("updateForm").reset()
// 				// 局部刷新
// 				$('#userTable').html(data)
// 			},
// 			error: function (err) {
// 				console.log(err)
// 				alert('操作失败，请刷新重新尝试！')
// 			}
// 		})
// 	}
// })