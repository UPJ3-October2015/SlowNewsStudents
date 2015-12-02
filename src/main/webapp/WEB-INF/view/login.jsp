<%--<jsp:useBean id="curUserBean" scope="session" type="model.UserBean" class="model.UserBean"/>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>SLOW NEWS</title>
    <link href="../../../css/main.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<div id="content">
    <form action="Registration" method="post">

        <h2>Sing in</h2><br/>

        <div class="left">

            <label for="user">User:</label><br/>
            <input type="text" id="user" name="user"><br/>
            <label for="email">E-mail:</label><br/>
            <input type="email" id="email" name="email"><br/>
            <label for="password">Password:</label><br/>
            <input type="password" id="password" name="password">
        </div>
        <br/>

        <button type="submit" name="checkUser"><b>Sing in</b></button>

    </form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
