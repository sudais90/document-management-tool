<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<form method="GET" action="search">
<table style="width: 550px; height: 38px; float: right" border="0"
	bordercolor="white">
	<tr>
		<td>Search</td>
		<td><input type="text" name="q" style="width: 420px;"/></td>
		<td><input type="submit" value="search" style="width:100px;"></td>
	</tr>
</table>
</form>
</body>
</html>