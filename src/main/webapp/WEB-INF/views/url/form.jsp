<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>URL Submitting Form</title>
</head>
<br>
<form action="http://localhost:8080/url/list" method="GET">
    <input type="submit" value="URL 리스트 확인">
</form>
</br>
<form action="http://localhost:8080/url/insert" method="POST">
    Submit Original URL : <input type="text" name="url">
    <input type="submit" value="입력">
</form>
</br>
<form action="http://localhost:8080/url/access" method="GET">
    Submit Shorten URL : <input type="text" name="url">
    <input type="submit" value="접속">
</form>

</body>
</html>