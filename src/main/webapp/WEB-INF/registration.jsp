<?xml version="1.0" encoding="UTF-8" ?>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="common/head-contain.jsp"%>
</head>
<body>
<%@ include file="common/top-menu-content.jsp"%>
<div class="templatemo-container">
    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg left-container">
        <%--<div class="tm-left-inner-container">--%>
        <%--<ul class="nav nav-stacked templatemo-nav">--%>
        <%--<li><a href="newsItem" class="active">NewsItem</a></li>--%>
        <%--<li><a href="archive">Archive</a></li>--%>
        <%--</ul>--%>
        <%--</div>--%>
    </div> <!-- left section -->
    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container">
        <div class="tm-right-inner-container">
            <div class="row">

                <div class="col-sm-12 col-md-12">
                    <form action="registration" method="post">
                        <div class="form-group">
                            <input type="text" id="contact_login" name="contact_login"class="form-control" placeholder="Login" />
                        </div>
                        <div class="form-group">
                            <input type="password" id="contact_password" name = "contact_password" class="form-control" placeholder="Password"/>
                        </div>
                        <div class="form-group">
                            <input type="password" id="contact_confirm-password" name = "contact_confirm-password" class="form-control" placeholder="Confirm Password"/>
                        </div>
                        <div class="form-group">
                            <input type="text" id="contact_first_name" name = "contact_first_name" class="form-control" placeholder="First name" />
                        </div>
                        <div class="form-group">
                            <input type="text" id="contact_last_name" name = "contact_last_name" class="form-control" placeholder="Last name" />
                        </div>
                        <div class="form-group">
                            <input type="text" id="contact_email" name = "contact_email" class="form-control" placeholder="Email Address" />
                        </div>
                        <div class="form-group">
                            <input type="text" id="contact_phoneNumber" name ="contact_phoneNumber" class="form-control" placeholder="Phone number" />
                        </div>
                        <div class="form-group">
                            <lable name = "errorText"><%= request.getAttribute("errorText")%> </lable>
                        </div>
                        <button type="submit" class="btn btn-warning">Registration</button>
                    </form>
                </div>
                <div class="clearfix"></div>
            </div>
            <%@ include file="common/footer.jsp"%>
        </div>
    </div> <!-- right section -->
</div>
</body>
</html>

