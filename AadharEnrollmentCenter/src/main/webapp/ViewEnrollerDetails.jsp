<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.aadharEnrollmentCenter.model.AadharData"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
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
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
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
	max-width: 450px;
	padding: 30px;
	padding-right: 50px;
	background-color: rgba(255, 255, 255, 0.7);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #3366cc;
}

label {
	display: block;
	margin-bottom: 8px;
	color: #555;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	max-width: 100%;
	background-color: #3366cc;
	color: #fff;
	font-weight: bold;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
	background-color: #005580;
}
</style>
<title>View Aadhar Profile</title>
</head>
<body>

	<%
	session = request.getSession();
	AadharData data = (AadharData) session.getAttribute("curUser");
	%>

	<div class="container" align="center">

		<h1>Your Details</h1>
		<br>

		<p>
			Aadhar Number:
			<%=data.getAadharNumber()%></p>
		<br>
		<p>
			Your Name:
			<%=data.getName()%></p>
		<br>
		<p>
			EMail:
			<%=data.getEmail()%></p>
		<br>
		<p>
			Phone Number:
			<%=data.getPhoneNumber()%></p>
		<br>
		<p>
			Address Line:
			<%=data.getAddressLine()%></p>
		<br>
		<p>
			City:
			<%=data.getCity()%></p>
		<br>
		<p>
			State:
			<%=data.getState()%></p>
		<br>
		<p>
			PinCode:
			<%=data.getPinCode()%></p>
		<br>
		<div class="buttonHolder">
			<a class="LinkButton" href="index.html">Back</a>
		</div>

	</div>


</body>
</html>