<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="head.jsp" %>
<body>

<div id="templatemo_wrapper">
    <%@include file="headerMenu.jsp"%>

    <div id="templatemo_main">
        <div class="post_box">
            <h2>Weather</h2>
            <div class="post_meta">
                <ul>
                    <li>134 comments</li>
                    <li>28 Jan 2048</li>
                    <li><a href="#">Weather</a>, <a href="#">News</a></li>
                </ul>
            </div>
            <div class="col_b float_r">
                <img src="" alt="Image 12" class="image_frame_300" />
                <div class="post_text">
                    <p>${news}</p>
                </div>
            </div>
            <div class="cleaner"></div>
        </div>

            <div class="cleaner"></div>
        </div>

        <div class="pagging">
            <ul>
                <li><a href="http://github.com/basoy" target="_parent">Previous</a></li>
                <li><a href="http://github.com/basoy/page/1" target="_parent">1</a></li>
                <li><a href="http://github.com/basoy/page/2" target="_parent">2</a></li>
                <li><a href="http://github.com/basoy/page/3" target="_parent">3</a></li>
                <li><a href="http://github.com/basoy/page/4" target="_parent">4</a></li>
                <li><a href="http://github.com/basoy/page/5" target="_parent">5</a></li>
                <li><a href="http://github.com/basoy/page/6" target="_parent">6</a></li>
                <li><a href="http://github.com/basoy/page/7" target="_parent">Next</a></li>
            </ul>
        </div>
        <div class="cleaner"></div>
    </div> <!-- end of main -->

    <%@include file="footer.jsp"%>

</body>
</html>