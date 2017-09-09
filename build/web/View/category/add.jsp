<%-- 
    Document   : add
    Created on : Sep 9, 2017, 8:01:30 PM
    Author     : RAFATxRASHID
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Category</title>
    </head>
    
    <body>
        <div align="center">
            <h1>Add new Category</h1>
            <form action="./category/add">
                <table>
                    <tr>
                        <td>Category Name</td>
                        <td><input type="text" name="name" /></td>
                    </tr>
                    <tr>
                        <td>Category Description</td>
                        <td><input type="text" name="description" /></td>
                    </tr>
                    <tr>
                        <td>Parent Id</td>
                        <td>
                            <select name="parentId">
                                <option name="none" value="0">None</option>
                                <c:forEach items="${categoryList}" var="item">
                                    <option name="${item.getName()}" value="${item.getId()}">
                                        ${item.getName()}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr colspan="2" align="center">
                        <td> <input type="submit" value="Create Category" /></td>
                    </tr>
                </table>
            </form>
        </div>
        
    </body>
</html>
