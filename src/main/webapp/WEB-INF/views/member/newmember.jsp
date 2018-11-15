<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
			<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbarEexample7">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> 🍕 </a>
			</div>

			<div class="collapse navbar-collapse" id="navbarEexample7">
				<ul class="nav navbar-nav">
					<li><a href="/order/cartList">カートの中身を見る</a></li>
					<li class="active"><button type="button" class="btn btn-default navbar-btn"><a href="/">ログイン</a></button></li>
					<li><button type="button" class="btn btn-default navbar-btn">ログアウト</button></li>
				</ul>
				<p class="navbar-text navbar-right">
					ようこそ <a href="#" class="navbar-link">ゲスト</a> さん。
				</p>
			</div>
		</div>
	</nav>

		<!-- ユーザの新規登録 -->
		<p>ユーザ新規登録</p>
		<form:form modelAttribute="memberForm" action="${pageContext.request.contextPath}/create" method="POST">
			<form:errors path="name" cssStyle="color:red"/>
			名前<form:input path="name" placeholder="名前"/><br>
			<form:errors path="mailAddress" cssStyle="color:red"/>
			メールアドレス<form:input path="mailAddress" placeholder="メールアドレス"/><br>
			<form:errors path="password" cssStyle="color:red"/>
			パスワード<form:input path="password" placeholder="パスワード"/><br>
			<form:errors path="confirmPassword" cssStyle="color:red"/>
			確認用パスワード<form:input path="confirmPassword" placeholder="確認用パスワード"/><br>
			<input type="submit" value="新規登録">
		</form:form>
		
		<p>既に登録されている方はこちら</p>
		<a href="/login/login">ログイン画面へ</a>
		
			<!-- jQuery、Popper.js、Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
		
</body>
</html>