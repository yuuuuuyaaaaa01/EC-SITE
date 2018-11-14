<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>ログインフォーム</p>
	<!-- form が発射されたときに、modelAttributeで結び付ける -->
	<form:form modelAttribute="loginForm" action="${pageContext.request.contextPath}/login/login" method="POST">
		<form:errors path="mailAddress" cssStyle="color:red"/>
		<p>メールアドレス<form:input path="mailAddress"/></p>
		<form:errors path="password" cssStyle="color:red"/>
		<p>パスワード<form:input path="password"/></p>
		<input type="submit" value="ログインする"/>
	</form:form>
	
	<p>ユーザ登録がまだの方はこちら</p>
	<a href="/">ユーザの新規登録</a>
	
</body>
</html>