<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%
session = request.getSession();
String title = (String) session.getAttribute("title");
String message = (String) session.getAttribute("message");
String redirectLink = (String) session.getAttribute("redirectLink");
session.removeAttribute("title");
session.removeAttribute("message");
session.removeAttribute("redirectLink");
%>

<head>
<meta charset="ISO-8859-1">
<title><%=title%></title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-position: center;
	background-image: url("images/image.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	position: relative;
}

body::before {
	content: "";
	background-image: inherit;
	background-size: cover;
	background-repeat: no-repeat;
	filter: blur(2px);
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
}

.container {
	max-width: 400px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.7);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	text-align: center;
}

h4 {
	color: #3366cc;
	margin-bottom: 20px;
}

a {
	display: inline-block;
	padding: 10px 20px;
	background-color: #3366cc;
	color: #fff;
	text-decoration: none;
	border-radius: 5px;
	font-weight: bold;
	transition: background-color 0.3s ease;
}

a:hover {
	background-color: #005580;
}
</style>
</head>
<body>
	<div class="container">
		<div class="list">
			<h2 class="message"><%=message%></h2>
		</div>
		<div class="buttonHolder">
			<a class="LinkButton" href=<%=redirectLink%>>Back</a>
		</div>
	</div>
</body>
</html>

