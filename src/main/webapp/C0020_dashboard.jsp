<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-quiv="Content-Type" content="text/html;" charset="UTF-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/active.css" type="text/css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<title>ダッシュボード</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>


<div class="row">
	<div class="m-5 col-auto" style="width: 600px; height: auto;">
	
	 <script type="text/javascript">
	  var a1 = <c:out value="${monthly.get(0)}" />;
	  var a2 = ${monthly.get(1)};
	  var a3 = ${monthly.get(2)};
	  var a4 = ${monthly.get(3)};
	  var a5 = ${monthly.get(4)};
	  var a6 = ${monthly.get(5)};
	  var a7 = ${monthly.get(6)};
	  var a8 = ${monthly.get(7)};
	  var a9 = ${monthly.get(8)};
	  var a10 = ${monthly.get(9)};
	  var a11 = ${monthly.get(10)};
	  var a12 = ${monthly.get(11)};
	</script>
	 <canvas id="lineChart"></canvas>
	  <script type="text/javascript" src="js/monthlySale.js"></script>
	  
	</div>
	
	<div class="m-5 col-auto" style="width: 600px; height: auto;">
	<!-- <script type="text/javascript">
	  var category = <c:out value="${category}" />;
	</script>
	<canvas id="barChart"></canvas>
	  <script type="text/javascript" src="js/categorizedSale.js"></script>
	 -->
	<canvas id="barChart"></canvas>
	<script>
	//キャンバスの要素を取得
	const ctxt = document.getElementById('barChart').getContext('2d');
	
	// 棒グラフを作成
	const myBarChart = new Chart(ctxt, {
	  type: 'bar', // グラフの種類を指定
	  data: {
	    labels: [<c:forEach var="list" items="${category}">'<c:out value="${list.getCategory_name()}" />', </c:forEach>], // カテゴリ名を設定
	    datasets: [{
	      label: 'カテゴリー別売上', // データセットのラベルを設定
	      data: [<c:forEach var="list" items="${category}">'<c:out value="${list.getSum()}" />', </c:forEach>], // データを設定
	      backgroundColor: [ // 各棒の背景色を設定
	        'rgba(255, 99, 132, 0.5)',
	        'rgba(54, 162, 235, 0.5)',
	        'rgba(255, 206, 86, 0.5)',
	        'rgba(160, 255, 42, 0.5)',
	        'rgba(153, 102, 255, 0.5)',
	      ],
	      borderColor: [ // 各棒の枠線の色を設定
	        'rgba(255, 99, 132, 1)',
	        'rgba(54, 162, 235, 1)',
	        'rgba(255, 206, 86, 1)',
	        'rgba(160, 255, 42, 1)',
	        'rgba(153, 102, 255, 1)'
	      ],
	      borderWidth: 1 // 枠線の太さを設定
	    }]
	  },
	  options: {
	    scales: {
	      y: {
	        beginAtZero: true // Y軸の最小値を0に設定
	      }
	    }
	  }
	});
	</script>
	
	</div>
</div>	
</body>
</html>

