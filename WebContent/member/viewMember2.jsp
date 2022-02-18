<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL을 활용한 방법 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<h3>회원목록 조회/수정</h3>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>고객등급</th>
			<th>거주지역</th>
		</tr>
		<c:forEach var="member" items="${list}">
			<tr>
				<td><a href="UM?custno=${member.custno}">${member.custno}</a></td>
				<td>${member.custname}</td>
				<td>${member.phone}</td>
				<td>${member.address}</td>
				<td>
					<fmt:formatDate value="${member.joindate}" pattern="yyyy-MM-dd"/>
				</td>
				<td>
					<c:choose>
						<c:when test="${member.grade=='A'}">VIP</c:when>
						<c:when test="${member.grade=='B'}">일반</c:when>
						<c:when test="${member.grade=='C'}">직원</c:when>
					</c:choose>
				</td>
				<td>${member.city}</td>
			</tr>
		</c:forEach>
	</table>
</section>
<jsp:include page="../include/footer.jsp" />
</body>
</html>