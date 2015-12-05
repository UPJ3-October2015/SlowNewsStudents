<?xml version="1.0" encoding="UTF-8" ?>
<jsp:useBean id="newsItem" scope="application" class="com.infopuls.tash.news.NewsItem" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <%@ include file="common/head-contain.jsp"%>
</head>
<body>
<%@ include file="common/top-menu-content.jsp"%>
<div class="templatemo-container">
  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 black-bg left-container">
    <div class="tm-left-inner-container">
      <ul class="nav nav-stacked templatemo-nav">
        <li><a href="newsItem" class="active">News</a></li>
        <li><a href="archive">Archive</a></li>
      </ul>
    </div>
  </div> <!-- left section -->
  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 white-bg right-container">
    <div class="tm-right-inner-container">
      <div class="row">
        <div class="col-sm-12 col-md-12">
          <form action="#" method="post">
            <c:forEach items="${newsItem.newsList}" var="list">
              <article>
                <h2>
                  <c:out value="${list.title}"/>
                </h2>

                <img src="${list.imagePath}" alt="" class="img-thumbnail">

                <c:out value="${list.description}"/>
                <br/><a href="${list.link}" target="_blank">... more</a>
              </article>
            </c:forEach>
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