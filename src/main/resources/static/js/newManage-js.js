// 控制后台系统左侧菜单点击导致右侧框的不同显示

var adminBtn = document.getElementById("-adminBtn");
var userBtn = document.getElementById("-userBtn");
var newsBtn = document.getElementById("-newsBtn");
var houseBtn = document.getElementById("-houseBtn");
var conBtn = document.getElementById("-conBtn");
var mesBtn = document.getElementById("-mesBtn");

var adminbox = document.getElementById("adminbox");
var userbox = document.getElementById("userbox");
var newsbox = document.getElementById("newsbox");
var housebox = document.getElementById("housebox");
var conbox = document.getElementById("conbox");
var mesbox = document.getElementById("mesbox");


window.onload = function(){
    adminbox.style.display = "none";
    userbox.style.display = "block";
    newsbox.style.display = "none";
    housebox.style.display = "none";
    conbox.style.display = "none";
    mesbox.style.display = "none";
}
adminBtn.onclick = function() {
    adminbox.style.display = "block";
    userbox.style.display = "none";
    newsbox.style.display = "none";
    housebox.style.display = "none";
    conbox.style.display = "none";
    mesbox.style.display = "none";
    return false;
}

userBtn.onclick = function() {
    adminbox.style.display = "none";
    userbox.style.display = "block";
    newsbox.style.display = "none";
    housebox.style.display = "none";
    conbox.style.display = "none";
    mesbox.style.display = "none";
    return false;
}
newsBtn.onclick = function() {
    adminbox.style.display = "none";
    userbox.style.display = "none";
    newsbox.style.display = "block";
    housebox.style.display = "none";
    conbox.style.display = "none";
    mesbox.style.display = "none";
    return false;
}
houseBtn.onclick = function() {
    adminbox.style.display = "none";
    userbox.style.display = "none";
    newsbox.style.display = "none";
    housebox.style.display = "block";
    conbox.style.display = "none";
    mesbox.style.display = "none";
    return false;
}
conBtn.onclick = function() {
    adminbox.style.display = "none";
    userbox.style.display = "none";
    newsbox.style.display = "none";
    housebox.style.display = "none";
    conbox.style.display = "block";
    mesbox.style.display = "none";
    return false;
}
mesBtn.onclick = function() {
    adminbox.style.display = "none";
    userbox.style.display = "none";
    newsbox.style.display = "none";
    housebox.style.display = "none";
    conbox.style.display = "none";
    mesbox.style.display = "block";
    return false;
}