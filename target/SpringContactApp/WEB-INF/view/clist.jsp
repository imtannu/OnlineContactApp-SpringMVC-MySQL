<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact list - Contact Application</title>
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
				<h2 align="center">Contact List</h2> <c:if
					test="${param.act eq 'sv'}">
					<h4 class="success" align="center">Contact Added
						Successfully..</h4>
				</c:if> <c:if test="${param.act eq 'del'}">
					<h4 class="success" align="center">Contact Deleted
						Successfully..</h4>
				</c:if> <c:if test="${param.act eq 'ed'}">
					<h4 class="success" align="center">Contact Edited
						Successfully..</h4>
				</c:if>
				<table align="right">
					<tr>
						<td>
							<form action="/contact_search">
								<input type="text" name="freetext"
									placeholder="Enter text to Search">
								<button>Search</button>
							</form>
						</td>
						<td></td>
					</tr>
				</table>

				<h4 class="succes" align="center">
					<c:out value="${success}" />
				</h4>
				<h4 class="error" align="center">
					<c:out value="${err}" />
				</h4>

				<form action="/bulk_delete">
					<button>Delete Selected Record</button>
					<br /></br>
					<table border="1" cellpadding="5">

						<tr>
							<th>SELECT</th>
							<th>CONTACT NAME</th>
							<th>PHONE</th>
							<th>EMAIL</th>
							<th>ADDRESS</th>
							<th>REMARK</th>
							<th>ACTION</th>
						</tr>

						<c:if test="${empty contactList}">
							<tr>
								<td colspan="8" class="error">No Record Present...Please
									Add Contacts</td>
							</tr>
						</c:if>

						<c:forEach var="c" items="${contactList}" varStatus="st">
							<tr>
								<td align="center"><input type="checkbox" name="cid"
									value="${c.contactId}"></td>
								<td>${c.name}</td>
								<td>${c.phone}</td>
								<td>${c.email}</td>
								<td>${c.address}</td>
								<td>${c.remark}</td>

								<s:url var="url_del" value="/delete_contact">
									<s:param name="cid" value="${c.contactId}"></s:param>
								</s:url>
								<s:url var="url_edit" value="/edit_contact">
									<s:param name="cid" value="${c.contactId}"></s:param>
								</s:url>
								<td><a href="${url_edit}"> Edit</a> | <a href="${url_del}">
										Delete</a></td>
							</tr>
						</c:forEach>

					</table>
				</form>

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