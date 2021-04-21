<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%
String message = (String) request.getAttribute("msg");
String errmsg = (String) request.getAttribute("errorMsg");
int id = (int) request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	if (message != null && !message.isEmpty()) {
	%>
	<h1 style="color: red"><%=message%></h1>
	<%
	}
	%>
	<%
	if (errmsg != null && !errmsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=errmsg%></h1>
	<%
	}
	%>
	<fieldset>
		<form action="./update" method="post">
			<label>Employee_Id</label> <label>: <%=id%></label>
			<table>
				<tr>

					<td>id</td>
					<td>:</td>
					<td><input type="number" name="id" value="<%=id%>" hidden="true"
						required="required">
				</tr>
				<tr>
					<td>name</td>
					<td>:</td>
					<td><input type="text" name="name">
				</tr>
				<tr>
					<td>dob</td>
					<td>:</td>
					<td><input type="date" name="dob" >
				</tr>
				<tr>
					<td>password</td>
					<td>:</td>
					<td><input type="password" name="password">
				</tr>
				<tr>
					<td><input type="submit" value="update"></td>
				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>