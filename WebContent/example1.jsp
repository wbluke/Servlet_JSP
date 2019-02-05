<%-- 
<%@ %> : 페이지에 대한 정보 설정 
<%! %> : 멤버변수 또는 메소드 선언
<% %> : _jspService()내에 그대로 옮겨짐 
<%= %> : _jspService()내에 그대로 옮겨짐. 단, out.print();로 변경됨
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user = request.getParameter("name");
	if(user == null)
		user = "Guest";
	%>
	<h1>
		Hello
		<%=user%>!
	</h1>
</body>
</html>