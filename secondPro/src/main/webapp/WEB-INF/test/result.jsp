<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스프링 web MVC구축하기</h1>
	<hr/>
	<h3>jsp로 코드 출력하기 : <%=request.getAttribute("msg") %></h3>
	<h3>EL(expression language)로 출력하기 : ${msg}</h3>
	<h4>WEB-INF밑에 주면 실행이 안된다. 사용자가 입력해서 들어와서 View가 실행되면 안되기 때문에,
		WEB-INF밑에 두고 경로로 인식시켜 작업하는 게 일반적이다.</h4>

</body>
</html>