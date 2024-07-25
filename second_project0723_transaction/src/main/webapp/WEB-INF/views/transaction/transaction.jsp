<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transaction</title>
<!--  Bootstrap  3.x  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.table{
	width: 200px;
}
</style>

<script type="text/javascript">
	
	function transaction() {
		
		const transaction_point = $("#transaction_point").val();
		
		$.ajax({
			url		:	"transaction.do",
			data	:	{"transaction_point":transaction_point},
			success	:	function(res_data){
				
				location.reload(); // 페이지를 새로고침
			},
			error	:	function(err){
				alert(err.responseText)
			}
		});
	}//end:transaction()
	
	function charge() {
		
		const charge_point = $("#charge_point").val();
		
		$.ajax({
			url		:	"transaction_charge.do",
			data	:	{"charge_point":charge_point},
			success	:	function(res_data){
				
				location.reload(); // 페이지를 새로고침
			},
			error	:	function(err){
				alert(err.responseText)
			}
		});
	}//end:charge()
	
</script>
  	

</head>
<body>

<div id="box">
<form class="form-inline">
	
	<table class="table">
			<tr class="info">
				<th>고객명</th>
				<th>계좌잔액</th>
			</tr>
			
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.mem_id }</td>
					<td>${ vo.inc_point - vo.dec_point }</td>
				</tr>
			</c:forEach>
		</table>
		거래금액 : <input id="transaction_point" class="form-control"><br><br>
       	거래 후 잔액 : <input id="after_transaction" class="form-control">
       	<input type="button" class="btn btn-success" value="거래" onclick="transaction();"><br><br>
			
		충전하실 금액 : <input id="charge_point" class="form-control">
       	<input type="button" class="btn btn-danger" value="충전" onclick="charge();">
	
</form>
</div>
</body>
</html>