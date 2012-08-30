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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<sf:form method="POST" modelAttribute="formBean">
	<fieldset title="Document Upload">
	<table cellspacing="0" align="left" style="text-align: left;"
		border="0">
		<tr>
			<th><label for="username">Username:</label></th>
			<td><sf:input path="username" size="15" id="username"
				maxlength="15" cssStyle="width:150px;" /></td>
		</tr>
		<tr title="Password">
			<th><label for="password">Password:</label></th>
			<td><sf:password path="password" size="15" id="password"
				maxlength="15" cssStyle="width:150px;" /></td>
		</tr>
		<tr title="Re-enter Password">
			<th><label for="rePassword">Confirm Password:</label></th>
			<td><sf:password path="rePassword" size="15" id="rePassword"
				maxlength="15" cssStyle="width:150px;" /></td>
		</tr>
		<tr title="Press CTRL + Click to select multiple roles">
			<th><label for="roles">Roles:</label></th>
			<td>
			<table>
				<%--
				<tr>
					<td>General User Role:</td>
					<td><sf:checkbox path="roles" id="roles" value="ROLE_USER"
						cssStyle="width:20px;" disabled="false"/></td>
					<td style="font-size: 9">Has access to personal and public <br />
					documents only.</td>
				</tr>
				 --%>
				<tr>
					<td>Admin Role:</td>
					<td><sf:checkbox path="roles" id="roles" value="ROLE_ADMIN"
						cssStyle="width:20px;" /></td>
					<td style="font-size: 9">Admin Role should be granted with
					Caution<br />
					User with this role will have access to all the<br />
					docuemnts.</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<th>&nbsp;</th>
			<td><input name="commit" type="submit" value="Register Me"
				style="width: 125px;" /></td>
	</table>
	</fieldset>
</sf:form>

</body>
</html>