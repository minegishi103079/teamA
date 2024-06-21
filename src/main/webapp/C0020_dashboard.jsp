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
</body>
</html>

