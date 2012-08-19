<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.leftNavTabs {
	width: 100%;
	font-size: 12px;
	color: #FFFFFF;
}

.leftNavTabs td a {
	width: 100%;
	font-size: 12px;
	display: block;
	color: white;
	background-color: grey;
	height: 20px;
	text-align: left;
	vertical-align: middle;
	text-decoration: none;
}

.leftNavTabs td a:HOVER {
	color: white;
}
</style>

</head>
<body>
<security:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN','ROLE_SUPER_ADMIN')">
<table class="leftNavTabs" border="1">
	<tr>
		<td><s:url value="/upload" var="newdoc" /> <a href="${newdoc}">Upload
		New Document</a></td>
	</tr>
	<tr>
		<td><s:url value="/docs" var="listdocs" /> <a href="${listdocs}">Documents</a></td>
	</tr>
	<security:authorize access="hasAnyRole('ROLE_ADMIN')">
		<tr>
			<td>Visible to Admin only</td>
		</tr>
	</security:authorize>
</table>
</security:authorize>
</body>
</html>