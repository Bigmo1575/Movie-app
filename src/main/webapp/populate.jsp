<%--
  Created by IntelliJ IDEA.
  User: olson
  Date: 12/7/2020
  Time: 11:27 AM
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
      <h2>Populate the Database</h2>
    </div>
    <%@include file="includes/navigation.jsp"%>
    <p>WARNING: this action will overwrite the existing database</p>
    <div class="container">
      <form action="Populate" method="post">

        <input type="submit" value="Populate DB">

      </form>


    </div>
    <p>${message}</p>
    <%@include file="includes/footer.jsp"%>
  </div>

</body>
</html>
