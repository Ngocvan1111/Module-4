<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/21/2022
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello</h1>
<c:forEach var="spice" items="${spice}" varStatus="stt">
    <p> Gia vị ${stt.count} <c:out value="${spice}"></c:out></p>
</c:forEach>


</body>
</html>
