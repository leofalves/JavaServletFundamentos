<%@ page import="br.com.leofalves.gerenciadortc9.servlet.Organization" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/editOrg" var="LinkEditOrgServlet" />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing Organization - ${ org.name }</title>
</head>
<body>
	<form action="${LinkEditOrgServlet}" method="post">
		Nome: <input type="text" name="OrgName" value="${ org.name }"><br />
		Data Abertura: <input type="date" name="OpeningDate" value="<fmt:formatDate value="${ org.openingDate }" pattern="yyyy-MM-dd"/>"><br />
		<input type="hidden" name="id" value="${ org.id }" />
		<input type="submit" />
	</form>
</body>
</html>