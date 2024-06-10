<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<meta charset="UTF-8">
<title>売上登録</title>
</head>
<body>
	<h1>売上登録</h1>

	<div class="container-fluid">
		<div class="position-absolute top-50 start-50 translate-middle col-10">
			<form class="was-validated" action="#">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">販売日
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="date" id="validationTextarea"
							class="col-4 form-control" name="date" placeholder="yyyy/mm/dd"
							required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label for="varidationTextarea" class="col-form-label">担当
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" required aria-label="select example"
							name="Responsible" placeholder="選択してください" required>
							<option value=""></option>
							<option value="高">高</option>
							<option value="中">中</option>
							<option value="低">低</option>
						</select>
					</div>
				</div>

				<div class="row align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">商品カテゴリー
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" required aria-label="select example"
							name="goodscategory" placeholder="選択してください" required>
							<option value=""></option>
							<option value="高">高</option>
							<option value="中">中</option>
							<option value="低">低</option>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">商品名
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="validationTextarea"
							class="form-control" name="goodsname" placeholder="商品名" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">単価
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="validationTextarea"
							class="form-control" name="price" placeholder="単価" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">個数
							<button type="button" class="btn btn-secondary btn-sm" disabled>必須</button>
						</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="validationTextarea"
							class="form-control" name="quantity" placeholder="個数" required>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="varidationTextarea" class="col-form-label">備考</label>
					</div>
					<div class="col-6 p-2">
						<textarea class="form-control" id="validationTextarea"
							name="textarea" placeholder="備考" required></textarea>
					</div>
				</div>

				<div class="mx-auto p-2" style="width: 100px;">
					<button type="submit" class="btn btn-primary">✓登録</button>
				</div>

			</form>
		</div>
	</div>
</body>
</html>