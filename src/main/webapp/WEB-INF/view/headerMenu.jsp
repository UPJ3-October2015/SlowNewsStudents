<%--
  Created by IntelliJ IDEA.
  User: basoy
  Date: 11/15/15
  Time: 05:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<script type="text/javascript">

  function checkNews(){
    var random = Math.random() * (99 - 1) + 1;
    function nested() {
      if ( typeof nested.counter == 'undefined' ) {
        nested.counter = random;
      }
      var result = ++nested.counter;
     document.getElementById("countNews").innerHTML = result.toFixed();
    }
    setInterval(nested, Math.random() * (random - 1) + 1);
    }


</script>
<body onload="checkNews()">
<div id="templatemo_header">
  <div id="site_title">
    <h1><a href="http://github.com/basoy">by Serg Bash</a></h1>
  </div>
  <div id="templatemo_search">
    с последнего обновления страницы появилось <a href="NewsServlet" id="countNews"></a> новостей
    <form action="#" method="get">
      <input type="text" value="Search" name="keyword" id="keyword" title="keyword" onfocus="clearText(this)" onblur="clearText(this)" class="txt_field" />
      <input type="submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" class="sub_btn"  /><br><br>
      <c:choose>
        <c:when  test="${login == null || login == ''}">
          <a href="login">Login</a>
        </c:when>
        <c:otherwise>
          You login as <b>${login}</b>
         <a href="logout" style="float: right">Logout</a>
        </c:otherwise>
      </c:choose>
    </form>
  </div>
  <div class="cleaner"></div>
</div> <!-- end of header -->

<div id="templatemo_menu" class="ddsmoothmenu">
  <ul>
    <li><a href="/" class="selected">Home</a></li>
    <li><a href="news">News</a></li>
    <li><a href="registration">Registration</a></li>
    <li><a href="archive">Archive</a></li>
    <li><a href="weather">Weather</a></li>
    <li><a href="about">About</a>
      <ul>
        <li><a href="http://github.com/basoy/page/1">Me</a></li>
        <li><a href="http://github.com/basoy/page/2">My work</a></li>
        <span></span>
      </ul>
    </li>
  </ul>
  <br style="clear: left" />
</div> <!-- end of menu -->
</body>
</html>
