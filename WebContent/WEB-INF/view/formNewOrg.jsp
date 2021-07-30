<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="LinkNewOrgServlet" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Organization</title>
</head>
<body>
	<form action="${LinkNewOrgServlet}" method="post">
		Nome: <input type="text" name="OrgName"><br />
		Data Abertura: <input type="date" name="OpeningDate"><br />
		<input type="submit">
		<input type="hidden" name="acao" value="NewOrg" />
	</form>
</body>
</html>