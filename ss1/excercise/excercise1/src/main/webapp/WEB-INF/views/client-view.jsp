<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/18/2022
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="frm">
    <form action="/convertt" method="get">
        <label>Nhập con số cần chuyển đổi: </label>
        <input type="text" name="input" size="40px">
        <input type="submit" value="Convert">
    </form>
    <div style="background-color: aqua;width: 200px;height: 20px">

        <span> Result: ${rs}</span>

    </div>

</div>

</body>
</html>
