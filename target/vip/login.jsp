<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>xxx</title>
</head>
<script>
    if(window.top!==window){
        window.top.location.href=window.location.href;
    }
</script>

<body>
<strong>${message}</strong>
<form action="login.do" method="post">
    <p>
        <label>Account:<input name="account" value="0001"></label>
    </p>
    <p>
        <label>Password:<input name="password" type="password" value="123456"></label>
    </p>
    <p>
        <button type="submit">Login</button>
    </p>
</form>
<% session.removeAttribute("message");%>
</body>
</html>

