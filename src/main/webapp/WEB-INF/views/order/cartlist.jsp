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

		<div class="container">
		<div class="row">
		<div class="col-sm-6 col-md-3">
		
		<p>現在の注文一覧</p>
		
		<p><a href="/order/order">買い物を続ける</a></p>
		
		<c:forEach var="cartItem" items="${cartItems}" varStatus="status">
		<div class="card-deck">
		<div class="card" style="width: 20rem;">
		<div class="card-body">
			<img class="img-thumbnail" src="../../../image/neko.jpg" alt="Card image cap">
			<div class="card-title"><c:out value="${cartItem.name}"/></div>
			<div class="card-text"><c:out value="${cartItem.price}"/>円</div>
		<form:form action="${pageContext.request.contextPath}/order/delete" method="POST">
			<input type="hidden" name="index" value="${status.index}">
			<input type="submit" value="この注文を取り消す" class="btn btn-primary">
		</form:form>
		</div>
		</div>
		</div>
		</c:forEach>
			現在の注文金額です。<c:out value="${totalPrice}"/>円
		</div>
		</div>
		</div>
		
		
		 <!-- jQuery、Popper.js、Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		

</body>
</html>