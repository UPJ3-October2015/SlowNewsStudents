<jsp:useBean id="user" class="model.UserBean" scope="application"/>
<div id="header">
    <div id="SlowNews">
        <h1>Slow News</h1>
    </div>
    <div id="userMail">
        <h3>${curUserBean.user}
            <form action="Logout" method="post">
                <button type="submit" name="Logout"><b>Log out</b></button>
            </form>
        </h3>
    </div>
</div>