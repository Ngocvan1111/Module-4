<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/18/2022
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/translate" method="get">
    <span>Nhập từ cần dịch: </span>
    <input type="text" name="inputWord">
    <input type="submit" value="Translate">

</form>
<p>${result}</p>

</body>
</html>
