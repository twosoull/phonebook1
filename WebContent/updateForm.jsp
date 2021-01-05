<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.PhoneDao" %>
<%@ page import="com.javaex.vo.PersonVo" %>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	
 	PhoneDao phonedao = new PhoneDao();
 	PersonVo personvo = phonedao.getPerson(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이영훈 전화번호 수정화면</h1>
	<p>
		수정화면 입니다.
		아래항목을 수정하고 "수정" 버튼을 클릭하세요.
	</p>
	
	<form action ="./update.jsp" method = "get">
	이름(name):<input type = "text" name= "name" value = "<%= personvo.getName()%>"> <br>
	핸드폰(hp):<input type = "text" name = "hp" value = "<%=personvo.getHp() %>"> <br>
	회사(company): <input type = "text" name = "company" value = "<%= personvo.getCompany()%>"> <br>
	코드(id): <input type = "hidden" name = "id" value = "<%=personvo.getPersonId() %>"><br>
	<button type ="submit">수정</button>
	</form>
	
</body>
</html>