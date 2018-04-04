<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${sessionScope.userId==null}">
	<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}

.active {
    background-color: red;
}
</style>
</head>
<body>

<ul>
  <li><a href="/index" class="active">Home</a></li>
  <li><a href="/index">LogIn</a></li>
  <li><a href="/reg_form">Register</a></li>
  <li><a href="#about">About</a></li>
  <li><a href="#about">Help</a></li>
</ul>

</body>
</html>
	
	<!-- <b> <a href="/index">Home</a> | <a href="/index">LogIn</a> | <a
		href="/reg_form">Register</a> | <a href="#">About</a> | <a href="#">Help</a>
	</b> -->
</c:if>

<c:if test="${sessionScope.role==1}">
	<!-- User Menu -->
	<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}

.active {
    background-color: red;
}
</style>
</head>
<body>

<ul>
  <li><a href="/user_dashboard" class="active">Home</a></li>
  <li><a href="/profile">Profile</a></li>
  <li><a href="/contact_form">Add Contact</a></li>
  <li><a href="/clist">Contact List</a></li>
   <li><a href="/logout">Logout</a></li>
</ul>

</body>
</html>
	
	<!-- <b><a href="/user_dashboard">Home</a> |<a href="/profile">Profile</a>
		| <a href="contact_form">Add Contact</a> |<a href="/clist">Contact
			List</a> |<a href="/logout">Logout</a> </b> -->
</c:if>

<c:if test="${sessionScope.role==2}">
	<!-- Admin Menu -->
	<!DOCTYPE html>
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}

.active {
    background-color: red;
}
</style>
</head>
<body>

<ul>
  <li><a href="/admin_dashboard" class="active">Home</a></li>
  <li><a href="/users_list">User List</a></li>
  <li><a href="/logout">Logout</a></li>
</ul>

</body>
</html>
	
	<!-- <b><a href="/admin_dashboard">Home</a> |<a href="/users_list">User
			List</a> |<a href="/logout">Logout</a> </b> -->
</c:if>


