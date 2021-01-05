<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.dao.PhoneDao" %>
<%@ page import = "com.javaex.vo.PersonVo" %>
<%
	String name = request.getParameter("name");
	String hp = request.getParameter("hp");
	String company = request.getParameter("company");
	int id = Integer.parseInt(request.getParameter("id"));
	
	PersonVo personVo = new PersonVo(id, name,hp,company);
	PhoneDao phoneDao = new PhoneDao();
	
	phoneDao.phoneUpdate(personVo);
	
	response.sendRedirect("./list.jsp");
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 변경되었습니다.
</body>
</html>