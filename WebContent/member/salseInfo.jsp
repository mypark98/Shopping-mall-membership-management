<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/member.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../include/header.jsp" />
<jsp:include page="../include/nav.jsp" />
<section>
	<h3>회원 매출 조회</h3>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>회원이름</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
		<c:forEach var="salse" items="${list}">
			<tr>
				<td>${salse.custno}</td>
				<td>${salse.custname}</td>
				<td>
					<c:choose>
						<c:when test="${salse.grade=='A'}">VIP</c:when>
						<c:when test="${salse.grade=='B'}">일반</c:when>
						<c:when test="${salse.grade=='C'}">직원</c:when>
					</c:choose>
				</td>
				<td>${salse.sumsales}</td>
			</tr>
		</c:forEach>
	</table>
</section>
<jsp:include page="../include/footer.jsp" />
</body>
</html>