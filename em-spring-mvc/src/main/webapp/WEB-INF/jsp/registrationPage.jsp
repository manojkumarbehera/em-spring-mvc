<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="nav-bar.jsp" />

	<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">

		<div
			class="bg-light mr-md-3 pt-3 px-3 pt-md-5 px-md-5 text-center overflow-hidden">
			<div class="my-3 py-3">
				<h2 class="display-5">Register</h2>
			</div>
			<div class="bg-white box-shadow mx-auto"
				style="width: 80%; height: 300px; border-radius: 21px 21px 0 0;">

				<form:form modelAttribute="user" id="userForm" class="form-signin"
					action="${pageContext.request.contextPath}/user/register"
					method="post">
					
  					<form:errors path="*" class="alert alert-danger"/>
					
					
					<form:input path="id" value="" type="hidden" />

					<label for="inputEmail" class="sr-only">Email address</label>

					<form:input path="email" type="email" id="inputEmail"
						class="form-control" placeholder="Email address"/>

					<label for="inputPassword" class="sr-only">Password</label>
					<form:password path="password"  id="inputPassword"
						class="form-control" placeholder="Password" />

					<label for="inputPassword" class="sr-only">Password
						Confirmation</label>
					<form:password path="passwordConfirmation"
						id="inputPassword" class="form-control" placeholder="Password" />

					<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
					
					
				</form:form>


			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>