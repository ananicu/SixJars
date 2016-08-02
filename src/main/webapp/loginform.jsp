<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<title>Six Jars</title>
<style>
body {
	background:
		url('http://wallpaperscraft.com/image/london_ride_river_house_dock_9656_3840x2400.jpg?orig=3');
	margin: 0px;
}

h1, h2, h3, h4, h5, h6, a {
	margin: 0;
	padding: 0;
}

.login {
	margin: 0 auto;
	max-width: 500px;
}

.login-header {
	color: #fff;
	text-align: center;
	font-size: 300%;
}

.login-header h1 {
	text-shadow: 0px 5px 15px #000;
}

.login-form {
	border: 2px solid #999;
	background: #2c3e50;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #000;
}

.login-form h3 {
	text-align: left;
	margin-left: 40px;
	color: #fff;
}

.login-form {
	box-sizing: border-box;
	padding-top: 15px;
	margin: 50px auto;
	text-align: center;
	overflow: hidden;
}

.login input[type="text"], .login input[type="password"] {
	width: 100%;
	max-width: 400px;
	height: 30px;
	font-family: 'Ubuntu', sans-serif;
	margin: 10px 0;
	border-radius: 5px;
	border: 2px solid #f2f2f2;
	outline: none;
	padding-left: 10px;
}

.login-form input[type="button"] {
	height: 30px;
	width: 100px;
	background: #fff;
	border: 1px solid #f2f2f2;
	border-radius: 20px;
	color: slategrey;
	text-transform: uppercase;
	font-family: 'Ubuntu', sans-serif;
	cursor: pointer;
}

.sign-up {
	color: #f2f2f2;
	margin-left: -400px;
	cursor: pointer;
	text-decoration: underline;
}

.no-access {
	color: #E86850;
	margin: 20px 0px 20px -300px;
	text-decoration: underline;
	cursor: pointer;
}

.try-again {
	color: #f2f2f2;
	text-decoration: underline;
	cursor: pointer;
}

/*Media Querie*/
@media only screen and (min-width : 150px) and (max-width : 530px) {
	.login-form h3 {
		text-align: center;
		margin: 0;
	}
	.sign-up, .no-access {
		margin: 10px 0;
	}
	.login-button {
		margin-bottom: 10px;
	}
}
</style>
</head>
<body>
	<link href="http://fonts.googleapis.com/css?family=Ubuntu:500"
		rel="stylesheet" type="text/css">
	<div class="login" style="display: block;">
		<div class="login-header">
			<h1>Login</h1>
		</div>
		<div class="login-form">
		<form action="LoginServlet" method="post">
			<h3>Username:</h3>
			<input type="text" placeholder="Username">
			<br></br>
			<h3>Password:</h3>
			<input type="password" placeholder="Password"></input>
			<br></br>
			<input class="login-button" type="button" value="Login"></input>	
			<br></br>
			<a class="sign-up" href="register.jsp">Sign Up!</a>
			<br></br>
			<a class="no-access" href="accescont.jsp">Can't access your account?</a>
			</form>
		</div>
	</div>
	<div class="error-page" style="display: none;">
		<div class="try-again">Error: Try again?</div>
	</div>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
	<script src="js/index.js"></script>
</body>
</html>