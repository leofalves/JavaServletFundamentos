<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.leofalves.gerenciadortc9.servlet.Organization" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Tag Lib - Organizations List</title>
</head>
<body>
	<c:if test="${not empty orgName }">
		<p>Empresa ${ orgName } cadastrada com sucesso!</p> <br />
	</c:if>
	
	<ul>
		<c:forEach items="${ organizations }" var="org">
			<li>${ org.name } - <fmt:formatDate value="${ org.openingDate }" pattern="dd/MM/yyyy"/>
			<a href="deleteOrg?id=${ org.id }">Excluir</a>
			</li>
		</c:forEach>
	</ul>	
</body>
</html>