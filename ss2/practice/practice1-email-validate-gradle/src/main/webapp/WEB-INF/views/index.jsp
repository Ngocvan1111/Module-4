<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/20/2022
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Spring Gradle</title>
  </head>
  <body>
  <h1>Email validate</h1>
  <h3 style="color: red">
    ${message}
  </h3>
  <form action="validate" method="post">
    <input type="text" name="email"><br>
    <input type="submit" value="Validate">

  </form>
  </body>
</html>
