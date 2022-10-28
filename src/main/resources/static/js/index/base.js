function deleteBtn(id) {
$.ajax({
    type: 'POST',
    url: '/feed/delete',
    data: {
        'id': id
    },
    success: function (data) {
        $('#feed-feedTable').html(data)
    },
    error: function (err) {
        console.log(err)
        alert("操作失败，请刷新重新尝试！")
    }
})
}

function feedIngredient_deleteBtn(id) {
$.ajax({
    type: 'POST',
    url: '/feedIngredient/delete',
    data: {
        'id': id
    },
    success: function (data) {
        $('#FeedIngredientTable').html(data)
    },
    error: function (err) {
        console.log(err)
        alert("操作失败，请刷新重新尝试！")
    }
})
}

function con_deleteBtn(id) {
$.ajax({
    type: 'POST',
    url: '/contract/delete',
    data: {
        'id': id
    },
    success: function (data) {
        $('#feedNutritionTable').html(data)
    },
    error: function (err) {
        console.log(err)
        alert("操作失败，请刷新重新尝试！")
    }
})
}

function metabolism_deleteBtn(id) {
$.ajax({
    type: 'POST',
    url: '/metabolism/delete',
    data: {
        'id': id
    },
    success: function (data) {
        $('#MetabolismTable').html(data)
    },
    error: function (err) {
        console.log(err)
        alert("操作失败，请刷新重新尝试！")
    }
})
}

function word_deleteBtn(id) {
$.ajax({
    type: 'POST',
    url: '/word/delete',
    data: {
        'id': id
    },
    success: function (data) {
        $('#WordTable').html(data)
    },
    error: function (err) {
        console.log(err)
        alert("操作失败，请刷新重新尝试！")
    }
})
}

function microbe_deleteBtn(id) {
$.ajax({
    type: 'POST',
    url: '/microbe/delete',
    data: {
        'id': id
    },
    success: function (data) {
        $('#MicrobeTable').html(data)
    },
    error: function (err) {
        console.log(err)
        alert("操作失败，请刷新重新尝试！")
    }
})
}

// 点击修改按钮
function feed_updateBtn(index, tag, time, nurse, phase1, phase2, phase3, dayofintake) {
// 传递数据到弹出框
alert("hahha")
// $('#feed-modal-form-update').modal = true
$('#feed-updateId').val(index)
$("#feed-updateTag option:selected").val()
$('#feed-updateTag').val(tag)
$('#feed-updateTime').val(time)
$('#feed-updateNurse').val(nurse)
$('#feed-updatePhase1').val(phase1)
$('#feed-updatePhase2').val(phase2)
$('#feed-updatePhase3').val(phase3)
$('#feed-updateDayOfIntake').val(dayofintake)
}
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