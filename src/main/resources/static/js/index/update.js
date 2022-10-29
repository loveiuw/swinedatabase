// feed修改提交
$('#feed-updateSubmitBtn').click(function () {
    //变量
    alert('开始修改')
    var feedIndex = $('#feed-updateId').val()
    var tag = $('#feed-updateTag option:selected').val()
    var time = $('#feed-updateTime').val()
    var nurse = $('#feed-updateNurse').val()
    var phase1 = $('#feed-updatePhase1').val()
    var phase2 = $('#feed-updatePhase2').val()
    var phase3 = $('#feed-updatePhase3').val()
    var dayofintake = $('#feed-updateDayOfIntake').val()

    console.log(feedIndex) //打印值
    // $("#table-edit")
    // if (tag.length === 0){
    //     alert("tag is not blank")
    // }else if(time.length === 0){
    //     alert("time is not blank")
    // }else if (nurse.length === 0){
    //     alert("nurse is not blank")
    // }else if (phase1.length === 0){
    //     alert("phase1 is not blank")
    // }else if (phase2.length === 0){
    //     alert("phase2 is not blank")
    // }else if (phase3.length === 0){
    //     alert("phase3 is not blank")
    // }else if (dayofintake.length === 0){
    //     alert("dayofintake is not blank")
    // }else {
    //     $.ajax({
    //         type: 'POST',
    //         url: '/table/feed/update',
    //         data: {
    //             'feedIndex': feedIndex,
    //             'tag': tag,
    //             'time': time,
    //             'Nurseing_feed_percentage': nurse,
    //             'Phase_1_feed_percentage': phase1,
    //             'Phase_2_feed_percentage': phase2,
    //             'Phase_3_feed_percentage': phase3,
    //             'day_of_intake': dayofintake,
    //         },
    //         success: function (data) {
    //             // 关闭修改框
    //             $('#user-modal-form-update').modal('hide')
    //             // 清空modal框里上一次的数据
    //             document.getElementById("user-updateForm").reset()
    //             // 局部刷新
    //             $('#user-userTable').html(data)
    //         },
    //         error: function (err) {
    //             console.log(err)
    //             alert('操作失败，请刷新重新尝试！')
    //         }
    //     })
    // }
})