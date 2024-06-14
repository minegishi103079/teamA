<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>アカウント詳細編集画面</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>アカウント詳細編集画面</h1>
			<form class="form" action="">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">氏名</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="Textarea"
							class="form-control" name="name" placeholder="氏名">
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">メールアドレス</label>
					</div>
					<div class="col-6 p-2">
						<input type="email" class="form-control" name="mail" placeholder="メールアドレス">
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">パスワード</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password" placeholder="パスワード">
					</div>
				</div>

                <div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">パスワード(確認)</label>
					</div>
					<div class="col-6 p-2">
						<input type="password" class="form-control" name="password" placeholder="パスワード(確認)">
					</div>
				</div>

                <div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">権限</label>
					</div>
					<div class="col-6 p-2">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                            <label class="form-check-label" for="inlineRadio1">権限なし</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                            <label class="form-check-label" for="inlineRadio2">売上一覧</label>
                          </div>
                          <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
                            <label class="form-check-label" for="inlineRadio3">売上担当</label>
                          </div>
                           <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio4" value="option4">
                            <label class="form-check-label" for="inlineRadio4">管理者</label>
                          </div>
					</div>
				</div>

				<div class="d-grid gap-2 d-md-flex justify-content-center p-2">
					  <button class="btn btn-danger" type="submit" href="Sales0011check_Servlet">✓OK</button>
					  <a class="btn btn-light" href="#">キャンセル</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
