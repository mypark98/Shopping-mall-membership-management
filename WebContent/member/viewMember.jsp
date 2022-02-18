<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL을 사용하지 않는 경우 --%>
<%@ page import="java.util.List" %>
<%@ page import="dto.MemberDTO" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
	<%
		List<MemberDTO> list = (List)request.getAttribute("list");
		
		for(MemberDTO member:list){
	%>
		<tr>
			<td><a href="UM?custno=<%=member.getCustno()%>"><%=member.getCustno()%></a></td>
			<td><%=member.getCustname()%></td>
			<td><%=member.getPhone()%></td>
			<td><%=member.getAddress()%></td>
	<%
		String joinDate = new SimpleDateFormat("yyyy-MM-dd").format(member.getJoindate());
	%>
			<td><%=joinDate%></td>
	<%
		String grade = member.getGrade();//A,B,C
		String gradeName = null;// VIP, 일반, 직원
		
		switch(grade){
		case "A": gradeName="VIP";
			break;
		case "B": gradeName="일반";
			break;
		case "C": gradeName="직원";
			break;
		}

	%>
			<td><%=gradeName%></td>
			<td><%=member.getCity()%></td>
		</tr>
	<%
		}
	%>
	
	</table>

</section>
<jsp:include page="../include/footer.jsp" />
</body>
</html>





