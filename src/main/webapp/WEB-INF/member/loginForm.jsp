<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>로그인</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/loginForm.css"/>
    <script>
	function login() {
		if (form.memberId.value == "") {
			alert("사용자 ID를 입력하십시오.");
			form.memberId.focus();
			return false;
		} 
		if (form.password.value == "") {
			alert("비밀번호를 입력하십시오.");
			form.password.focus();
			return false;
		}		
		form.submit();
	}
</script>
</head>

<body id="loginBg">
	<div id="loginWrap">
        <div id="loginTit">PIT A PET</div>
        <form name="form" method="POST" action="<c:url value='/member/login' />">
	        <input type="text" placeholder="아이디" id="loginId" name="memberId" />
	        <input type="text" placeholder="비밀번호" id="loginPwd" name="password" />
	        <input type="button" id="loginBtn" value="로그인" onClick="login()">
        </form>
        <div id="joinLinkWrap">아직 회원이 아니신가요? <a href="#" id="joinLink">회원가입</a></div>
    </div>
</body>
</html>