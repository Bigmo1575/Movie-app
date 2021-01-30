<%--
  Created by IntelliJ IDEA.
  User: olson
  Date: 12/7/2020
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%@include file="includes/header.jsp"%>
</head>
<body>
  <div class="container">
    <div class="hero-unit">
      <h2>Add new Movie</h2>
    </div>
    
    <%@include file="includes/navigation.jsp"%>
    
    <p>${message}</p>
    <div class="container">
      <form action="AddNewMovie" method="post">
        <label for="title">Title:</label>
        <input type="text" name="title" id="title">
        
        <label for="director">Director:</label>
        <input type="text" name="director" id="director">
        
        <label for="lengthInMinutes">Length in minutes:</label>
        <input type="text" name="lengthInMinutes" id="lengthInMinutes">
        
        <input type="submit">
        
      </form>
      
    </div>
    
    <%@include file="includes/footer.jsp"%>
  </div>

</body>
</html>
