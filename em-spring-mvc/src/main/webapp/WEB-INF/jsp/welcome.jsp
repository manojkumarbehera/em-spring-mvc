<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav-bar-loggin.jsp"/>
	<div
		class="position-relative overflow-hidden p-3 p-md-1 m-md-3 text-center bg-light">
		<div class="col-md-5 p-lg-5 mx-auto my-5">
			<h1 class="display-4 font-weight-normal">Welcome</h1>
			
		</div>
		<div class="product-device box-shadow d-none d-md-block"></div>
		<div
			class="product-device product-device-2 box-shadow d-none d-md-block"></div>
	</div>
	
	<div class="container">
       
        
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <td>Email</td>
                    <td>Created</td>
                </tr>
            </thead>
            <tbody>
                <c:if test="${empty users}">
                <tr>
                    <td colspan="4">No users</td>
                </tr>
                </c:if>
                
                <c:forEach var="user" items="${users}">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/user/${user.id}"> ${user.email}</a></td>
                    <td><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${user.created.time}" /></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
     </div>
     
     <jsp:include page="footer.jsp" />
	
</body>
</html>