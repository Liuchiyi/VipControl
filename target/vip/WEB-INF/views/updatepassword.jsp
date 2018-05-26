<%--
  Created by IntelliJ IDEA.
  User: liu_chiyi
  Date: 2018/5/15
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page  pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<strong>${message}</strong>
    <form action="updatepassword.do" method="post">
        <p>
            <label>oldPassword:<input name="oldPassword"></label>
        </p>
        <p>
            <label>newPassword:<input name="newPassword"></label>
        </p>
        <p>
            <label>newPasswordConfirm:<input name="newPasswordConfirm"></label>
        </p>
        <p>
            <button type="submit">update</button>
            <a href="welcome.do">back</a>
        </p>
    </form>
</body>
</html>
