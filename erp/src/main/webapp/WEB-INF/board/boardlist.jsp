<%@page import="multi.erp.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">

//자바스크립트에서 자바에서 발생한 발생한 데이터를 사용 - EL
//${category} => request.getAttribute("category")
	category = "${category}"//컨트롤러 요청하고 response될 때 값을 받아서 세팅
	//게시판 위에 분류 값이 게시판에 맞게 선택되어 노출되는 작업. 
	$(document).ready(function() {
		//최초실행인 경우 category값은 없으니
		if(category==""){
			category="all";
		}
			$("#category").val(category).attr("selected", "selected")
				//셀렉티드에 셀렉티드 하면 해당 내용이 선택이 된다. 
			$("#category").change(function() { //category가 change되면, 
					location.href = "/erp/board/list.do?category="
									+ encodeURI($(this).val())
					//board/list.do가 실행되고, 파라미터(카테고리)를 넘겨준다.
					//value를 넘겨서 읽어주는 작업, 하나를 고정할 순 없고 그때마다 값이 달라지기 때문에 this키워드를 이용한다.
					//val()메소드를 사용하면 value값을 읽어온다.

			});
	});
</script>
</head>
<body>
	<%
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) request.getAttribute("boardlist");
	%>
	<!-- attribute에서 꺼내오는작업 -->
	<h3>JSTL게시판</h3>
	<div style="padding-top: 30px">
		<div class="col-md-3" style="padding-bottom: 10px">
			구분:
			<form>
				<select name="category" id="category">
					<option value="all">전체게시물</option>
					<option value="경조사">경조사</option>
					<option value="사내소식">사내소식</option>
					<option value="게시판">게시판</option>
				</select>
			</form>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (int i = 0; i < list.size(); i++) {
						BoardVO row = list.get(i);
				%>
				<tr>
					<td><%=row.getBoard_no()%></td>
					<td><%=row.getTitle()%></td>
					<td><%=row.getId()%></td>
					<td><%=row.getWrite_date()%></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<form action="/erp/board/search.do">
		<select name="tag">
			<option value="id">작성자</option>
			<option value="title">제목</option>
			<option value="content">본문</option>
			<option value="write_date">작성일</option>
		</select> <input type="text" name="search" /> <input type="submit" value="검색">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/erp/board/write.do" style="text-align: right;">글쓰기</a></li>
		</ul>
	</form>

</body>
</html>
