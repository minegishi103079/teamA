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
		<div class="container-fluid">
		<a class="navbar-brand" href="#">物品売上管理システム</a>
			<!-- <div class="hstack gap-3"> -->
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation" >
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav">
						<div class="p-1 ms-auto">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="C0020">ダッシュボード</a></li>
						</div>
						<div class="p-1 ms-auto">
							<li class="nav-item"><a class="nav-link" href="Sale0010Registration_Servlet">売上登録</a></li>
						</div>
						<div class="p-1 ms-auto">
							<li class="nav-item"><a class="nav-link" href="Sales0020">売上検索</a></li>
						</div>
						<div class="p-1 ms-auto">
							<li class="nav-item"><a class="nav-link" href="Accounts0030_RegistrationServlet">アカウント登録</a></li>
						</div>
						<div class="p-1 ms-auto">
							<li class="nav-item"><a class="nav-link" href="Accounts0040_SerchInputServlet">アカウント検索</a></li>
						</div>
		            	<div class="p-1 ms-auto position-absolute end-0">
		            		<li class="nav-item"><a class="nav-link" href="#">ログアウト</a></li>
		            	</div> 					
					</ul>
				</div>
		</div>
	</nav>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>

<!-- 選択したときに色変更できれば！ -->