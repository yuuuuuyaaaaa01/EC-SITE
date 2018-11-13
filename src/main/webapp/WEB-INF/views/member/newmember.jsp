<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- ユーザの新規登録 -->
		<p>ユーザ新規登録</p>
		<form:form modelAttribute="memberForm" action="${pageContext.request.contextPath}/member/create" method="POST">
			<form:errors path="name" cssStyle="color:red"/>
			名前<form:input path="name" placeholder="名前"/><br>
			<form:errors path="mailAddress" cssStyle="color:red"/>
			メールアドレス<form:input path="mailAddress" placeholder="メールアドレス"/><br>
			<form:errors path="password" cssStyle="color:red"/>
			パスワード<form:input path="password" placeholder="メールアドレス"/><br>
			<form:errors path="confirmPassword" cssStyle="color:red"/>
			確認用パスワード<form:input path="confirmPassword" placeholder="確認用パスワード"/><br>
			<input type="submit" value="新規登録">
		</form:form>
		
</body>
</html>