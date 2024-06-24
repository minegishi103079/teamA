<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/active.css" type="text/css">
<title>アカウント登録</title>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>

	<c:if test="${ not empty errors }">
		<div class="alert alert-danger" role="alert">
			<c:forEach var="error" items="${ errors }">
				<c:out value="${ error }" />
			</c:forEach>
		</div>
	</c:if>

	<c:if test="${ not empty a }">
	<div class="alert alert-primary alert-dismissible fade show d-flex align-items-center justify-content-center" role="alert">
		<c:out value="${ a }" />
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
						
					
	</c:if>

	<div class="container-fluid">
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>アカウント登録</h1>
			<form class="form" action="Accounts0030" method="post">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">氏名
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="varidationTextarea" class="form-control" name="name"
							value="<c:out value="${accountInsert.getName()}"></c:out>"
							placeholder="氏名" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">メールアドレス
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="email" class="form-control" name="mail"
							value="<c:out value="${accountInsert.getMail()}"></c:out>"
							placeholder="メールアドレス" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">パスワード
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password1"
							value="<c:out value="${accountInsert.getPassword()}"></c:out>"
							placeholder="パスワード" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">パスワード(確認)
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password2"
							value="<c:out value="${accountInsert.getPassword()}"></c:out>"
							placeholder="パスワード(確認)" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">権限
							<button type="button" class="btn btn-secondary btn-sm"
								value="<c:out value="${accountInsert.getAuthority()}"></c:out>"
								disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio1" value="0"
								<c:if test="${ empty accountInsert || accountInsert.getAuthority()==0 }">checked</c:if>>
							<label class="form-check-label" for="inlineRadio1">権限なし</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio2" value="1"
								<c:if test="${accountInsert.getAuthority()==1}">checked</c:if>>
							<label class="form-check-label" for="inlineRadio2">売上閲覧</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio3" value="2"
								<c:if test="${accountInsert.getAuthority()==2}">checked</c:if>>
							<label class="form-check-label" for="inlineRadio3">売上担当</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="authority"
								id="inlineRadio4" value="3"
								<c:if test="${accountInsert.getAuthority()==3}">checked</c:if>>
							<label class="form-check-label" for="inlineRadio4">管理者</label>
						</div>
					</div>
				</div>


				<div class="mx-auto p-2" style="width: 100px;">
					<button type="submit" class="btn btn-primary"
						href="Accounts0031_registrationcheck.jsp">✓登録</button>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
