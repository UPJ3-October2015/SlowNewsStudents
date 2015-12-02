<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Error Registration</title>
  <link href="../../../css/main.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>

<div id="content">

    <h2>Weather in your city</h2>

    <h2>${city}, ${country}</h2>

    <table>
      <tr>
        <td align="left"><img src=${image}></td>
        <td align="right">temperature = ${temperature} C</td>
      </tr>
    </table>

    <h2>${weatherMain}</h2>

    <table id="tableWeather">
      <tr>
        <td>Wind</td>
        <td>${wind}</td>
      </tr>

      <tr>
        <td>Cloudiness</td>
        <td>${cloudiness}</td>
      </tr>

      <tr>
        <td>Pressure<br></td>
        <td>${pressure}</td>
      </tr>

      <tr>
        <td>Humidity</td>
        <td>${humidity}</td>
      </tr>

      <tr>
        <td>Sunrise</td>
        <td> ${sunrise}</td>
      </tr>
      <tr>
        <td>Sunset</td>
        <td>${sunset}</td>
      </tr>
      <tr>
        <td>Geo coords</td>
        <td>${coord}</td>
      </tr>

    </table>

  </div>

<%@ include file="footer.jsp" %>
</body>
</html>