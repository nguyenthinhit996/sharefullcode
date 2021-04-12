<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%-- config in source AppConfig.jav by 
@Bean
public MessageSource messageSource() {
<fmt:setBundle basename="messages" /> --%>

<fmt:message key="message.password" var="noPass" />
<fmt:message key="message.username" var="noUser" />


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>${noUser} & ${noPass}</h1>
 
 
	 
 
	<a href="/errorhandlerlocaltion/login"> login</a>
	</br>
	<a href="?lang=en">English</a> |
	<a href="?lang=vi_VN">Viet Nam</a>

</body>
</html>