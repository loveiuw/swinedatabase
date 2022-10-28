// feed增加提交
$('#feed-addSubmitBtn').click(function () {
    //变量
    var feedIndex = $('#feed-addIndex').val()
    var tag = $('#feed-addTag option:selected').val()
    var time = $('#feed-addTime').val()
    var nurse = $('#feed-addNurse').val()
    var phase1 = $('#feed-addPhase1').val()
    var phase2 = $('#feed-addPhase2').val()
    var phase3 = $('#feed-addPhase3').val()
    var dayofintake = $('#feed-addDayOfIntake').val()

    if (tag.length === 0){
        alert("tag is not blank")
    }else if(time.length === 0){
        alert("time is not blank")
    }else if (nurse.length === 0){
        alert("nurse is not blank")
    }else if (phase1.length === 0){
        alert("phase1 is not blank")
    }else if (phase2.length === 0){
        alert("phase2 is not blank")
    }else if (phase3.length === 0){
        alert("phase3 is not blank")
    }else if (dayofintake.length === 0){
        alert("dayofintake is not blank")
    }else {
        $.ajax({
            type: 'POST',
            url: '/table/feed/add',
            data: {
                'tag': tag,
                'time': time,
                'Nurseing_feed_percentage': nurse,
                'Phase_1_feed_percentage': phase1,
                'Phase_2_feed_percentage': phase2,
                'Phase_3_feed_percentage': phase3,
                'day_of_intake': dayofintake,
            },
            success: function (data) {
                // 关闭修改框
                $('#user-modal-form-add').modal('hide')
                // 清空modal框里上一次的数据
                document.getElementById("feed-addForm").reset()
                // 局部刷新
                $('#user-userTable').html(data)
            },
            error: function (err) {
                console.log(err)
                alert('操作失败，请刷新重新尝试！')
            }
        })
    }
})