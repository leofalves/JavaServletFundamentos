<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Organization Created</title>
</head>
<body>
	<c:if test="${not empty orgName }">
		<p>Empresa ${ orgName } cadastrada com sucesso!</p>
	</c:if>
	<c:if test="${empty orgName }">
		<p>Nenhuma empresa cadastrada!</p>
	</c:if>
	
</body>
</html>