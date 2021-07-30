<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.leofalves.gerenciadortc9.model.Organization" %>
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
	
	<h1>Organizações</h1>
	<ul>
		<c:forEach items="${ organizations }" var="org">
			<li>${ org.name } - <fmt:formatDate value="${ org.openingDate }" pattern="dd/MM/yyyy"/>
			| <a href="entrada?acao=DeletaOrg&id=${ org.id }">Excluir</a>
			| <a href="entrada?acao=ShowOrg&id=${ org.id }">Editar</a>
			</li>
		</c:forEach>
	</ul>	
	<br />
	<a href="entrada?acao=NewOrgForm">Criar nova Empresa</a>
</body>
</html>