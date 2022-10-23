const registerRelation = {Email:["Act", "Psw"], Act:["Email", "Psw"], Psw:["Email", "Act"]};
var bg = document.getElementById('bg');

//1.点击注册时，隐藏登录框，弹出注册窗口
var registerBtn = document.getElementById('register-btn');
registerBtn.onclick = function(){
    login.style.display = 'none';
    register.style.display= "block";
    bg.style.display = "block";
    $("#inputAccountEmpty").css("display", "none");
    $("#inputPasswordEmpty").css("display", "none");
    return false;
}

// 2.点击"关闭",隐藏注册窗口和遮盖层
var closeButton = document.getElementById('closeButton');
closeButton.onclick = function () {
    register.style.display = "none";
    login.style.display = "none";
    bg.style.display = "none";
    return false;
}
//3.阻止跳转
//用户
// function save() {
//     $("#registerBtn").attr("disabled", true);
// // jquery 表单提交
//     $("#register-form").ajaxSubmit(function(message) {
//         alert('用户名或密码错误！');
//         $("#registerBtn").attr("disabled", false);
// // 对于表单提交成功后处理，message为提交页面saveReport.htm的返回内容
//     });
//     return false; // 必须返回false，否则表单会自己再做一次提交操作，并且页面跳转
// }

//为按钮绑定鼠标事件
$("#registerBtn").on("mouseover", {inputType1: "Email", inputType2: "Act", inputType3: "Psw"}, registerBtnMouseOverEvent);
$("#registerBtn").on("mouseout", {inputType1: "Email", inputType2: "Act", inputType3: "Psw"}, registerBtnMouseOutEvent);

//鼠标在注册按钮上时，若其中一项信息为空，登录按钮置灰且提示补全信息；反之改变按钮样式
function registerBtnMouseOverEvent(event) {
    if ($("#input"+event.data.inputType1).val() === "" || $("#input"+event.data.inputType2).val() === "" || $("#input"+event.data.inputType3).val() === "") {
        $("#registerBtn").css("background-color", "grey");
        $("#registerBtn").val("请补全信息");
        $("#registerBtn").css("color", "red");
    } else {
        $("#registerBtn").css("background-color", "#00A1D6");
        $("#registerBtn").css("color", "white");
    }
}
const reginput = document.getElementById('inputPsw');
const regimg = document.getElementById('registereye')
// let flag = 1;
regimg.onclick = function (){
        if(flag==0){
        let text = reginput.value;
        reginput.value = text;
        reginput.type = 'password';
        flag=1;
        regimg.src = "/static/assets/images/icon-img/eye-hide.png";
    }else{
        let psw = reginput.value;
        reginput.value = psw;
        reginput.type = 'text';
        regimg.src = "/static/assets/images/icon-img/eye-show.png";
        flag = 0;
    }
}

// $(document).on('click', '.eye', function(e){
//     if(flag==0){
//         let text = reginput.value;
//         reginput.value = text;
//         reginput.type = 'password';
//         flag=1;
//         regimg.src = "/static/assets/images/icon-img/eye-hide.png";
//     }else{
//         let psw = reginput.value;
//         reginput.value = psw;
//         reginput.type = 'text';
//         regimg.src = "/static/assets/images/icon-img/eye-show.png";
//         flag = 0;
//     }
// });

//鼠标移出时，恢复按钮样式
function registerBtnMouseOutEvent(event) {
    $("#registerBtn").val("注册");
    if ($("#input"+event.data.inputType1).val() === "" || $("#input"+event.data.inputType2).val() === "" || $("#input"+event.data.inputType3).val() === "") {
        $("#registerBtn").css("color", "white");
    } else {
        $("#registerBtn").css("background-color", "white");
        $("#registerBtn").css("color", "#00A1D6");
    }
}

//当输入框为空时，显示提示信息；不为空时，隐藏提示信息，并改变按钮样式
function registerInputNotNull(inputType) {
    if ($("#input"+inputType).val() === "") {
        $("#input"+inputType+"Empty").css("display", "block");
        $("#registerBtn").css("background-color", "grey");
        $("#registerBtn").css("color", "white");
    } else {
        $("#input"+inputType+"Empty").css("display", "none");
        if($("#input"+registerRelation[inputType][0]).val() !== "" && $("#input"+registerRelation[inputType][1]).val() !== "") {
            $("#registerBtn").css("background-color", "white");
            $("#registerBtn").css("color", "#00A1D6");
        }
    }
}

//当输入框失去焦点时触发notNull函数
$("#inputEmail").blur(function () {
    registerInputNotNull("Email");
})
$("#inputAct").blur(function () {
    registerInputNotNull("Act");
})
$("#inputPsw").blur(function () {
    registerInputNotNull("Psw");
})

//若其中一个为空 则阻止表单提交 用户
$("#register-form").submit(function () {
    let act = $("#inputAct").val()
    let psw = $("#inputPsw").val()
    let email = $("#inputEmail").val()
    if (email === "" || act === "" || psw === "") {
        return false
    }
    return true
})
$("#inputEmail").focus(function () {
    $("#inputEmailEmpty").css("display", "none");
})
$("#inputAct").focus(function () {
    $("#inputActEmpty").css("display", "none");
})
$("#inputPsw").focus(function () {
    $("#inputPswEmpty").css("display", "none");
})

//表单提交顺序
// $(function(){
//     var options = {
//         type: 'POST',
//         success:showregister,
//         dataType: 'json',
//         error : function(xhr, status, err) {
//             alert("操作失败");
//         }
//     };
//     $("#register-form").submit(function(){
//         $(this).ajaxSubmit(options);
//         return false;  //防止表单自动提交
//     });
// });
//
// function showregister(responseText){
//     if(responseText.msg == "empty"){
//         alert("信息不全，请检查输入！")
//     }else if (responseText.msg == "userReg"){
//         alert("用户注册成功！")
//         window.location.href="/index";
//     }else {
//         alert('啥也不是');
//     }
// }