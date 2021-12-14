<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>돌보미 지원 정보 확인</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Righteous&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/header.css"/>
    <link rel="stylesheet" href="/css/footer.css"/>
	<link rel="stylesheet" href="/css/sitterApplyForm.css"/>
</head>

<body>
	<%@include file="../components/header.jsp" %>
    
    <div id="pageWrap">
        <div id="pageTit">돌보미 지원 정보 확인</div>
        
        <div id="introTit">자기소개</div>
        <div id="introTextWrap">
            <input type="text" name="introduction" value="${applicationInfo.introduction}"/>
        </div>

        <div id="infoTit">돌보미 경력</div>
        <div id="infoContent">
        	<input type="text" name="career" value="${applicationInfo.career}"/>
        </div>

        <div id="infoTit">자격증</div>
        <div id="infoContent">
        	<input type="text" name="certification" value="${applicationInfo.certification}" />
        </div>

        <div id="btnWrap">
        	<c:url value='/member/sitterApplyCancel' var="cancelUrl">
        		<c:param name="applyId" value="${applicationInfo.id}" />
        	</c:url>
            <button id="applyBtn" onclick="location.href='${cancelUrl}'">지원 취소</button>
            <c:url value='/member/memberMyPage' var="returnUrl"/>
            <button id="applyBtn" onclick="location.href='${returnUrl}'">돌아가기</button>
        </div>
    </div>
    
    <div id="footerWrap">
        <div id="footerText">Copyrights © 2021 by 윤김구이. All Rights Reserved.</div>
    </div>
</body>
</html>
