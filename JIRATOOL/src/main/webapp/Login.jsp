<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<link rel="stylesheet" href="LogRegstyle.css">
<title>login</title>
</head>
<body>

<% String message="";
	if(request.getAttribute("msg") != null)
		message=(String)request.getAttribute("msg");
%>
<form method="get" action="/JIRATOOL/login">
<div class="login-page">

  <div class="form">
    <form class="login-form">

<h3><%= message %></h3>
<h1>Jira Login</h1>

<input type="email" name="email" placeholder="email" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />

<input type="password" name="password" placeholder="password" onFocus="field_focus(this, 'email');" onblur="field_blur(this, 'email');" class="email" />

<button class="btn" type="submit">Login</button> 


<a href="Register.html"><div id="btn2">Register</div></a> <!-- End Btn2 -->
  
</div> <!-- End Box -->
  
</form>
</body>
</html>