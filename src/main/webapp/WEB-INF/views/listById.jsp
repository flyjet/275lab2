<%--
  Created by IntelliJ IDEA.
  User: qi
  Date: 3/28/16
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello World from Qi</title>
</head>
<body>
<h1>Profile Detail</h1>

    <form method="POST" modelAttribute="profile">
        Id:<input type="text" name ="id" value="${profile.id}" readonly/> <br/><br/>
        FirstName: <input type="text" name="firstname" value="${profile.firstname}"/> <br/><br/>
        LastName: <input type="text" name="lastname" value="${profile.lastname}"/> <br/><br/>
        Email: <input type="text" name="email" value="${profile.email} "/> <br/><br/>
        Address: <input type="text" name="address" value="${profile.address}"/><br/><br/>
        Organization: <input type="text" name="organization" value="${profile.organization}"/><br/><br/>
        AboutMyself <input type="text" name="aboutMyself" value="${profile.aboutMyself}"/><br/>

        <br/>
        <button>Update</button>
    </form>

    <br/>
    <br/>

    <form method="DELETE">
        <button>Delete</button>
    </form>


</body>
</html>