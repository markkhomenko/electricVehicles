<%--
  Created by IntelliJ IDEA.
  User: lgunti
  Date: 8/22/2014
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Data</title>
</head>

<h3>Form data saved to session</h3>
<body align="center">
<table style="table-layout: fixed; width: 100%">
        <tr>
            <td valign="top" width = "2%" align="top">Data Content :</td>
            <td width ="20%" style="word-wrap: break-word">${content}</td>

        </tr>
         <tr>
        <td>Data Size (KB) :</td>
        <td>${contentSize}</td>
        </tr>
    </table>
</body>
</html>
