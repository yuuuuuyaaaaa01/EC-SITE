<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3">

				<h1>商品一覧</h1>

				<p>
					<a href="/order/cartList" class=".bg-warning">カートの中身を見る</a>
				</p>

				<c:forEach var="pizza" items="${pizzas}">
					<div class="card-deck">
						<div class="card" style="width: 20rem;">
							<div class="card-body">
								<img class="img-thumbnail" src="../../../image/pizza.jpg"
									alt="Card image cap">
								<div class="card-title">
									<c:out value="${pizza.name}" />
								</div>
								<div class="card-text">
									<c:out value="${pizza.price}" />
									円
								</div>
								<form:form
									action="${pageContext.request.contextPath}/order/cart"
									method="POST">
									<input type="hidden" name="id" value="${pizza.id}">
									<input type="submit" value="カートに入れる" class="btn btn-primary">
								</form:form>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>



		<!-- jQuery、Popper.js、Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
</body>
</html>