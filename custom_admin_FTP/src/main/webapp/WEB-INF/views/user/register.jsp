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
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	
	var isValidId = false;
	var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	
	var pattern1 = /[0-9]/;
    var pattern2 = /[a-zA-Z]/;
    var pattern3 = /[~!@\#$%<>^&*]/;
    
	$().ready(function(){
		$(document).on("click", "#btnOverlapped", function(){
			
			$(".answer").empty();
			
			var userId = $("#userId").val();
			
			if(userId == ''){
				alert("ID를 입력해 주세요.");
				$(".answer").append("<p style='color: red;'>" + "ID를 입력해 주세요." + "</p>");
				return;
			}
			if(userId < 6 || userId > 20){
				alert("ID는 6자리 이상 20 이하로 입력해주세요.");
				$(".answer").append("<p style='color: red;'>" + "ID는 6자리 이상 20자리 이하로 입력해주세요." + "</p>");
				return;
			}
			if(userId.search(/\s/) != -1){
				alert("공백은 허용할 수 없습니다.");
				$(".answer").append("<p style='color: red;'>" + "공백은 허용할 수 없습니다." + "</p>");
				return false;
			}//공백 체크
			if(special_pattern.test(userId) == true){
				alert("특수문자는 허용할 수 없습니다.");
				$(".answer").append("<p style='color: red;'>" + "특수문자는 허용할 수 없습니다." + "</p>");
				return false;
				
			}
			
			$.ajax({
				
				type : "get",
				url : "${contextPath}/user/checkDuplicatedId?userId=" + userId,
				success : function(data){
					if(data == "NotDuplicate"){
						alert("사용할 수 있는 ID입니다.");
						$(".answer").append("<p style='color: green;'>" + "사용할 수 있는 ID입니다." + "</p>");
						isValidId = true;
					}else{
						alert("사용할 수 없는 ID입니다.");
						$(".answer").append("<p style='color: red;'>" + "사용할 수 없는 ID입니다." + "</p>");
						isValidId = false;
					}
					
				}		
				
			});
		});
		
		$("form").submit(function(){
			if(isValidId == false){
				alert("아이디를 확인해주세요.");
				return false;
			}
			if($("#password").val() == ''){
				alert("패스워드를 입력해주세요.");
				return false;
			}
			if(isValid == true){
				if($("#password").val() == $("#confirmPasswd").val()){
					if(!pattern1.test($("#password").val())||!pattern2.test($("#password").val())||!pattern3.test($("#password").val())||$("#password").val().length<8||$("#password").val().length>50){
						alert("영문+숫자+특수기호 8자리 이상으로 구성하셔야 합니다.");
						return false;
					}else{
						return true;
					}
				}else{
					alert("패스워드를 다시 확인해주세요.");
					return false;
				}
			}
			
		});
	});

</script>
</head>
<body>
	<form:form method="POST" action="${contextPath }/user/register">
	<p>아이디</p>
		<input type="text" id="userId" name="userId" required="required" placeholder="아이디를 입력해주세요." minlength="6" maxlength="20">
		<input type="button" id="btnOverlapped" value="중복확인">
		<p class="answer"></p>
	<p>이름</p>
		<input type="text" id="userName" name="userName" required="required" placeholder="이름을 입력해주세요.">
	<p>비밀번호</p>
		<input type="password" id="password" name="password" required="required" placeholder="비밀번호를 입력해주세요.">
	<p>비밀번호 확인</p>
		<input type="password" id="confirmPasswd" placeholder="비밀번호 재입력" required="required">
		<button type="submit">회원가입</button>	
	</form:form>
</body>
</html>