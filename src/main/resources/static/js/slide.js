window.onload = function(){
    // alert("你好")
    // 获取ul
    var imgList = document.getElementById("imglist");
    // 获取所有img标签
    var imgArr = document.getElementsByClassName("slide-img");
    // 获取所有的a标签
    var allA = document.getElementsByClassName("slide-a");
    // 设置默认的图片的索引
    var index = 1;
    // 设置默认的选中效果
    allA[index].style.backgroundColor = "black";
    // 点击超链接对应到指定的图片
    // 为所有的超链接绑定函数
    for(var i=0; i<allA.length; i++){
        //为每一个超链接加一个num属性
        allA[i].num = i;
        allA[i].onclick = function(){
            //获取图片的索引，并将其设置为index
            index = this.num;
            // 切换图片
            // imgList.style.left = -1005*index + "px";
            setA();
            //使用move函数切换图片
            move(imgList, "left", -1004*index, 20 ,function(){

            });
            
            

        }
    }// 先执行for循环再执行单机响应
    //修改正在选中的超链接效果
    function setA(){
        // 遍历所有的a,并将它们的设置为原色
        for(var i=0; i<allA.length; i++){
            allA[i].style.backgroundColor = "aqua";
        }
        // 选中的index设置为特定的颜色
        allA[index].style.backgroundColor = "red";
    };
    autoChange();
    // 创建一个函数来自动切换
    function autoChange(){
        setInterval(function(){
            index++;
            if(index==5){
                index=0;
                imgList.style.left = -1005*index + "px";
            }
            move(imgList, "left", -1004*index, 20 ,function(){

            });
            setA();
        },3000)// 3秒换一次
    }
function move(obj, attr, target, speed, callback) {
	clearInterval(obj.timer);
	var current = parseInt(getStyle(obj, attr));
	//判断速度的正负值
	if (current > target) {
		speed = -speed;
	}
	//向执行动画的对象中添加一个timer属性，用来保存自己的定时器的标识
	obj.timer = setInterval(function() {
		var oldValue = parseInt(getStyle(obj, attr));
		//在旧值的基础上增加
		var newValue = oldValue + speed;
		//如果往左移，需要判断newValue是否小于0
		if ((speed < 0 && newValue < target) || (speed > 0 && newValue > target)) {
			newValue = target;
		}
		obj.style[attr] = newValue + "px";
		if (newValue == target) {
			clearInterval(obj.timer);
			callback && callback();
		}
	}, 30);
}


//定义一个函数，用来获取指定元素的当前的样式
//参数： obj 要获取样式的元素    name 要获取的样式名
    function getStyle(obj, name) {
        //现实是函数没有，找全局，没有就报错
        //加window后，变成属性，属性没有返回Undefined
        if (window.getComputedStyle) {
            //正常浏览器方式

            return getComputedStyle(obj, null)[name];
        } else {
            //IE8的方式
            return obj.currentStyle[name];
        }
    }

//来刷新界面用户数据
    var spanValue = document.getElementById("login-after").innerHTML;
    // alert(spanValue);
    if(spanValue == 'null你好,欢迎光临本站！'){
        // alert('是空的哈哈哈')
        // alert(spanValue);
        $("#head-wel-login-before").css("display", "block");
        $("#head-wel-login-after").css("display", "none");
    }else{
        // alert('你好呀');
        $("#head-wel-login-before").css("display", "none");
        $("#head-wel-login-after").css("display", "block");
    }

}