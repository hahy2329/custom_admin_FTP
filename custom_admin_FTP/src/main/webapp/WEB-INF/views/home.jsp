<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Home</title>
</head>

<body>
<h1>Home!</h1>
<sec:authorize access="isAnonymous()">
<p><a href="<c:url value="/login/loginForm.do" />">로그인</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<form:form action="{contextPath}/logout" method="POST">
	<input type="submit" value="로그아웃"/>
</form:form> 
</sec:authorize>

<h3>
	[<a href="<c:url value="/intro/introduction.do"/>">소개 글</a>]
	[<a href="<c:url value="/user/register"/>">유저 회원가입</a>]
	[<a href="<c:url value="/admin/adminPage"/>">관리자 페이지</a>]
	[<a href="<c:url value="/ftpService"/>">파일 다운로드</a>]
</h3>
</body>
</html>
