<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>������ web MVC�����ϱ�</h1>
	<hr/>
	<h3>jsp�� �ڵ� ����ϱ� : <%=request.getAttribute("msg") %></h3>
	<h3>EL(expression language)�� ����ϱ� : ${msg}</h3>
	<h4>WEB-INF�ؿ� �ָ� ������ �ȵȴ�. ����ڰ� �Է��ؼ� ���ͼ� View�� ����Ǹ� �ȵǱ� ������,
		WEB-INF�ؿ� �ΰ� ��η� �νĽ��� �۾��ϴ� �� �Ϲ����̴�.</h4>

</body>
</html>