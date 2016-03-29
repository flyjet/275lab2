<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello World from Qi</title>
</head>
<body>

    <h1>Create New Profile</h1>
    <form method="POST" modelAttribute="profile">
        Id:<input type="text" name ="id"/> <br/><br/>
        FirstName: <input type="text" name="firstname"/> <br/><br/>
        LastName: <input type="text" name="lastname"/> <br/><br/>
        Email: <input type="text" name="email"/> <br/><br/>
        Address: <input type="text" name="address"/><br/><br/>
        Organization: <input type="text" name="organization"/><br/><br/>
        AboutMyself <input type="text" name="aboutMyself"/><br/>

        <br/>
        <button>Create</button>
    </form>


    <h1>All Profiles</h1>
    <c:forEach var="p" items="${profiles}">
        Id: ${p.id} FirstName: ${p.firstname}<br/>
    </c:forEach>

</body>
</html>