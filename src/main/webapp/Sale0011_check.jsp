<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>売上登録確認</title>
</head>
<body>
	<div class="container-fluid">
		<!-- <div class="position-absolute top-50 start-50 translate-middle col-10"> -->
		<div class="offset-1 col-10" style="margin-top: 10vh;">
			<h1>売上登録確認</h1>
			<form class="was-validated" action="Sales0011check_Servlet" method="post">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">販売日</label>
					</div>
					<div class="col-3 p-2">
						<input type="date" value="<c:out value="${sale_date}"></c:out>" 
							id="validationTextarea" class="col-4 form-control" name="sale_date" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label for="varidationTextarea" class="col-form-label">担当</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="account_id" readonly>
							<option value="<c:out value="${account_id}"></c:out>"><c:out value="${name}"></c:out></option>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">商品カテゴリー</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="category_id" readonly>
							<option value="<c:out value="${category_id}"></c:out>"><c:out value="${category_name}"></c:out></option>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">商品名</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea"  value="<c:out value="${trade_name}"></c:out>" id="validationTextarea"
							class="form-control" name="trade_name" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">単価</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea"  value="<c:out value="${unit_price}"></c:out>" id="validationTextarea"
							class="form-control" name="unit_price" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">個数</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea"  value="<c:out value="${sale_number}"></c:out>" id="validationTextarea"
							class="form-control" name="sale_number" readonly>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">小計</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" value="<c:out value="${unit_price * sale_number }"></c:out>" id="validationTextarea"
							class="form-control" name=""  readonly>
					</div>
				</div>
				<div class="row g-3 align-items">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="Textarea" class="col-form-label">備考</label>
					</div>
					<div class="col-6 p-2">
						<textarea class="form-control" id="Textarea" rows="3"
							name="note" readonly><c:out value="${note}"></c:out></textarea>
					</div>
				</div>
			
				 	<div class="d-grid gap-2 d-md-flex justify-content-center p-2">
					  <button class="btn btn-primary" type="submit" href="Sales0011check_Servlet">✓OK</button>
					  <a class="btn btn-secondary" type="button" href="Sale0010_Registration.jsp">キャンセル</a>
					</div>
			</form>
		</div>
	</div>
</body>
</html>

<!-- エラーメッセージは未完了--!>