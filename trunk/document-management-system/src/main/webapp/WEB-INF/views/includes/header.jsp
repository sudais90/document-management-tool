<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<body>

<security:authentication property="principal.username" var="uName"/>

<table border="0" style="width: 100%; color: #FFFFFF;">
	<tr>
		<td><s:url value="/assets/images/dms-logo.png" var="dmslogo" />
		<img src="${dmslogo}" alt="DOCUMENT MANAGEMENT SYSTEM" width="300"
			height="100" /></td>
		<td>&nbsp;</td>

		<td width="150">
		
		<%--
		Show Welcome message and logout link only when some user has logged in.
		 --%>
		 		
		<security:authorize access="isAuthenticated()">
			<table style="width: 100%; color: #FFFFFF;" border="0">
				<tr>
					<td>Welcome&nbsp;${uName}</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><s:url value="/j_spring_security_logout" var="logoutUrl" />
					<a href="${logoutUrl}" style="color: #FFFFFF;">Logout</a></td>
				</tr>
			</table>
		</security:authorize>
		</td>
	</tr>
</table>
</body>
</html>
