<%--
  Created by IntelliJ IDEA.
  User: caco
  Date: 2023/01/13
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

  <c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
  </c:if>

  <form action="/login" method="post">
    <input type="text" name="mid">
    <input type="text" name="mpw">
    <button type="submit">LOG IN</button>
  </form>
</body>
</html>
