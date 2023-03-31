<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<style>
	.error{
		color:red;
	}
	</style>
</head>
<body>
<div class="container">
        <h1 style="text-align:center; Color:brown">Learner's Academy</h1>
		<h2 style="text-align:center; Color:red"> Welcome To School Login Page</h2> <br/>
		<div>
			<div class="wrapper fadeInDown">
				<div id="formContent">
					<div class="fadeIn first">
						<h2 class='sign'>Sign In</h2>
					</div>
					<form action="loginServlet" method="POST">
						<input type="text" id="login" class="fadeIn second" name="username"
							placeholder="username"  /> <input type="password"
							 id="password" class="fadeIn third" name="password"
							placeholder="Password" /> <input type="submit"
							class="fadeIn fourth" value="Log In" />
					</form>
					<%
						String error = request.getParameter("error");
					if(error !=  null){
					%>
					<div class="error"><%= error %></div>
					<%} %>
				</div>
			</div>
		</div>
	</div>
</body>
</html>