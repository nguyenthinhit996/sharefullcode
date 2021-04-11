<%-- 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head></head>
<body>
   <h1>Login</h1>
   <c:if test="${param.error != null}">
		<p>Invalid username and password.</p>
	</c:if>
   <form name='f' action="/login" method='POST'>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
  </form>
</body>
</html> --%>

<%-- login custom
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/login" var="loginUrl" />
<form action="${loginUrl}" method="post">
	<c:if test="${param.error != null}">
		<p>Invalid username and password.</p>
	</c:if>
	<c:if test="${param.logout != null}">
		<p>You have been logged out.</p>
	</c:if>
	<p>
		<label for="username">Username</label> <input type="text"
			id="username" name="username" />
	</p>
	<p>
		<label for="password">Password</label> <input type="password"
			id="password" name="password" />
	</p>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	<button type="submit" class="btn">Log in</button>
</form>
 --%>
 
<!--  login with remember me -->
 
     <%@ taglib  
        prefix="c"  
        uri="http://java.sun.com/jsp/jstl/core"   
    %>  
    <c:url value="/login" var="loginUrl"/>  
    <form action="${loginUrl}" method="post">         
        <c:if test="${param.error != null}">          
            <p>  
                Invalid username and password.  
            </p>  
        </c:if>  
        <c:if test="${param.logout != null}">         
            <p>  
                You have been logged out.  
            </p>  
        </c:if>  
        <p>  
            <label for="username">Username</label>  
            <input type="text" id="username" name="username"/>      
        </p>  
        <p>  
            <label for="password">Password</label>  
            <input type="password" id="password" name="password"/>      
        </p>  
        <p>  
            <label for="remember"> Remember me</label>  
            <input type="checkbox" name="checkboxrememberme" />  
        </p>  
        <input type="hidden"                          
            name="${_csrf.parameterName}"  
            value="${_csrf.token}"/>  
        <button type="submit" class="btn">Log in</button>  
    </form>  