<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/21/2022
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich condiments</h1>
  <form action="/save" method="post">
    <input type="checkbox" name="spice" value="Lettuce">Lettuce
    <input type="checkbox" name="spice" value="Tomato">Tomato
    <input type="checkbox" name="spice" value="Mustard">Mustard
    <input type="checkbox" name="spice" value="Sprouts">Sprouts

    <input type="submit" value="Save">
  </form>
  </body>
</html>
