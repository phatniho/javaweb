<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户登录</title>
</head>
<body>
	<h1>用户登录</h1>
	<form action="welcome" method="post">
		<table>
			<tr>
				<td>用户编号:</td>
				<td><input type="number" name="id" /></td>
			</tr>
			<tr>
				<td>用户名称:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="登录" /> <input type="reset"
					name="重置" /></td>
			</tr>
		</table>
	</form>
</body>
</html>