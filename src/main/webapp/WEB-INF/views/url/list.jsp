<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>URL List</title>
</head>
<body>

<c:forEach var="url" items="${urlList}">
    <p>URL ID : ${url.urlId}</p>
    Original Address : ${url.urlOriginal}
    <br>
    Shorten Address : ${url.urlShorten}
    <br>
    Number of Requests : ${url.requestCount}
    <br><br>
</c:forEach>


</body>
</html>