<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Product</title>
</head>
<body>
    <h2>Add New Product</h2>
    <form action="addProduct" method="post">
        <label for="name">Product Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="price">Product Price:</label>
        <input type="number" id="price" name="price" required><br><br>

        <input type="submit" value="Add Product">
    </form>
</body>
</html>
