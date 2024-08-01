<%--
  Created by IntelliJ IDEA.
  User: lgunti
  Date: 8/22/2014
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Input Page</title></head>
<body>
<h2> Form Input Page </h2>
<form:form method="post" commandName="form" action="/data/form/save">
    <table>
        <tr>
            <td>Data Content :</td>
            <td><form:textarea rows="30" cols="150" path="content"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center" ><input type="submit" /></td>
        </tr>
    </table>

</form:form>
</body>
</html>
