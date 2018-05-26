<%@page pageEncoding="utf-8"  %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<meta charset="UTF-8">
<title>录入VIP客户</title>
</head>
<body>
	<header>
		<h1>录入VIP客户</h1>
	</header>
	<main>
		<p>
			<strong>${message}</strong>
		<p>
	 <form action="vip/add.do" method="post">
        <p>
            <label>*手机号:<input name="phone" value="${param.phone}" placeholder="将作为VIP编号"></label>
        </p>
        <p>
            <label>*姓名:<input name="name" value="${param.name}"></label>
        </p>
        <p>
            <label>*性别:</label>
            <label>
            <input  name="sex" type="radio" value="1" checked>男
            </label>
            <label>
            <input  name="sex" type="radio" value="0" ${param.sex=='0'?'checked':''}>女
            </label>
        </p>
        <p>
            <label>年龄:<input type="number" value="${param.age}" name="age"></label>
        </p>
        <p>
            <label>QQ:<input name="qq" value="${param.qq}"></label>
        </p>
        <p>
            <label>Email:<input name="email" value="${param.email}"></label>
        </p>
        <p>
            <label>邮编:<input name="zip" value="${param.zip}"></label>
        </p>
        <p>
            <label>邮寄地址:<input name="address" value="${param.address}"></label>
        </p>
        <p>
            <label>备注:<textarea name="remark">${param.remark}</textarea></label>
        </p>
        <p>
            <button type="submit">确定</button>
            <a href="/welcome.do">返回</a>
            
        </p>
    </form>
    </main>
</body>
</html>