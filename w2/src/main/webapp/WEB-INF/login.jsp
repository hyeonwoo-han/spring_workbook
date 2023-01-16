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
    <br>
    <span>자동로그인 허쉴?</span><input type="checkbox" name="auto">
  </form>
</body>
</html>
