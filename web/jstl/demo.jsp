<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shaojie.el_jstl.User" %><%--
  Created by IntelliJ IDEA.
  User: 26604
  Date: 2020/4/2
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List list=new ArrayList();
    list.add(new User(23,"zhangsan","男"));
    list.add(new User(25,"zsan","男"));
    list.add(new User(23,"zhan","男"));
    request.setAttribute("user",list);


%>
<table border="1px" width="500" align="center">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <c:forEach items="${user}" var="user" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.gender}</td>

        </tr>

    </c:forEach>
</table>

</body>
</html>
