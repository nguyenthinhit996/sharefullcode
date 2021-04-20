
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>
<body>

	<h1>Welcome To Index admin Page</h1>
	<a href="/springsecuritybasicauthenticated/logout">logout</a>


	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>


</body>
</html>