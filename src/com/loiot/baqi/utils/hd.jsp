<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
                <div class="ssdjb_wrap">
                    <div class="ssztmc">
                        <input class="ss_name"  id="user" type="text" value="用户名" onfocus="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#cccccc'}" />
                    </div>
                     <div class="ssztmc">
                        <input class="ss_name"  id="pwd" type="text" value="密码" onfocus="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#cccccc'}" />
                    </div>
                    <div class="sszt_yzm">
                        <input name="captcha" id="yzm" type="text" value="验证码" onfocus="if(value==defaultValue){value='';this.style.color='#000'}" onblur="if(!value){value=defaultValue;this.style.color='#cccccc'}" />
                        <div class="yzm_pic">
                            <img src="<%=path %>/getHdYzm" width="185" height="35" alt="" id="rndImg" /></div>
                        <div class="sszt_btn">
                            <button  id="btn">登陆</button></div>
                    </div>
                </div>
<script type="text/javascript">
$("#rndImg").click(function(){
  $("#rndImg").attr("src","<%=path %>/getHdYzm?key="+Math.random());
});
$(function(){
	$("#btn").click(function(){
		var user = $("#user").val();
		var pwd = $("#pwd").val();
		var yzm = $("#yzm").val();
		if(user == ''){
			alert("用户名不能为空");
		}else if(pwd == ''){
			alert("密码不能为空");
		}else if(yzm == ''){
			alert("验证码不能为空");
		}else{
			$.ajax({
				url:'<%=path %>/hdLogin',
				type:'GET',
				data:{
					user:user,
					pwd:pwd,
					yzm:yzm
				},
				dataType:'text',
				success:function(text){
					alert(text);
				}
			})
		}
		
	});
});
</script>
</body>
</html>
