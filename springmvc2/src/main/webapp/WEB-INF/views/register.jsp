<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
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
	<% if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<%=errMsg%>
	<%
	}
	%>
	
	<fieldset>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>id</td>
					<td>:</td>
					<td><input type="number" name="id" required="required">
				</tr>
				<tr>
					<td>name</td>
					<td>:</td>
					<td><input type="text" name="name" required="required">
				</tr>
				<tr>
					<td>dob</td>
					<td>:</td>
					<td><input type="date" name="dob" required="required">
				</tr>
				<tr>
					<td>password</td>
					<td>:</td>
					<td><input type="password" name="password" required="required">
				</tr>
				<tr>
					<td><input type="submit" value="register"></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>