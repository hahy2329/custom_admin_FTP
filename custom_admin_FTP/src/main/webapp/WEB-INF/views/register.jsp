<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>
	
	var isValidId = false;
	var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	
	$().ready(function(){
		$("#btnOverlapped").click(function(){
			
			var userName = $("#userName").val();
			
			if(userName == ''){
				alert("ID를 입력해 주세요.");
				return;
			}
			if(userName.search(/\s/) != -1){
				alert("공백은 허용할 수 없습니다.");
				return false;
			}//공백 체크
			if(special_pattern.test(userName) == true){
				alert("특수문자는 허용할 수 없습니다.");
				return false;
				
			}
			
			$.ajax({
				
				type : "get",
				url : "{contextPath}/user/checkDuplicatedId?userName=" + userName,
				success : function(data){
					if(data == "NotDuplicate"){
						alert("사용할 수 있는 ID입니다.");
						isValidId = true;
					}else{
						alert("사용할 수 없는 ID입니다.")ㅣ
						isValidId = false;
					}
					
				}		
				
			});
		});
	});

</script>
</head>
<body>
	<p>아이디</p>
		<input type="text" id="userId" name="userId" required="required" placeholder="아이디를 입력해주세요.">
		<input type="button" id="btnOverlapped" value="중복확인">
	<p>이름</p>
		<input type="text" id="userName" name="userName" required="required" placeholder="이름을 입력해주세요.">
	
</body>
</html>