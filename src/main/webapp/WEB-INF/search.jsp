<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify Dashboard</title>
</head>
<body>
	<div>
		<div class="navbar">
			<a href="/songs/new">Add New</a>
			<a href="/songs/top">Top Songs</a>
			<form method="post" action="/search">
				<label for="search">Search</label>
				<input type="text" name="search"/>
				<input type="submit" value="Search"/>
			</form>
		</div>
		<div class="table">
			<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Artist</th>
					<th>rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${result }" var="song">
					<tr>
						<td><a href="/songs/${song.id }"><c:out value="${song.title }"/></a></td>
						<td><c:out value="${song.artist }"/></td>
						<td><c:out value="${song.rating }"/></td>
						<td><a href="/songs/delete/<c:out value="${song.id }"/>">delete</a></td>
						
					</tr>
				</c:forEach>
			</tbody>	
	</table>
		</div>
	</div>
</body>
</html>