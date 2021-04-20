<form class="form-signin" th:action="@{/login}" method="post">
 <h2 class="form-signin-heading">Please sign in</h2>
 <p>Example: user / domain / password</p>
 <p th:if="${param.error}" class="error">Invalid user, password, or domain</p>
 <p>
   <label for="username" class="sr-only">Username</label>
   <input type="text" id="username" name="username" class="form-control" 
     placeholder="Username" required autofocus/>
 </p>
 <p>
   <label for="domain" class="sr-only">Domain</label>
   <input type="text" id="domain" name="domain" class="form-control" 
     placeholder="Domain" required autofocus/>
 </p>
 <p>
   <label for="password" class="sr-only">Password</label>
   <input type="password" id="password" name="password" class="form-control" 
     placeholder="Password" required autofocus/>
 </p>
 <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button><br/>
 <p><a href="/index" th:href="@{/index}">Back to home page</a></p>
</form>