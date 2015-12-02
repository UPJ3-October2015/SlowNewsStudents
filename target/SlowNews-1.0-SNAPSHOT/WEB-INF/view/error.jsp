<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<<%@include file="head.jsp" %>
<body>

<div id="templatemo_wrapper">
  <%@include file="headerMenu.jsp"%>

  <div id="templatemo_main">
    <h1>Error: ${error}</h1>

    <div class="col_2 float_l">
      <h2>Our History</h2>
      <p><em>Aenean scelerisque placerat mauris at vulputate. Etiam in nunc mauris. Mauris tempor iaculis laoreet.</em></p>
      <p>Mauris mattis libero sed dolor rhoncus ut dapibus massa mollis. Sed nec dolor ante, nec <a href="#">ultrices dolor</a>. Mauris vitae mi nec enim euismod pretium. Quisque lorem id tellus pretium. Validate <a href="http://validator.w3.org/check?uri=referer" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="http://jigsaw.w3.org/css-validator/check/referer" rel="nofollow"><strong>CSS</strong></a>.</p>
      <br class="cleaner h20" />
      <ul class="templatemo_list">
        <li>Curabitur suscipit nibh et feugiat</li>
        <li>Nam bibendum vestibulum massa</li>
        <li>Praesent pretium erat felis  in pretium </li>
        <li>Ut tempor feugiat risus at placerat</li>
      </ul>
      <div class="cleaner h20"></div>
      <a href="#" class="more">More</a>
      <br class="cleaner" />
    </div>

    <div class="col_2 float_r">
      <h2>Testimonials</h2>
      <p class="testimonial">Pellentesque quis nulla id orci malesuada porta posuere quis massa. Nunc vitae purus non augue scelerisque ultricies vitae et velit quis nulla id orci malesua. </p>
      <div class="cleaner"></div>
      <cite>John <a href="#"><span>- CTO of new company</span></a></cite>
      <div class="cleaner h30"></div>
      <p class="testimonial">Etiam cursus pretium libero sed posuere. Nullam porttitor varius vehicula. Ut euismod tellus sit amet orci condimentum scelerisque, nec porta nibh. Nulla facilisi.</p>
      <div class="cleaner"></div>
      <cite>Anton <a href="#"><span>- CEO</span></a></cite>
      of old company          <a href="#" class="more">More</a>
      <br class="cleaner" />
    </div>

    <br class="cleaner" />
  </div> <!-- end of main -->

  <%@include file="footer.jsp"%>

</body>
</html>