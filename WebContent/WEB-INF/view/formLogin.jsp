<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="LinkNewOrgServlet" />

<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${LinkNewOrgServlet}" method="post">
		Login: <input type="text" name="login"><br />
		Senha: <input type="password" name="senha"><br />
		<input type="submit">
		<input type="hidden" name="acao" value="Login" />
	</form>
</body>
</html>