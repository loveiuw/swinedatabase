const forgetRelation = {forgetAct: ["forgetPsw", "forgetPsw2", "inputNumber"], forgetPsw: ["forgetAct", "forgetPsw2", "inputNumber"],
    forgetPsw2: ["forgetAct", "forgetPsw", "inputNumber"], inputNumber: ["forgetAct", "forgetPsw", "forgetPsw2"]};
var bg = document.getElementById('bg');
var forget = document.getElementById('forget')
var forgetBtn = document.getElementById('forget-btn');
var doSubmit = true;
var runTimes = 60;
forgetBtn.onclick = function(){
    login.style.display = "none";
    register.style.display = "none"
    forget.style.display = "block";
    bg.style.display = "block";
    $("#inputAccountEmpty").css("display", "none");
    $("#inputPasswordEmpty").css("display", "none");
    $("#inputPassword").val("");
    $("#loginBtn").css("background-color", "grey");
    $("#loginBtn").css("color", "white");
    var usertype = document.getElementById('forgetRole');
    usertype.value = $("#loginRole").val();
    return false;
}

//返回登录
var returnLoginBtn = document.getElementById('returnLoginBtn');
returnLoginBtn.onclick = function () {
    login.style.display = "block";
    bg.style.display = "block";
    forget.style.display = "none";
    register.style.display = "none";
    $("#forgetActEmpty").css("display", "none");
    $("#forgetPswEmpty").css("display", "none");
    $("#passwordErr").css("display", "none");
    $("#inputNumberEmpty").css("display", "none");
    $("#forgetAct").val("");
    $("#forgetPsw").val("");
    $("#forgetPsw2").val("");
    $("#inputNumber").val("");
    $("#forgetBtn").css("background-color", "grey");
    $("#forgetBtn").css("color", "white");
    return false;
}
// 2.点击"关闭",隐藏登陆窗口和遮盖层
var close = document.getElementById('close');
close.onclick = function () {
    register.style.display = "none";
    login.style.display = "none";
    bg.style.display = "none";
    forget.style.display = "none";
    return false;
}

//为按钮绑定鼠标事件
$("#forgetBtn").on("mouseover", {inputType1: "Act", inputType2: "Psw"}, forgetBtnMouseOverEvent);
$("#forgetBtn").on("mouseout", {inputType1: "Act", inputType2: "Psw"}, forgetBtnMouseOutEvent);

//鼠标在登录按钮上时，若其中一项信息为空，登录按钮置灰且提示补全信息；反之改变按钮样式
function forgetBtnMouseOverEvent(event) {
    if ($("#forget"+event.data.inputType1).val() === "" || $("#forget"+event.data.inputType2).val() === ""
        || $("#forget"+event.data.inputType2+"2").val() === "" || $("#inputNumber").val() === "") {
        $("#forgetBtn").css("background-color", "grey");
        $("#forgetBtn").val("请补全信息");
        $("#forgetBtn").css("color", "red");
    } else {
        $("#forgetBtn").css("background-color", "#35b852");
        $("#forgetBtn").css("color", "white");
    }
}

const forinput = document.getElementById('forgetPsw');
const forimg = document.getElementById('forimg')
const forinput2 = document.getElementById('forgetPsw2');
const forimg2 = document.getElementById('forimg2')

forimg.onclick = function (){
    if(flag==0){
        let text = forinput.value;
        forinput.value = text;
        forinput.type = 'password';
        flag=1;
        forimg.src = "/assets/images/icon-img/eye-hide.png";
    }else{
        let psw = forinput.value;
        forinput.value = psw;
        forinput.type = 'text';
        forimg.src = "/assets/images/icon-img/eye-show.png";
        flag = 0;
    }
}
forimg2.onclick = function (){
    if(flag==0){
        let text = forinput2.value;
        forinput2.value = text;
        forinput2.type = 'password';
        flag=1;
        forimg2.src = "/assets/images/icon-img/eye-hide.png";
    }else{
        let psw = forinput2.value;
        forinput2.value = psw;
        forinput2.type = 'text';
        forimg2.src = "/assets/images/icon-img/eye-show.png";
        flag = 0;
    }
}
//鼠标移出时，恢复按钮样式
function forgetBtnMouseOutEvent(event) {
    $("#forgetBtn").val("修改");
    if ($("#forget"+event.data.inputType1).val() === "" || $("#forget"+event.data.inputType2).val() === ""
        || $("#forget"+event.data.inputType2+"2").val() === "" || $("#inputNumber").val() === "") {
        $("#forgetBtn").css("color", "white");
    } else {
        $("#forgetBtn").css("background-color", "white");
        $("#forgetBtn").css("color", "#35b852");
    }
}

