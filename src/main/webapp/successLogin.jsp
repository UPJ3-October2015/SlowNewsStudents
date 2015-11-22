<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Error Registration</title>
    <link rel="stylesheet" href="main.css">

</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>

<div id="content">

    <h2>Login Success!!!</h2><br/>
    <jsp:useBean id="user" class="servlets.UserBean" scope="application"/>
    <p>Login: <%= user.getUser()%>
    </p>

    <p>E-mail: <%= user.getEmail()%>
    </p>

    <p>Password: <%= user.getPassword()%>
    </p>

</div>
<div id="footer">&copy; Vova</div>
</body>
</html>

