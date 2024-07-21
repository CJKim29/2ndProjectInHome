<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item_list_Mybatis</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#box{
	width: 1600px;
	margin: auto;
	margin-top: 50px;
}

</style>

</head>
<body>
<div id="box">
	<table class="table table-bordered table-hover">
		<tr class="info">
			<th>이미지</th>
			<th>이름</th>
			<th>카테고리</th>
			<th>등급</th>
			<th>방어력</th>
			<th>내구도</th>
			<th>필요 힘</th>
			<th>요구 레벨</th>
			<th>옵션1</th>
			<th>옵션2</th>
			<th>옵션3</th>
			<th>옵션4</th>
			<th>옵션5</th>
			<th>옵션6</th>
			<th>옵션7</th>
			<th>옵션8</th>
			<th>옵션9</th>
		</tr>
		
		<!-- for(SawonVo vo : list) -->
		<c:forEach var="vo"  items="${ requestScope.list }">
	       <tr>
	       	  <td><img src="images/${ vo.filename }"></td>
	          <td>${ vo.name }</td>
	          <td>${ vo.category }</td>
	          <td>${ vo.grade }</td>
	          <td>${ vo.defence }</td>
	          <td>${ vo.durability }</td>
	          <td>${ vo.req_str }</td>
	          <td>${ vo.req_lev }</td>
	          <td>${ vo.option1 }</td>
	          <td>${ vo.option2 }</td>
	          <td>${ vo.option3 }</td>
	          <td>${ vo.option4 }</td>
	          <td>${ vo.option5 }</td>
	          <td>${ vo.option6 }</td>
	          <td>${ vo.option7 }</td>
	          <td>${ vo.option8 }</td>
	          <td>${ vo.option9 }</td>
	       </tr>
       </c:forEach>
	</table>
</div>
</body>
</html>