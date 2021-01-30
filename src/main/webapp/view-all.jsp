<%--
  Created by IntelliJ IDEA.
  User: olson
  Date: 12/7/2020
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <%@include file="includes/header.jsp"%>>
</head>
<body>
  <div class="container">
    <div class="hero-unit">
      <h2>View All</h2>
    </div>
    <%@include file="includes/navigation.jsp"%>
    <div class="container">
      <c:choose>
        <c:when test="${empty film}">
          <p>Sorry, the list of movies was empty</p>
        </c:when>
        <c:otherwise>
          <c:forEach var="movie" items="${film}">
            <h2>${movie.title}</h2>
            <p>${movie.title} was directed by${movie.director} 
                and is ${movie.lengthInMinutes} minutes long</p>
          </c:forEach>
        </c:otherwise>
      </c:choose>
      
    </div>
    <%@include file="includes/footer.jsp"%>
  </div>

</body>
</html>
