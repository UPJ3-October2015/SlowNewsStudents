<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" scope="session" class="com.infopuls.tash.user.User" />
<jsp:useBean id="weather" scope="application" class="com.infopuls.tash.ws.Weather" />


<div class="templatemo-logo "> <!--visible-xs-block-->
  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg logo-left-container">
    <%--<span id="id_date" style="color:black;"></span>--%>
    <%--<span id="id_time" style="color:black;"></span>--%>
      <h1 class="logo-left">Slow</h1>
      <div class="top-menu-left">
        ${weather.temperatureC} °C
      </div>
      <div class="top-menu-left">
        <lable id="countNewNews"></lable> newsItem appeared since last page update
      </div>


  </div>
  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg logo-right-container">
    <h1 class="logo-right">News</h1>
    <div class="top-menu-right">
      <c:if test="${user.login == null}">
        <ul>
          <li class = "top-menu">
            <a class = "top-menu-a" href="login" class="active">Log in</a>
          </li>
          <li class = "top-menu">
            <a class = "top-menu-a" href="registration">Registration</a>
          </li>
        </ul>
      </c:if>

      <c:if test="${user.login != null}">
        <div class = "top-menu-a">${user.firstName.concat(" ").concat(user.lastName)} </div>
        <ul>
          <li class = "top-menu">
            <a class = "top-menu-a" href="logout" class="active">Log out</a>
          </li>
        </ul>
      </c:if>
      </div>
    </div>
  </div>
</div>