<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.javaex.vo.PersonVo" %>
<%@ page import = "com.javaex.dao.PhoneDao" %>
    
<%
//http://localhost:8088/phonebook1/insert.jsp?name=이영훈hp=010-1111-1111&company=02-2222-2222
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	
	PersonVo personVo = new PersonVo(name,hp,company);
	PhoneDao phonedao = new PhoneDao();
	/*저장*/
	phonedao.phoneInsert(personVo);
	
	/*리스트*/
	response.sendRedirect("./list.jsp"); //페이지가 열리면 자동으로 페이지가 작동된다.
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>