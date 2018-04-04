<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users list - Contact Application</title>
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
				<!-- AdminDashBoard -->
				<h2 align="center">User List</h2>

				<table border="1" cellpadding="5" align="center">

					<tr>
						<th>SR</th>
						<th>User ID</th>
						<th>NAME</th>
						<th>PHONE</th>
						<th>EMAIL</th>
						<th>ADDRESS</th>
						<th>LoginName</th>
						<th>Role</th>
						<th>LoginStatus</th>
					</tr>

					<c:if test="${empty usersList}">
						<tr>
							<td colspan="9" class="error">No Record Present...Please Add
								Contacts</td>
						</tr>
					</c:if>

					<c:forEach var="u" items="${usersList}" varStatus="st">
						<tr>
							<td>${st.count}</td>
							<td>${u.userId}</td>
							<td>${u.name}</td>
							<td>${u.phone}</td>
							<td>${u.email}</td>
							<td>${u.address}</td>
							<td>${u.loginName}</td>
							<td>${u.role}</td>
							<td><select id="id_${u.userId}"
								onchange="changeStatus(${u.userId},$(this).val())">
									<option value="1">Active</option>
									<option value="2">Block</option>
							</select> <script type="text/javascript">
				$('#id_${u.userId}').val(${u.loginStatus});
				  
				</script></td>
						</tr>
					</c:forEach>
				</table>
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