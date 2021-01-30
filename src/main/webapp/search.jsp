<%--
  Created by IntelliJ IDEA.
  User: olson
  Date: 12/7/2020
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="includes/header.jsp"%>>
</head>
<body>
  <div class="container">
    <div class="hero-unit">
      <h2>Search</h2>
    </div>

    <%@include file="includes/navigation.jsp"%>

    <div class="container">
      <form action="Search" method="get">
        <label for="title">Search by Title</label>
        <input type="text" name="title" id="title">
        <input type="submit">

        <label for="director">Search by Director</label>
        <input type="text" name="director" id="director">
        <input type="submit">

      </form>
    </div>

    <%@include file="includes/footer.jsp"%>
  </div>

</body>
</html>
