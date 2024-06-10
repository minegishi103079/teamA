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
	<div class="container-fluid">
		<div class="position-absolute top-50 start-50 translate-middle col-10">
			<h1>売上登録</h1>
			<form class="was-validated" action="Sale0010Registration_Servlet">

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
						<select class="form-select" name="Responsible" required>
							<option value="" disabled selected>選択してください</option>
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
						<select class="form-select" name="goodscategory" required>
							<option value="" disabled selected>選択してください</option>
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
					<button type="submit" class="btn btn-primary" href="Sale0010Registration_Servlet">✓登録</button>
				</div>

			</form>
		</div>
		<c:forEach var="SaleRegistration" items="${SaleRegistration}">
	            <tr>
					<td><c:out value="${salecheck.getSale_date()}" /></td>
					<td><c:out value="${salecheck.getAccount_id()}" /></td>
					<td><c:out value="${salecheck.getCategory_id()}" /></td>
					<td><c:out value="${salecheck.getTrade_id()}" /></td>
					<td><c:out value="${salecheck.getUnit_price()}" /></td>
					<td><c:out value="${salecheck.getSale_number()}" /></td>
					<td><c:out value="${salecheck.getNote()}" /></td>
				</tr>
		</c:forEach>
	</div>
</body>
</html>