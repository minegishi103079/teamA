<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>アカウント登録画面</title>
</head>
<body>

<jsp:include page="Dashboard.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>アカウントを登録してよろしいですか</h1>
			<form class="was-validated" action="Accounts0030_RegistrationServlet" method="post">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">氏名
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="validationTextarea"
							class="form-control" name="name" placeholder="氏名" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">メールアドレス
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="email" class="form-control" name="mail" placeholder="メールアドレス" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">パスワード
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password1" placeholder="パスワード" required>
					</div>
				</div>

                <div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">パスワード(確認)
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password2" placeholder="パスワード(確認)" required>
					</div>
				</div>

                <div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">権限
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio1" value="0" checked>
                            <label class="form-check-label" for="inlineRadio1">権限なし</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio2" value="1">
                            <label class="form-check-label" for="inlineRadio2">売上閲覧</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio3" value="2">
                            <label class="form-check-label" for="inlineRadio3">売上担当</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="authority" id="inlineRadio4" value="3">
                            <label class="form-check-label" for="inlineRadio4">管理者</label>
                          </div>
					</div>
				</div>


				<div class="mx-auto p-2" style="width: 100px;">
					<button type="submit" class="btn btn-primary" href="#">✓登録</button>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
