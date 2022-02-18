package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("/RM")
public class RegisterMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼페이지 이동
		String url = "member/registerMember.jsp";
		
		// 회원 번호 자동생성
		MemberDAO mdao = MemberDAO.getInstance();
		int nextNumber = mdao.currentNumber();
		
		request.setAttribute("nextNumber", nextNumber);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼으로 부터 입력받은 데이터를 처리
		request.setCharacterEncoding("utf-8");
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Timestamp joindate = null;
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		

		try {
			String date = request.getParameter("joindate");
			System.out.println("날짜 : "+date);
			long date2 = new SimpleDateFormat("yyyyMMdd").parse(date).getTime();
			
			joindate = new Timestamp(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		MemberDTO mDto = new MemberDTO();
		mDto.setCustno(custno);
		mDto.setCustname(custname);
		mDto.setPhone(phone);
		mDto.setAddress(address);
		mDto.setJoindate(joindate);
		mDto.setGrade(grade);
		mDto.setCity(city);

		MemberDAO mdao = MemberDAO.getInstance();
		mdao.insertMember(mDto);
		
		response.sendRedirect("registerSuccess.jsp");
	}

}
