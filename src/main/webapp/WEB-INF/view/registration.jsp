<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="head.jsp"%>
<body>

<div id="templatemo_wrapper">
    <%@include file="headerMenu.jsp"%>
    
    <div id="templatemo_main">
    	<h1>Registration new user</h1>
            <div id="contact_form">
                <form method="post" name="contact" action="RegistrationServlet" onsubmit="return checkPasswords()">
                        
                        <label for="login">Login:</label> <input type="text" id="login" name="login" class="required input_field" required />
                        <div class="cleaner h10"></div>

                        <label for="email">Email:</label> <input type="text" id="email" name="email" class="validate-email required input_field" required/>
                        <div class="cleaner h10"></div>

						<label for="password">Password:</label> <input type="password" name="password" id="password" class="input_field" required/>
						<div class="cleaner h10"></div>

                        <label for="comfPassword">Comfirm password:</label> <input type="password" name="comfPassword" id="comfPassword" class="input_field" required/>
                        <div class="cleaner h10"></div>
                        
                        <input type="submit" value="Send" id="submit" name="submit" class="submit_btn float_l"/>
						<input type="reset" value="Reset" id="reset" name="reset" class="submit_btn float_r"/>
                        
            	</form>
            </div>
        
		<br class="cleaner" />
    </div> <!-- end of main -->

    <%@include file="footer.jsp"%>

</body>
</html>