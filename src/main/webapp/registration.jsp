<jsp:useBean id="curUserBean" scope="session" type="servlets.UserBean" class="servlets.UserBean"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>SLOW NEWS</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<div id="content">
    <form action="AddUser" method="post">

        <h2>Sing up</h2><br/>

        <div class="left">

            <label for="user">User:</label><br/>
            <input type="text" id="user" name="user"><br/>
            <label for="email">E-mail:</label><br/>
            <input type="email" id="email" name="email"><br/>
            <label for="password">Password:</label><br/>
            <input type="password" id="password" name="password">
            <label for="confirm">Confirm:</label><br/>
            <input type="password" id="confirm" name="confirm">


        </div>
        <br/>

        <button type="submit" name="save"><b>Sing up</b></button>

    </form>
</div>
<div id="footer">&copy; Vova</div>
</body>
</html>
