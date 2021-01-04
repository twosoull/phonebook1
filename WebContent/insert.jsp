<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.vo.PersonVo" %>
<%@ page import = "com.javaex.dao.PhoneDao" %>
    
<%
//http://localhost:8088/phonebook1/insert.jsp?name=이영훈hp=010-1111-1111&company=02-2222-2222
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	
	PersonVo personVo = new PersonVo(name,hp,company);
	PhoneDao phonedao = new PhoneDao();
	
	phonedao.phoneInsert(personVo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	등록 요청 완료 ^^
</body>
</html>