// $('.modal').on('hidden.bs.modal', function () {
// 	alert('关闭了')
// });

// feed 监听添加按钮事件
$('#feed-addFeedBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	$('#feed-modal-form-add').modal('show');
})

// feed 查询
$('#feed-findBtn').click(function () {
	// 发送GET异步请求

	$.ajax({
		type: 'GET',
		url: '/feed/select',
		data: {
			'search': $('#feed-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#feed-feedTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// feed 添加
$('#feed-addSubmitBtn').click(function () {
    //变量
	var account = $('#feed-addUaccount').val()
	var name = $('#feed-addUname').val()
	var password = $('#feed-addUpassword').val()
	var sex = $('#feed-addUsex').val()
	var birth = $('#feed-addUbirth').val()
	var phone = $('#feed-addUphone').val()

	// 非空效验
	if (account.length == 0){
		alert("账号不能为空")
	}else if(name.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else if (sex.length == 0){
		alert("性别不能为空")
	}else if (birth.length == 0){
		alert("生日不能为空")
	}else if (phone.length == 0){
		alert("电话不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/feed/insert',
			data: {
				'account': account, //用户名
				'name': name, //昵称
				'password': password, //密码
				'sex': sex,
				'birth': birth,
				'phone': phone,
			},
			success: function (data) {
				// 关闭modal框
				$('#feed-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("feed-addForm").reset()
				// 局部刷新
				$('#feed-feedTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 用户 修改提交 <!--用户修改弹出框：编号，账号，密码，姓名，性别，生日，电话-->
$('#feed-updateSubmitBtn').click(function () {
    //变量
	var id = $('#feed-updateId').val()
	var account = $('#feed-updateUaccount').val()
	var name = $('#feed-updateUname').val()
	var password = $('#feed-updateUpassword').val()
	var sex = $('#feed-updateUsex').val()
	var birth = $('#feed-updateUbirth').val()
	var phone = $('#feed-updateUphone').val()

	if (account.length == 0){
		alert("账号不能为空")
	}else if(name.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else if (sex.length == 0){
		alert("性别不能为空")
	}else if (birth.length == 0){
		alert("出生日期不能为空")
	}else if (phone.length == 0){
		alert("电话不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/feed/update',
			data: {
				'id': id,
				'account': account, //用户名
				'name': name, //昵称
				'password': password, //密码
				'sex': sex,
				'birth': birth,
				'phone': phone,
			},
			success: function (data) {
				// 关闭modal框
				$('#feed-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("feed-updateForm").reset()
				// 局部刷新
				$('#feed-feedTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 管理员 监听添加按钮事件
$('#admin-addFeedBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	$('#admin-modal-form-add').modal('show');
})

// 管理员 查询
$('#admin-findBtn').click(function () {
	// 发送GET异步请求
	$.ajax({
		type: 'GET',
		url: '/admin/select',
		data: {
			'search': $('#admin-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#AdminTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 管理员 添加 <!--管理员增加弹出框：账号，密码，姓名，电话-->
$('#admin-addSubmitBtn').click(function () {
    //变量
	var account = $('#admin-addAaccount').val()
	var name = $('#admin-addAname').val()
	var password = $("#admin-addApassword").val()
	var phone = $("#admin-addAphone").val()

	// 非空效验
	if (account.length == 0){
		alert("账号不能为空")
	}else if(name.length == 0){
		alert("昵称不能为空")
	}else if (password.length == 0){
		alert("密码不能为空")
	}else if (phone.length == 0){
		alert("电话不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/admin/insert',
			data: {
				'account': account, //用户名
				'name': name, //昵称
				'password': password, //密码
				'phone': phone,
			},
			success: function (data) {
				// 关闭modal框
				$('#admin-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("admin-addForm").reset()
				// 局部刷新
				$('#AdminTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 管理员 修改提交 <!--管理员修改弹出框：编号，账号，密码，姓名，电话-->
$('#admin-updateSubmitBtn').click(function () {
    //变量
	var id = $('#admin-updateId').val()
	var account = $('#admin-updateAaccount').val()
	var name = $('#admin-updateAname').val()
	var password = $("#admin-updateApassword").val()
	var phone = $("#admin-updateAphone").val()

	if (account.length ==0) {
		alert('账号不能为空')
	}else if (name.length == 0) {
		alert('昵称不能为空')
	}else if (password.length == 0) {
		alert('密码不能为空')
	}else if (phone.length == 0) {
		alert('电话不能为空')
	}else {
		$.ajax({
			type: 'POST',
			url: '/admin/update',
			data: {
				'id': id,
				'account': account,
				'name': name,
				'password': password,
				'phone': phone,
			},
			success: function (data) {
				// 关闭modal框
				$('#admin-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("admin-updateForm").reset()
				// 局部刷新
				$('#AdminTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 合同 监听添加按钮事件
$('#con-addFeedBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	$('#con-modal-form-add').modal('show');
})

// 合同 查询
$('#con-findBtn').click(function () {
	// 发送GET异步请求
	$.ajax({
		type: 'GET',
		url: '/contract/select',
		data: {
			'search': $('#con-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#ContractTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 合同 添加 <!--合同增加弹出框：房东姓名，租房人姓名，开始时间，结束时间，房子名称-->
$('#con-addSubmitBtn').click(function () {
    //变量
	var uid1 = $('#con-addUID1').val()
	var uid2 = $('#con-addUID2').val()
	var begin = $('#con-addUbegin').val()
	var end = $('#con-addUend').val()
	var hid = $('#con-addHID').val()

	// 非空效验
	if (uid1.length == 0){
		alert("房东不能为空")
	}else if(uid2.length == 0){
		alert("租户不能为空")
	}else if (begin.length == 0){
		alert("开始时间不能为空")
	}else if (end.length == 0){
		alert("结束时间不能为空")
	}else if (hid.length == 0){
		alert("房子ID不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/contract/insert',
			data: {
				'uid1': uid1, //用户名
				'uid2': uid2, //昵称
				'hid': hid,
				'begin': begin,
				'end': end,
			},
			success: function (data) {
				// 关闭modal框
				$('#con-modal-form-add').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("con-addForm").reset()
				// 局部刷新
				$('#ContractTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert("操作失败，请刷新重新尝试！")
			}
		})
	}
})

// 合同 修改提交 <!--合同修改弹出框：合同ID，房东姓名，租房人姓名，开始时间，结束时间，房子ID-->
$('#con-updateSubmitBtn').click(function () {
    //变量
	var id = $('#con-updateId').val()
	var uid1 = $('#con-updateUID1').val()
	var uid2 = $('#con-updateUID2').val()
	var begin = $('#con-updateUbegin').val()
	var end = $('#con-updateUend').val()
	var hid = $('#con-updateHID').val()

	if (uid1.length == 0){
		alert("房东不能为空")
	}else if(uid2.length == 0){
		alert("租户不能为空")
	}else if (begin.length == 0){
		alert("开始时间不能为空")
	}else if (end.length == 0){
		alert("结束时间不能为空")
	}else if (hid.length == 0){
		alert("房子ID不能为空")
	}else {
		$.ajax({
			type: 'POST',
			url: '/contract/update',
			data: {
				'id': id,
				'uid1': uid1,
				'uid2': uid2,
				'begin': begin,
				'end': end,
				'hid': hid,
			},
			success: function (data) {
				// 关闭modal框
				$('#con-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("con-updateForm").reset()
				// 局部刷新
				$('#ContractTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 房屋 监听添加按钮事件
$('#house-addFeedBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	alert("不支持添加房源");
//	$('#house-modal-form-add').modal('show');
})

// 房屋 查询
$('#house-findBtn').click(function () {
	// 发送GET异步请求

	$.ajax({
		type: 'GET',
		url: '/house/search',
		data: {
			'search': $('#house-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#HouseTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 房屋 修改提交 <!--房屋修改弹出框：房子ID，名称，类型，租金，大小，层数，朝向，拥有人编号，点击数，发布日期-->
$('#house-updateSubmitBtn').click(function () {
    //变量
	var id = $('#house-updateId').val()
	var name = $('#house-updateHname').val()
	var kind = $('#house-updateHkind').val()
	var cost = $('#house-updateHcost').val()
	var area = $('#house-updateHarea').val()
	var floor = $('#house-updateHfloor').val()
	var direct = $('#house-updateHdirection').val()
	var owner = $('#house-updateHowner').val()
	var click = $('#house-updateHclick').val()

	if (name.length ==0) {
		alert('房名不能为空')
	}else if (kind.length == 0) {
		alert('类型不能为空')
	}else if (cost.length == 0) {
		alert('价格不能为空')
	}else if (area.length == 0) {
		alert('面积不能为空')
	}else if (floor.length == 0) {
		alert('楼层不能为空')
	}else if (direct.length == 0) {
		alert('朝向不能为空')
	}else if (owner.length == 0) {
		alert('持有人不能为空')
	}else if (click.length == 0) {
        alert('点击数不能为空')
	}else {
		$.ajax({
			type: 'POST',
			url: '/house/update',
			data: {
				'id': id,
				'name': name,
				'kind': kind,
				'cost': cost,
				'area': area,
				'floor': floor,
				'direct': direct,
				'owner': owner,
				'click': click,
			},
			success: function (data) {
				// 关闭modal框
				$('#house-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("house-updateForm").reset()
				// 局部刷新
				$('#HouseTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 留言 监听添加按钮事件
$('#word-addFeedBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	alert("不支持添加留言");
//	$('#word-modal-form-add').modal('show');
})

// 留言 查询
$('#word-findBtn').click(function () {
	// 发送GET异步请求
	$.ajax({
		type: 'GET',
		url: '/word/select',
		data: {
			'search': $('#word-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#WordTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 留言 修改提交 <!--留言修改弹出框：留言编号，留言人编号，日期，点击量-->
$('#word-updateSubmitBtn').click(function () {
    //变量
	var id = $('#word-updateId').val()
	var post = $('#word-updateWpost').val()
	var date = $('#word-updateWdate').val()
	var click = $('#word-updateWclick').val()

	if (post.length ==0) {
		alert('留言人编号不能为空')
	}else if (date.length == 0) {
		alert('日期不能为空')
	}else if (click.length == 0) {
		alert('点击量不能为空')
	}else {
		$.ajax({
			type: 'POST',
			url: '/word/update',
			data: {
				'id': id,
				'post': post,
				'date': date,
				'click': click,
			},
			success: function (data) {
				// 关闭modal框
				$('#word-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("word-updateForm").reset()
				// 局部刷新
				$('#WordTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})



// 新闻 监听添加按钮事件
$('#news-addFeedBtn').click(function() {
	// 添加按钮被点击之后，展示modal框
	alert("不支持发布新闻公告");
//	$('#news-modal-form-add').modal('show');
})

// 新闻 查询
$('#news-findBtn').click(function () {
	// 发送GET异步请求
	$.ajax({
		type: 'GET',
		url: '/news/select',
		data: {
			'search': $('#news-search').val()
		},
		success: function (data) {
			// 局部刷新数据显示部分的div
			$('#NewsTable').html(data)
		},
		error: function (err) {
			console.log(err)
			alert('操作失败，请刷新重新尝试！')
		}
	})
})

// 新闻 修改提交 <!--新闻修改弹出框：新闻编号，发布人编号，新闻标题，发布日期，点击量-->
$('#news-updateSubmitBtn').click(function () {
    //变量
	var id = $('#news-updateId').val()
	var post = $('#news-updateNpost').val()
	var header = $('#news-updateNheader').val()
	var date = $('#news-updateNdate').val()
	var click = $('#news-updateNclick').val()

	if (post.length ==0) {
		alert('发布人不能为空')
	}else if (header.length == 0) {
		alert('新闻标题不能为空')
	}else if (date.length == 0) {
		alert('发布日期不能为空')
	}else if (click.length == 0) {
		alert('点击量不能为空')
	}else {
		$.ajax({
			type: 'POST',
			url: '/news/update',
			data: {
				'id': id,
				'post': post,
				'header': header,
				'date': date,
				'click': click,
			},
			success: function (data) {
				// 关闭modal框
				$('#news-modal-form-update').modal('hide')
				// 清空modal框里上一次的数据
				document.getElementById("news-updateForm").reset()
				// 局部刷新
				$('#NewsTable').html(data)
			},
			error: function (err) {
				console.log(err)
				alert('操作失败，请刷新重新尝试！')
			}
		})
	}
})