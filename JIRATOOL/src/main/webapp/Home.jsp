<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="Homestyle.css" rel="stylesheet">
</head>
<body>
<header>
<div class="login-page">

  <div class="form">
    <form class="login-form">
    <h1>WELCOME TO</h1>
    <h1>JIRA DASHBOARD</h1>
   
  
  <nav class="main-nav">
    <a href="showCreateJiraScreen" class="text-link -active"><h2><b>Create jira</b></h2></a>
    <a href="viewJira" class="text-link"><h2><b>View jira</b></h2></a>
    <a href="Contact.jsp" class="text-link"><h2><b>Contact</b></h2></a>
    <a href="logout" class="text-link"><h2><b>Logout Mr:<% out.print(request.getAttribute("uname")); %></b></h2></a>
  </nav>
</header>

   <p style="text-align: center;">


</body>
</html>