<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title></title>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<a class="navbar-brand" href="#">物品売上管理システム</a>
		<div class="container-fluid">
			<div class="hstack gap-3">
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
				</button>
				<ul class="navbar-nav">
					<div class="p-2 ms-auto">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="C0020">ダッシュボード</a></li>
					</div>
					<div class="p-2 ms-auto">
						<li class="nav-item"><a class="nav-link" href="#">売上登録</a></li>
					</div>
					<div class="p-2 ms-auto">
						<li class="nav-item"><a class="nav-link" href="Sales0020">売上検索</a></li>
					</div>
					<div class="p-2 ms-auto">
						<li class="nav-item"><a class="nav-link" href="#">アカウント登録</a>
						</li>
					</div>
					<div class="p-2 ms-auto">
						<li class="nav-item"><a class="nav-link" href="#">アカウント検索</a>
						</li>
					</div>
				</ul>
			</div>

			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="#">ログアウト</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>

<!-- 選択したときに色変更できれば！ -->