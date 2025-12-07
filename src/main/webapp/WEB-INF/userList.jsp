<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー一覧</title>
</head>
<body>
	<h1>ユーザー一覧</h1>

	<!-- 追加画面へのリンク -->
	<p>
		<a href="addUser.jsp">新規ユーザー追加</a>
	</p>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>年齢</th>
			<th>操作</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>
					<!-- 編集フォーム -->
					<form action="UserUpdateServlet" method="post"
						style="display: inline;">
						<input type="hidden" name="id" value="${user.id}"> 名前: <input
							type="text" name="name" value="${user.name}"> 年齢: <input
							type="number" name="age" value="${user.age}"> <input
							type="submit" value="更新">
					</form> <!-- 削除フォーム -->
					<form action="UserDeleteServlet" method="post"
						style="display: inline;">
						<input type="hidden" name="id" value="${user.id}"> <input
							type="submit" value="削除">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>