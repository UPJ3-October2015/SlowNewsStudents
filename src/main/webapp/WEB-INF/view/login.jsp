
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="head.jsp" %>
<body>

<div id="templatemo_wrapper">
  <%@include file="headerMenu.jsp"%>

  <div id="templatemo_main">
    <h1>Sign in user</h1>
    <div id="contact_form">
      <form method="post" action="LoginServlet">

        <label for="login">Login:</label> <input type="text" id="login" name="login" class="required input_field" required />
        <div class="cleaner h10"></div>

        <label for="password">Password:</label> <input type="password" name="password" id="password" class="input_field" required/>
        <div class="cleaner h10"></div>

        <input type="submit" value="Sign in" id="submit" name="submit" class="submit_btn float_l" />

      </form>
    </div>

    <br class="cleaner" />
  </div> <!-- end of main -->

  <%@include file="footer.jsp"%>

</body>
</html>