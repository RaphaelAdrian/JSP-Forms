<%--
  Created by IntelliJ IDEA.
  User: Razuto Ichijo
  Date: 5/5/2021
  Time: 1:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>`
    <link rel = "stylesheet" type = "text/css" href = "style.css">
    <meta charset="ISO-8859-1">
    <title>Student Registration</title>
</head>
<body>
<div class="container">
    <h1>Finals Quiz #1</h1>
    <form action ="ProductRegistration" method = "post">

        Product Code: <input name = "productCode" type = "text">
        <br><br>
        Description: <input name = "description" type = "text">
        <br><br>
        Price: <input name = "price" type = "text">
        <br><br>

        Classification:
        <input type ="radio" name = "classification" value = "Local Product" checked> Local Product
        <input type ="radio" name = "classification" value = "Foreign Product"> Foreign Product
        <br>

        Supplier: <select name = "supplier" id = "suppliers">
        <option value = "ABC Company">ABC Company </option>
        <option value = "Exodus Company">Exodus Company</option>
        <option value = "SanaOl Enterprise">SanaOl Enterprise</option>
        <option value = "Maricar Golden Eggs Enterprise">Maricar Golden Eggs Enterprise</option>
    </select><br><br><br><br>

        Availability:
        <input type="checkbox" name="availability" value = "Store" checked>Store
        <input type="checkbox" name="availability" value = "Warehouse" >Warehouse
        <br>
        <input type = "submit" value = "Submit">
        <input type = "reset" value = "Clear">
    </form>
</div>

</body>
</html>
