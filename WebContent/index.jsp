<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/member.css" rel="stylesheet">
</head>
<body>
<jsp:include page="./include/header.jsp" />
<jsp:include page="./include/nav.jsp" />

<section>
	<h3>쇼핑몰 회원 관리 프로그램</h3>
	<p>쇼핑몰 회원정보와 회원 매출 정보 데이터베이스를 구축한다.</p>
	<ol>
		<li>회원정보 테이블을 생성한다.</li>
		<li>매출정보 테이블을 생성한다.</li>
		<li>회원정보, 매출정보 테이블에 제시된 문제지의 지문을 확인한다.</li>
		<li>회원정보 입력 화면프로그램을 작성한다.</li>
		<li>회원정보 조회 프로그램</li>
		<li>회원매출정보 조회</li>
	</ol>
</section>

<jsp:include page="./include/footer.jsp" />
</body>
</html>