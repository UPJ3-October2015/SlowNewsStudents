<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Error Registration</title>
    <link href="../../../css/main.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>

<div id="content">

    <h2>Registration Success!!!</h2><br/>

    <p>Login: <%= user.getUser()%>
    </p>

    <p>E-mail: <%= user.getEmail()%>
    </p>

    <p>Password: <%= user.getPassword()%>
    </p>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>


