<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>table.jsp</title>
</head>
<body>
	<form action="ServletJsp" method="get">
		<div align="right">
			<input type="submit" name="command" value="home" />
		</div>
	</form>
	<table border="1">
		<tr>
			<td>id</td>
			<td>user</td>
			<td>price</td>
			<td>drink</td>
		</tr>
		<c:forEach items="${requestScope.array}" var="order">
			<tr>
				<td>${order.id}</td>
				<td>${order.user}</td>
				<td>${order.price}</td>
				<td>-</td>
			</tr>
			<c:forEach items="${order.drinks}" var="drink">
				<tr>
					<td>-</td>
					<td>-</td>
					<td>-</td>
					<td>${drink}</td>
				</tr>
			</c:forEach>
		</c:forEach>
	</table>
</body>
</html>