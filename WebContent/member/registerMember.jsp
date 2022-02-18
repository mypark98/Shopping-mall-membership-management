<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/member.css" rel="stylesheet">
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/nav.jsp" />
<section>
	<h3>홈쇼핑 회원 등록</h3>
	<form action="RM" method="post" name="frm">
		<table border="1">
			<tr>
				<td>회원번호(자동발생)</td>
				<td> <input type="text" name="custno" id="custno" value="${nextNumber}" readonly> </td>
			</tr>
			<tr>
				<td>회원 성명</td>
				<td> <input type="text" name="custname" id="custname"  > </td>
			</tr>
			<tr>
				<td>회원 전화</td>
				<td> <input type="tel" name="phone" id="phone"  > </td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td> <input type="text" name="address" id="address"  > </td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td> <input type="date" name="joindate" id="joindate"  > </td>
			</tr>
			<tr>
				<td>고객등급(A:VIP, B:일반, C:직원)</td>
				<td> <input type="text" name="grade" id="grade"  > </td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td> <input type="text" name="city" id="city"  > </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록" onclick="return chkValue()">
					<input type="button" value="조회" onclick="location.href='VM'">
				</td>
			</tr>
		
		</table>
	
	
	</form>
</section>



<jsp:include page="../include/footer.jsp" />
</body>
</html>