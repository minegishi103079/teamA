<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/active.css" type="text/css">
<title>アカウント詳細削除確認</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>アカウント詳細削除確認</h1>
			<form class="form" action="Accounts0044" method="post" id="decide">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">氏名</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="Textarea" class="form-control"
							name="name" value="<c:out value="${accounts.getName()}"></c:out>" placeholder="氏名" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">メールアドレス</label>
					</div>
					<div class="col-6 p-2">
						<input type="email" class="form-control" name="mail"
							value="<c:out value="${accounts.getMail()}"></c:out>" placeholder="メールアドレス" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">パスワード</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password"
							value="<c:out value="${accounts.getPassword()}"></c:out>" placeholder="パスワード" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">パスワード(確認)</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password"
							value="<c:out value="${accounts.getPassword()}"></c:out>" placeholder="パスワード(確認)" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">権限</label>
					</div>
					<div class="col-6 p-2">
						<div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio1" 
                            value="0" <c:if test="${accounts.getAuthority()==0}">checked</c:if> disabled> 
                            <label class="form-check-label" for="inlineRadio1">権限なし</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio2" 
                            value="1" <c:if test="${accounts.getAuthority()==1}">checked</c:if> disabled>
                            <label class="form-check-label" for="inlineRadio2">売上閲覧</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio3" 
                            value="2" <c:if test="${accounts.getAuthority()==2}">checked</c:if> disabled>
                            <label class="form-check-label" for="inlineRadio3">売上担当</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio4" 
                            value="3" <c:if test="${accounts.getAuthority()==3}">checked</c:if> disabled>
                            <label class="form-check-label" for="inlineRadio4">管理者</label>
                          </div>
					</div>
				</div>
			</form>


				<div class="row d-flex justify-content-center mt-2">
					<div class="col-auto">
						<button type="submit" class="btn btn-danger" name="account_id" 
						value="<c:out value="${accounts.getAccount_id() }"></c:out>" form="decide">✓OK</button>
					</div>
					<div class="col-auto">
						<form method="post" action="Accounts0041" id="cancel">
							<button type="submit" class="btn btn-light" name="account_id" 
							value="<c:out value="${accounts.getAccount_id() }"></c:out>" form="cancel">キャンセル</button>
						</form>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>



