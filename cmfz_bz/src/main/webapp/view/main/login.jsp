<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="../../img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="../../css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="../../css/login.css" type="text/css"></link>
	<script type="text/javascript" src="../../script/jquery.js"></script>
	<script type="text/javascript" src="../../script/common.js"></script>
	<script type="text/javascript">

        $(function(){
            $("#username").live("blur",checkUsername);
            $("#password").live("blur",checkPassword);
        });
        function checkUsername() {
            var email = $("#username").val();
            if(email.length == 0){
                alert("请输入用户名");
                return false;
            }else {
                return true;
            }
        }

        function checkPassword(){
            var password = $("#password").val();
            if(password.length == 0){
                alert("请输入密码");
                return false;
            }else{
                return true;
            }
        }

        function checkForm(){
            var emailInfo = checkUsername();
            var passwordInfo = checkPassword();
            if(emailInfo && passwordInfo){
                return true;
            }else{
                return false;
            }
        }
	</script>
</head>
<body>
	<div style="color: #00bbee;text-align:center ">
		<h1>持明法州后台登录页面</h1>
	</div>
	<div class="login">
		<form id="loginForm" action="${pageContext.request.contextPath}/admin/login.do" method="post" >

			<table>
				<tbody>
					<tr>
						<td width="190" rowspan="2" align="center" valign="bottom">
							<img src="../../img/header_logo.gif" />
						</td>
						<th>
							用户名:
						</th>
						<td>
							<input id="username" type="text"  name="username" class="text" value="xxx" maxlength="20"/>
						</td>
				  </tr>
				  <tr>
						<th>
							密&nbsp;&nbsp;&nbsp;码:
						</th>
						<td>
							<input id="password" type="password" name="password" class="text" value="xxx" maxlength="20" autocomplete="off"/>
						</td>
				  </tr>

					<tr>
						<td>&nbsp;</td>
						<th>验证码:</th>
						<td>
							<input type="text" id="enCode" name="enCode" class="text captcha" maxlength="4" autocomplete="off"/>
							<img id="captchaImage" class="captchaImage"
								 src="${pageContext.request.contextPath}/code/createCode.do"
								 onclick="this.src='${pageContext.request.contextPath}/code/createCode.do?change='+Math.random()"
								 title="点击更换验证码"/>
						</td>
					</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<th>
						&nbsp;
					</th>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<th>&nbsp;</th>
					<td>
						<input type="button" class="homeButton" value="" onclick=""><input type="submit" class="loginButton" value="登录">
					</td>
				</tr>
			</tbody></table>
			<div class="powered">COPYRIGHT © 2008-2017.</div>
			<div class="link">
				<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
				<a href="http://www.chimingbbs.com/">交流论坛</a> |
				<a href="">关于我们</a> |
				<a href="">联系我们</a> |
				<a href="">授权查询</a>
			</div>
		</form>
	</div>
</body>
</html>