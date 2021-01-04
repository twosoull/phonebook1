<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 등록</h1>
	
	<p>전화번호를 등록하려면</p>
	<p>아래 항목을 기입하고 '등록' 버튼을 클릭하세요</p>
	<!--http://localhost:8088/phonebook1/insert.jsp?name=이영훈&hp=010-1111-1111&company=02-2222-2222-->
	<form action ="./insert.jsp" method= "get">
		이름(name): <input type="text" name="name">
		핸드폰(hp): <input type="text" name="hp">
		회사(company): <input type="text" name="company">
		<button type="submit">등록</button>
	</form>
	

</body>
</html>