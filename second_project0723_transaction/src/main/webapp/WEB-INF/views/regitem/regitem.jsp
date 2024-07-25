<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reg_item</title>
<!--  Bootstrap  3.x  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.table{
	width: 800px;
}
.item_image{
	display: inline-block;
	width: 250px;
	height: 300px;
	vertical-align: top;
	margin-left: 100px;
}
</style>

<script type="text/javascript">
	
	function buy(reg_idx) {
		
		location.href="../transaction/list.do?reg_idx=" + reg_idx;
	}
</script>

</head>
<body>

<div id="box">
<form class="form-inline">
	
	<table class="table">
			<tr class="info">
				<th>아이템</th>
				<th>아이템명</th>
				<th>아이템가격</th>
				<th>등록시간</th>
				<th>구매여부</th>
			</tr>
			
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>
						<div class="item_image">
								<img src="../resources/images/${ vo.filename }">
							</div>
						</td>
					<td>${ vo.reg_name }</td>
					<td>${ vo.reg_price }</td>
					<td>${ vo.reg_date }</td>
					<td>
       					<input type="button" class="btn btn-success" value="구매" onclick="buy('${vo.reg_idx}');">
					</td>
				</tr>
			</c:forEach>
		</table>
</form>
</div>
</body>
</html>