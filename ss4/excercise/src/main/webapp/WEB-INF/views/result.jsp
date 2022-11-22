<%--
  Created by IntelliJ IDEA.
  User: OS
  Date: 11/22/2022
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        table th td{
            text-align: center;
        }
    </style>
</head>
<body>
<table class="table table-primary table-striped">
    <tr style="text-align: center">
        <th>LANGUAGES</th>
        <th>PAGE SIZES</th>
        <th>SPAMS FILTERS</th>
        <th>SIGNATURE</th>
        <th>EDIT</th>
        <th>DELETE</th>
        <th>DETAIL</th>
    </tr>
    <c:forEach var="email" items="${emailBoxList}">
        <tr style="text-align: center">
            <td style="text-align: center">${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamFilter}</td>
            <td>${email.signature}</td>
            <td><a href="/edit/id"><button  type="button" name="edit" value="${email.getId()}" class="btn btn-warning">EDIT</button></a> </td>
            <td><a href="/delete/${email.id}"> <button type="button" name="delete" value="${email.getId()}" class="btn btn-danger">DELETE</button></a> </td>
            <td><button type="button" name="detail" value="${email.getId()}" class="btn btn-info">DETAIL</button></td>

        </tr>

    </c:forEach>

</table>



</body>
</html>
