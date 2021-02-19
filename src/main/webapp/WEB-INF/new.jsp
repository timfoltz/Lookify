<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Song</title>
</head>
<body>
<h1>New Song</h1>
<form:form action="/songs" method="post" modelAttribute="song">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input required="true" min="5" path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input required="true" min="5" path="artist"/>
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:errors path="rating"/>
        <form:select required="true" path="rating">
        	<form:option value="1">1</form:option>
        	<form:option value="2">2</form:option>
        	<form:option value="3">3</form:option>
        	<form:option value="4">4</form:option>
        	<form:option value="5">5</form:option>
        	<form:option value="6">6</form:option>
        	<form:option value="7">7</form:option>
        	<form:option value="8">8</form:option>
        	<form:option value="9">9</form:option>
        	<form:option value="10">10</form:option>
      		</form:select>
    </p>
    <p>
        <form:label path="songUrl">Song URL</form:label>
        <form:errors path="songUrl"/>
        <form:input path="songUrl"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>