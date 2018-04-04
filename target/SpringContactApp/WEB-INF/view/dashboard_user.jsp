<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User DashBoard - Contact Application</title>
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
			<td height="400px" valign="top" width="100%">
				<!-- UserDashBoard -->
				<h1>${sessionScope.name}</h1> <br> <br>
				<h2>Welcome to Contact Application</h2>

				<h4 class="succes" align="center">
					<c:out value="${success}" />
				</h4>
				<h4 class="error" align="center">
					<c:out value="${err}" />
				</h4>

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