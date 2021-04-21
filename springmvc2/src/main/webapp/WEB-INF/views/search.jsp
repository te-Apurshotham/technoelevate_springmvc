<%@page import="com.te.springmvc2.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
EmployeeBean bean = (EmployeeBean) request.getAttribute("data");
String errmsg = (String)request.getAttribute("errMsg");
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
	if (errmsg != null && !errmsg.isEmpty()) {
	%>
	<%=msg%>
	<%
	}
	%>

	<fieldset>
		<form action="./searchForm" method="get">
			<table>
				<tr>
					<td>Enter Id</td>
					<td>:</td>
					<td><input type="number" name="id">
				</tr>
				<tr>
					<td><input type="submit" value="search"></td>
				</tr>
			</table>
		</form>
		<%
	if (bean != null) {
	%>
	<h4>
		Name :
		<%=bean.getName()%></h4>
	<h4>
		Id :
		<%=bean.getId()%></h4>
	<h4>
		Dob :
		<%=bean.getDob()%></h4>
	<%
	}
	%>
		
	</fieldset>
	

</body>
</html>