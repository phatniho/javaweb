<%@ page language="java"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<h1>
		<%=new Date()%>
		<br />
		<%
			for (int i = 0; i < 5; i++) {
				out.write("Hello JSP<br />");
			}
		%>
		<br />
		<%
			for (int i = 0; i < 5; i++) {
		%>
		Hello JSP<br />
		<%
			}
		%>
	</h1>
</body>
</html>