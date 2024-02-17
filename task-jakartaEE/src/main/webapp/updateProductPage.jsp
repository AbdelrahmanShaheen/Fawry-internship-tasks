<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="org.eclipse.jakarta.hello.entity.Product" %>
<%@ page import="org.eclipse.jakarta.hello.repository.ProductRepository" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
    <%
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductRepository productRepo = ProductRepository.getInstance();
        Product product = productRepo.findProductById(productId);
    %>
    <h2>Update Product</h2>
    <form action="updateProduct" method="post">
        <input type="hidden" name="productId" value="<%= product.getId() %>">
        Product Name: <input type="text" name="productName" value="<%= product.getName() %>"><br>
        Product Price: <input type="text" name="productPrice" value="<%= product.getPrice() %>"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
