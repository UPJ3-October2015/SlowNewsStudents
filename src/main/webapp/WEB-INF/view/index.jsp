<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="head.jsp" %>

<body>
<div id="templatemo_wrapper">
    <%@include file="headerMenu.jsp"%>

    <script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
    <script type="text/javascript" src="js/jquery.nivo.slider.js"></script>

        <div id="templatemo_main">
        <div class="col_2 float_l">
            <c:choose>
                <c:when test="${login == null || login == ''}">
                    <h2>  Welcome To Slow News </h2>
                </c:when>
                <c:otherwise>
                    <h2>Dear ${login}, welcome again to Slow News!</h2>
                </c:otherwise>
            </c:choose>

            <br class="cleaner h20" />
            <p><em>Sed mollis leo nec est tempor interdum et vulputate orci. Integer in erat nibh, nec volutpat nunc. Aliquam in congue ligula.</em></p>
            <p><a href="http://github.com/basoy" target="_parent">Slow News</a> is  free css template provided by <a href="http://github.com/basoy">templatemo.com</a> for your personal or commercial websites. Credit for Nivo Slider goes to <a href="http://nivo.dev7studios.com" target="_blank">Dev7studios</a>. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi porta, sem vitae lacinia convallis, eros sapien euismod metus, quis ultricies arcu neque eu elit. Nam vel pellentesque nunc.</p>
            <br class="cleaner h20" />
            <ul class="templatemo_list">
                <li>Dictum eu pharetra quam semper</li>
                <li>Fusce fermentum justo non libero</li>
                <li>Placerat metus egestas sem dolor in lectus</li>
                <li>Vivamus mollis, odio ut aliquam auctor</li>
            </ul>
            <div class="cleaner h20"></div>
            <a href="#" class="more">More</a>
            <br class="cleaner" />
        </div>

        <div class="col_2 float_r">
            <h2>Latest Work</h2>
            <img src="/images/templatemo_image_05.png" alt="Image 05" class="image_frame_430" />
            <p><em>In porta tincidunt mi eu mattis. Nam vel dolor a felis  blandit et vel libero. Donec aliquet tempor porttitor. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>CSS</strong></a>.</em></p>
            <a href="#" class="more">More</a>
            <br class="cleaner" />
        </div>

        <br class="cleaner" />
    </div> <!-- end of main -->

    <%@include file="footer.jsp"%>

</body>
</html>