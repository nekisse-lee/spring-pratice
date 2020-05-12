<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false"
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
    <script src="${contextPath}/js/scriptTest.js" type="text/javascript"></script>
    <meta charset="UTF-8">
    <title>hello.jsp 페이지</title>
</head>
<body>
안녕하세요<br>
<h2>${message}</h2>
<h2>${contextPath}</h2>

<img src="${contextPath}/images/duke3.png" width="200" height="200"/> <br/>
<input type="button" value="테스트" name="테스트" onclick="test()">
</body>
</html>
