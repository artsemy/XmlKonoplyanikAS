<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>index.jsp</title>
</head>
<body>
	<form action="ServletJsp" method="get">
	<div align="center">
		<input type="submit" name="command" value="sax" />
		<input type="submit" name="command" value="stax" />
		<input type="submit" name="command" value="dom" />
	</div>
	</form>
</body>
</html>