<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String message = (String) request.getAttribute("errMsg");
%>
<%
if (message != null && !message.isEmpty()) {
%>
<%=message%>
<%
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Login</legend>
		<form action="./empLogin" method="post">

			<table>
				<tr>
					<td>Enter id</td>
					<td>:</td>
					<td><input type="number" name="id"></td>


				</tr>
				<tr>
					<td>Enter password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="login"></td>
				</tr>


			</table>
		</form>

	</fieldset>

</body>
</html>