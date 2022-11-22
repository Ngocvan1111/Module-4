<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/22/2022
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Settings Email</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="settings" method="post" modelAttribute="emailBox" >
    <form:label path="languages">Language</form:label>
   <form:select path="languages" items="${languages}"></form:select><br><br>
    <form:label path="pageSize">Page Size: </form:label>
    <form:select path="pageSize" items="${pageSizes}"></form:select>
    <form:label path="pageSize"> email per page</form:label><br><br>
    <form:label path="spamFilter">Spams Filter</form:label>
    <form:checkbox path="spamFilter"></form:checkbox>
    <form:label path="spamFilter">Enable spams filter</form:label><br><br>
    <form:label path="signature">Signature</form:label>
    <input type="submit" name="update" value="Update" >


</form:form>

</body>
</html>
