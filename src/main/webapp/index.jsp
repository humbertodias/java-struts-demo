<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<fieldset>
    <legend>Product</legend>
    <s:form action="createproduct">
        <s:textfield name="name" placeholder="Name"/>
        <s:textfield name="price" type="number" placeholder="Price"/>
        <s:submit value="save"></s:submit>
    </s:form>
</fieldset>

<a href="viewproducts">All Products</a>  
