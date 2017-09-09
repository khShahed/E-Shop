<%-- 
    Document   : messageDisplay
    Created on : Sep 9, 2017, 8:22:04 PM
    Author     : RAFATxRASHID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            ${message}<br/>
            <a href="${redirectLink}">${redirectPath}</a>
        </div>
    </body>
</html>
