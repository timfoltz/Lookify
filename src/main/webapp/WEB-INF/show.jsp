<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${song.title}"/> Details</title>
</head>
<body>
	<h1><c:out value="${song.title}"/></h1>
<p>Artist: <c:out value="${song.artist}"/></p>
<p>Rating (1-10): <c:out value="${song.rating}"/></p>
<p><a href="${song.songUrl}">Link to listen</a></p>
<br>
<br>
<br>
<a href="/songs/delete/${song.id}">Delete</a>
<a href="/dashboard">Dashboard</a>

</body>
</html>