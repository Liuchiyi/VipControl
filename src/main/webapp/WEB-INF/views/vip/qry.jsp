<%@page pageEncoding="utf-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<base href="<%=request.getContextPath()%>/">
<title>VIP客户查询</title>
</head>
<body>
	
	<header>
		<strong>${message}</strong>
		<form action="vip/qry.do" method="post">
			<p>
				<label>
					VIP:
					<input name="code"  autofocus>
				</label>
				<button type="submit">Go</button>
			</p>
		</form>
	</header>
	<main>
		<c:if test="${v!=null}">
		<article>
			<p>
				<span>
					编号:
					<b>${v.code}</b>
				</span>
				<span>
					VIP等级:
					<b>${v.rank}</b>
				</span>
				<span>
					目前消费总金额:
					<b>￥${v.amount}元</b>
				</span>
			</p>
			<p>
				<span>
					姓名:
					<b>${v.name}</b>
				</span>
				<span>
					性别:
					<b>${v.sex}</b>
				</span>
				<span>
					年龄:
					<b>${v.age}</b>
				</span>
			</p>
			<p>
				<span>
					QQ:
					<b>${v.qq}</b>
				</span>
				<span>
					Email:
					<b>${v.email}</b>
				</span>
				<span>
					邮寄地址/邮编:
					
					<b>${v.address}(${v.zip})</b>
				</span>
			</p>
			<p>
				${v.remark}
			<p>
		</article>
		</c:if>
		
	</main>
	
</body>
</html>