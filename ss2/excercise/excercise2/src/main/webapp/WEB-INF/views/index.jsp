<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/21/2022
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="calculate"q method="post">
    <span><input type="text" name="first_number"  value="${first_number}" size="25px"></span>
    <span><input type="text" name="second_number" value="${second_number}"  size="25px"></span><br>
    <span><input type="submit" name="operation" value="Addition(+)"></span>
    <span><input type="submit" name="operation" value="Subtraction(-)"></span>
    <span><input type="submit" name="operation" value="Multiplication(X)"></span>
    <span><input type="submit" name="operation" value="Division(/)"></span>

  </form>
  <h3>Result: ${result}</h3>



  </body>
</html>
