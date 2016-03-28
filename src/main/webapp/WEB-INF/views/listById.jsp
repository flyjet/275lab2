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

    Id: ${profile.id} <br/>
    FirstName: ${profile.firstname} <br/>
    LastName: ${profile.lastname} <br/>
    Email: ${profile.email} <br/>
    Address: ${profile.address} <br/>
    Organization:${profile.organization} <br/>
    aboutMyself:${profile.aboutMyself} <br/>

</body>
</html>