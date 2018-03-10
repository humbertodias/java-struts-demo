<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<fieldset>
    <legend>Update Product</legend>
    <s:form action="updateproduct">
        <input type="hidden" name="id" value="<s:property value='id'/>"/>
        <input type="text" name="name" placeholder="Name" value="<s:property value='name'/>"/>
        <input type="text" name="price" type="number" placeholder="Price" value="<s:property value='price'/>"/>
        <s:submit value="Update"></s:submit>
    </s:form>
</fieldset>

<a href="viewproducts">All Products</a>  
