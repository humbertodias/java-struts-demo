<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Products</title>
    </head>
    <body>
        <%@ taglib uri="/struts-tags" prefix="s" %>  

        <h3>All Products:</h3>  
        <table border="1">  
        <tr>
            <th>id</th>  
            <th>name</th>  
            <th>price</th>  
            <th colspan="2">Action</th>
        </tr>
        <s:iterator value="list">  
        <tr>
            <td><s:property value="id"/></td>  
            <td><s:property value="name"/></td>  
            <td><s:property value="price"/></td>  
            <td><a href="deleteproduct?id=<s:property value='id'/>">Delete</a></td>  
            <td><a href="updateproduct?id=<s:property value='id'/>&submitType=form">Update</a></td>  
        </tr>
        </s:iterator>  
        </table>  
        
        <a href="index.jsp">New</a>

    </body>
</html>
