<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login - Contact Application</title>
<link href="resources/css/style.css" rel="stylesheet" type="text/css">
</head>
<body background="resources/images/image1.jpg">
	<table border="1" width="100%" align="center">
		<tr>
			<td height="115px" width="100%">
				<!-- Header --> <jsp:include page="include/header.jsp" />
			</td>
		</tr>
		<tr>
			<td height="35px" width="100%">
				<!-- Menus --> <jsp:include page="include/menu.jsp" />
			</td>
		</tr>
		<tr>
			<td height="450px" valign="top" width="100%">
				<!-- 	 Html Form(Body)  -->
				
				<h2 align="center">User LogIn</h2>
				<h4 class="error" align="center">
					<c:out value="${err}" />
				</h4>
				 <c:if test="${param.act eq 'lo'}">
					<h4 class="success" align="center">LogOut SuccessFully..
						Thanks for using Contact Application</h4>	
				</c:if> 
				
				<c:if test="${param.act eq 'ls'}">
					<h4 class="success" align="center">User Registered
						SuccessFully.. Please LogIn</h4>
				</c:if> 
				<f:form action="/login" modelAttribute="command">
					<table align="center">
						<tr>
							<td><br> <br /> <br />UserName:</td>
							<td><br> <br /> <br /> <f:input path="loginName" /></td>
						</tr>
						<tr>
							<td><br>Password:</td>
							<td><br> <f:password path="password" /></td>
						</tr>
						<tr>
							<td colspan="2" align="right">
								<button>LogIn</button> <br /> <br /> <br /> <a
								href="/reg_form">New User Registration </a>
							</td>
						</tr>
					</table>
				</f:form>
			</td>
		</tr>
		<tr>
			<td height="30px" width="100%">
				<!-- Footer --> <jsp:include page="include/footer.jsp" />
			</td>
		</tr>

	</table>
</body>
</html>