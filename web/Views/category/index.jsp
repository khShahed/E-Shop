<%-- 
    Document   : index
    Created on : Sep 9, 2017, 8:02:23 PM
    Author     : RAFATxRASHID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@  taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category index</title>
    </head>
    <body>
        <div align="center">
            <h1>Category List</h1>
            <hr/>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Parent Id</th>
                </tr>
                
                <c:forEach items="${categoryList}" var="item">
                    <tr>
                        <td>${item.getId()}</td>
                        <td>${item.getName()}</td>
                        <td>${item.getDescription()}</td>
                        <td>${item.getParentId()}</td>
                    </tr>
                </c:forEach>
            </table>
            
            <br/><hr/>
            <a href="./insert">Create new category</a>
            <a href="${context}">Back Home</a>
        </div>
    </body>
</html>