//当输入框为空时，显示提示信息；不为空时，隐藏提示信息，并改变按钮样式
function forgetInputNotNull(inputType) {
    if(inputType === "forgetPsw2") {
        if ($("#" + inputType).val() === "") {
            if($("#" + forgetRelation[inputType][1]).val() === "") {
                $("#passwordErr").text("请先输入密码");
            } else {
                $("#passwordErr").text("两次输入密码不一致");
            }
            $("#passwordErr").css("display", "block");
            $("#forgetBtn").css("background-color", "grey");
            $("#forgetBtn").css("color", "white");
        } else {
            if ($("#" + inputType).val() !== $("#" + forgetRelation[inputType][1]).val()) {
                $("#passwordErr").text("两次输入密码不一致");
                $("#passwordErr").css("display", "block");
                return false;
            }
            $("#passwordErr").css("display", "none");
            if ($("#" + forgetRelation[inputType][0]).val() !== "" && $("#" + forgetRelation[inputType][1]).val() !== ""
                && $("#" + forgetRelation[inputType][2]).val() !== "") {
                $("#forgetBtn").css("background-color", "white");
                $("#forgetBtn").css("color", "#35b852");
            }
        }
    } else {
        if ($("#" + inputType).val() === "") {
            $("#" + inputType + "Empty").css("display", "block");
            $("#forgetBtn").css("background-color", "grey");
            $("#forgetBtn").css("color", "white");
        } else {
            $("#" + inputType + "Empty").css("display", "none");
            if ($("#" + forgetRelation[inputType][0]).val() !== "" && $("#" + forgetRelation[inputType][1]).val() !== ""
                && $("#" + forgetRelation[inputType][2]).val() !== "") {
                $("#forgetBtn").css("background-color", "white");
                $("#forgetBtn").css("color", "#35b852");
            }
        }
    }
}

//当输入框失去焦点时触发notNull函数
$("#forgetAct").blur(function () {
    forgetInputNotNull("forgetAct");
})
$("#forgetPsw").blur(function () {
    forgetInputNotNull("forgetPsw");
})
$("#forgetPsw2").blur(function () {
    forgetInputNotNull("forgetPsw2");
})
$("#inputNumber").blur(function () {
    forgetInputNotNull("inputNumber");
})

//若邮箱和密码其中一个为空或第二次密码与第一次不同，则显示错误信息并阻止表单提交
function checkIfNull(act, psw, psw2) {
    if (act === "" || psw === "") {
        return false;
    }
    if (psw2 !== psw) {
        $("#passwordErr").text("两次输入密码不一致");
        $("#passwordErr").css("display", "block");
        return false;
    }
    return true;
}

$("#forgetAct").focus(function () {
    $("#forgetActEmpty").css("display", "none");
})
$("#forgetPsw").focus(function () {
    $("#forgetPswEmpty").css("display", "none");
})
$("#forgetPsw2").focus(function () {
    $("#passwordErr").css("display", "none");
})

//验证码
$("#getCheckNode").click(function () {
    let act = $("#forgetAct").val();
    let role = $("#forgetRole").val();

    $.ajax({
        url: "/getCheckNodeServlet",
        type: "GET",
        data: {"act":act,"role":role},
        dataType: "JSON",
        success: function (json) {

        },
        error: function (xhr) {

        }
    });

    if(doSubmit) {
        $("#getCheckNode").css("background-color", "grey");
        $("#getCheckNode").attr("disabled", true);
    }
    doSubmit = doSubmit && false;
    let startInterval = setInterval(function() {
        if (runTimes === 0) {
            doSubmit = true;
            runTimes = 60;
            $("#getCheckNode").text("获取验证码");
            $("#getCheckNode").css("background-color", "#35b852");
            $("#getCheckNode").attr("disabled", false);
            clearInterval(startInterval);
        } else {
            $("#getCheckNode").text(runTimes+"秒后重试");
            runTimes--;
        }
    }, 1000);
});


$("#forgetBtn").click(function () {
    $("#forgetBtn").attr("disabled", true);
    let act = $("#forgetAct").val();
    let password = $("#forgetPsw2").val();
    let checkNode = $("#inputNumber").val();
    let role = $("#forgetRole").val();

    if (checkIfNull(act, $("#forgetPsw").val(), password)) {
        $.ajax({
            url: "/forgetPwdServlet",
            type: "POST",
            data: {"act": act, "pwd": password, "checkNode": checkNode, "role": role},
            dataType: "JSON",
            complete: function (xhr) {
                let response = $.parseJSON(xhr.responseText);
                alert(response["info"]);
                $("#forgetBtn").attr("disabled", false);
            },
            fail: function (xhr) {
                $("#forgetBtn").attr("disabled", false);
            }
        });
    }
});
