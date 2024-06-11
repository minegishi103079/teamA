<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="Dashboard.jsp"></jsp:include>



	<div class="container-fluid">

		<div class="position-absolute top-50 start-50 translate-middle col-10">
			<h1>売上検索条件入力</h1>
			
			<form class="was-validated" name="form" action="Sales0021" method="post">
			<!-- formタグの中身確認！actionのなか書く -->

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label class="col-form-label">販売日</label>
					</div>

					<div class="col-6 p-2">
						<div class="row">
							<div class="col-5 p-2">
								<input type="date" class="col-4 form-control" name="date1"
									placeholder="yyyy/mm/dd">
							</div>
							<div class="col-2 p-2 ">
								<label class="d-flex justify-content-center">～</label>
							</div>

							<div class="col-5 p-2">

								<input type="date" class="col-4 form-control" name="date2"
									placeholder="yyyy/mm/dd">
							</div>
						</div>
					</div>

				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse ">
						<label class="col-form-label">担当</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" aria-label="select example"
							name="Responsible" placeholder="選択してください">
							<option value=""></option>
							<option value="高">高</option>
							<option value="中">中</option>
							<option value="低">低</option>
						</select>
					</div>
				</div>

				<div class="row align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label class="col-form-label">商品カテゴリー</label>
					</div>
					<div class="col-6 p-2">
						<select class="form-select" aria-label="select example"
							name="goodscategory" placeholder="選択してください">
							<option value=""></option>
							<option value="高">高</option>
							<option value="中">中</option>
							<option value="低">低</option>
						</select>
					</div>
				</div>

				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label class="col-form-label">商品名
							<button type="button" class="btn btn-secondary btn-sm" disabled>部分一致</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" class="form-control" name="goodsname"
							placeholder="商品名">
					</div>
				</div>


				<div class="row g-3 align-items-center">
					<div class="col-4 d-flex flex-row-reverse">
						<label class="col-form-label">備考
							<button type="button" class="btn btn-secondary btn-sm" disabled>部分一致</button>
						</label>
					</div>
					<div class="col-6 p-2">
						<input type="textarea" class="form-control" placeholder="備考"></input>
					</div>
				</div>

				<div class="d-grid gap-2 d-md-flex justify-content-center mt-2">
					<button type="submit" class="btn btn-primary">検索</button>
					<button type="submit" class="btn btn-light">クリア</button>
				</div>

			</form>
		</div>
	</div>
</body>
</html>

<!-- 
・チェックのエラーメッセージ（販売日、件数）
・検索、クリアボタンのリンクの指定
・nameは適当なのでわかりやすいものに変更したほうがいいかも
 -->