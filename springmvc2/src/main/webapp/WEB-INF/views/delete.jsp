<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
String msg1 = (String) request.getAttribute("errmsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<%=msg%>
	<%
	}
	%>
	<%
	if (msg1 != null && !msg1.isEmpty()) {
	%>
	<%=msg1%>
	<%
	}
	%>
	<fieldset>
		<form action="./delete" method="get">
			<table>
				<tr>
					<td>id</td>
					<td>:</td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="delete"></td>
				</tr>
			</table>
		</form>

	</fieldset>

</body>
</html>