<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<nav class="navbar navbar-expand-lg bg-body-tertiary" style="padding: 0px;">
		<div class="container-fluid">
		<a class="navbar-brand" href="#" style="padding: 13px;">物品売上管理システム</a>
			<!-- <div class="hstack gap-3"> -->
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation" >
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav">
						<div class="pt-2 pb-2 p-1 ms-auto<c:if test="${status == 0}" > active</c:if>">
							<li class="nav-item"><a class="nav-link" href="C0020">ダッシュボード</a></li>
						</div>
						<div class="pt-2 pb-2 p-1 ms-auto<c:if test="${status == 1}" > active</c:if>">
							<li class="nav-item"><a class="nav-link" href="Sales0010">売上登録</a></li>
						</div>
						<div class="pt-2 pb-2 p-1 ms-auto<c:if test="${status == 2}" > active</c:if>">
							<li class="nav-item"><a class="nav-link" href="Sales0020">売上検索</a></li>
						</div>
						<div class="pt-2 pb-2 p-1 ms-auto<c:if test="${status == 3}" > active</c:if>">
							<li class="nav-item"><a class="nav-link" href="Accounts0030">アカウント登録</a></li>
						</div>
						<div class="pt-2 pb-2 p-1 ms-auto<c:if test="${status == 4}" > active</c:if>">
							<li class="nav-item"><a class="nav-link" href="Accounts0040">アカウント検索</a></li>
						</div>

					</ul>
					<div class="pt-2 pb-2 p-1 ms-auto">
                        <li class="nav-item d-flex justify-content-end"><a class="nav-link" href="C0010_logout">ログアウト</a></li>
                    </div> 	
				</div>
		</div>
	</nav>
	<script src="js/bootstrap.bundle.min.js"></script>