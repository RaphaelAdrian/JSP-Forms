<%--
  Created by IntelliJ IDEA.
  User: Razuto Ichijo
  Date: 5/20/2021
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <link rel = "stylesheet" type = "text/css" href = "style.css">
    <meta charset="ISO-8859-1">
    <title>Product Registration</title>
</head>
<body>

<div class="form">
    <h1>Student Registration</h1>
    <form action="StudentSaveToDB" method="get">
        Student Number: <input type="number" name="studentNumber">
        <br>
        First Name: <input type="text" name="firstName">
        <br>
        Last Name: <input type="text" name="lastName">
        <br>
        Birth Date: <input type="date" name="birthDate">
        <br>
        Address:
        <br>
        House/Unit/Flr #: <input type="text" name="houseNum">
        <br>
        <br>
        Street Name: <input type="text" name="street">
        <br>
        Barangay: <input type="text" name="barangay">ote
        <br>
        City/Municipality: <input type="text" name="city">
        <br>
        Course:<input type="text" name="course">
        <br><br>

            <input type="submit" value="Submit">
            <input type="reset" value="Clear">

    </form>
</div>



</body>
</html>
