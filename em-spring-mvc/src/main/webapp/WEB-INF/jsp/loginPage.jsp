<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>

<title>Login Page</title>

</head>

<body>
	<jsp:include page="nav-bar.jsp" />

	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">

		<div
			class="bg-light mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
			<div class="my-3 py-3">
				<h2 class="display-5">Login</h2>
			</div>
			<div class="bg-white box-shadow mx-auto"
				style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">
				
				<c:if test="${param.error != null}">
					<div class="alert alert-danger" role="alert">
  						Invalid username and password.
					</div>
				</c:if>

				<c:if test="${param.logout != null}">
					<div class="alert alert-success">You have been logged out.</div>
				</c:if>
				
				<form class="form-signin" action="${pageContext.request.contextPath}/doLogin" method="post">
					
					<label for="inputEmail" class="sr-only">Email address</label> 
					<input type="email" id="username" name="username" class="form-control" placeholder="Email address" required autofocus> 
					<label for="inputPassword" class="sr-only">Password</label> 
					<input id="password" type="password" name="password" class="form-control" placeholder="Password" required>

					<!-- <button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button> -->
						
					<input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign In" /> 
					<a class="btn btn-outline-success btn-block" href="<c:url value="/signup"/>">Register</a>
						
				</form>


			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>