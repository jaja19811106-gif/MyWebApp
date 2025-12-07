<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー追加</title>
</head>
<body>
    <h1>ユーザー追加フォーム</h1>
    <form action="UserAddServlet" method="post">
        名前: <input type="text" name="name"><br>
        年齢: <input type="number" name="age"><br>
        <input type="submit" value="追加">
    </form>
</body>
</html>