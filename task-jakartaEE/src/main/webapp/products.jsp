<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="org.eclipse.jakarta.hello.entity.Product" %>

<%@ page import="org.eclipse.jakarta.hello.repository.ProductRepository" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h2>Product List</h2>
    <ul>
        <%
               List<Product>products =  (List<Product>) request.getAttribute("products");
               for (Product product : products) { %>
                   <li>
                       <font color=red>Product Name: </font><%= product.getName() %> <font color=red>- Product Price: </font><%= product.getPrice() %>
                       <form action="deleteProduct" method="post">
                           <input type="hidden" name="productId" value="<%= product.getId() %>">
                           <input type="submit" value="Delete">
                       </form>
                       <form action="updateProductPage.jsp" method="get">
                           <input type="hidden" name="productId" value="<%= product.getId() %>">
                           <input type="submit" value="Update">
                       </form>
                   </li>
               <% }
        %>
    </ul>
    <a href="addProductPage.jsp">Add New Product</a>
</body>
</html>