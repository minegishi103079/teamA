<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<meta charset="UTF-8">
<title>売上詳細編集確認</title>
</head>

<body>
	<div class="container-fluid">
		<div class="position-absolute top-50 start-50 translate-middle col-10">
			<h1>売上詳細編集確認</h1>
			<form action="#">

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="date" class="col-form-label">販売日</label>
					</div>
					<div class="col-3 p-2">
						<input type="date" id="date" class="col-4 form-control"
							name="date" placeholder="yyyy/mm/dd" value="<c:out value="${ }"></c:out>" disabled >
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label for="account" class="col-form-label">担当
						</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="Responsible" id="account" disabled>
							<c:out value="${ }">
						</select>
					</div>
				</div>

				<div class="row align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="category" class="col-form-label">商品カテゴリー</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" name="goodscategory" id="category" disabled>
						<c:out value="${ }"></c:out>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="trade" class="col-form-label">商品名</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" id="trade" class="form-control"
							name="goodsname" value="<c:out value="${ }"></c:out>" placeholder="商品名" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="unit" class="col-form-label">単価</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="unit" class="form-control" name="price"
							value="<c:out value="${ }"></c:out>" placeholder="単価" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="num" class="col-form-label">個数</label>
					</div>
					<div class="col-3 p-2">
						<input type="textarea" id="num" class="form-control"name="quantity" value="<c:out value="${ }"></c:out>" placeholder="個数" disabled>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label for="note" class="col-form-label">備考</label>
					</div>
					<div class="col-6 p-2">
						<textarea class="form-control" id="note" name="textarea"placeholder="備考" disabled><c:out value="${}"></c:out></textarea>
					</div>
				</div>

				<div class="row d-flex justify-content-center mt-2">
					<div class="col-auto">
						<button type="submit" class="btn btn-primary" href="">✓OK</button>
					</div>
					<div class="col-auto">
						<button type="submit" class="btn btn-light" href="">キャンセル</button>
					</div>
				</div>
			</form>
		</div>

	</div>
</body>

</html>

<!--valueの中身
formactionとOKとキャンセルボタンのリンク先の指定  -->

