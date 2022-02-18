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

@WebServlet("/UM")
public class UpdateMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정 폼으로 이동
		int custno = Integer.parseInt(request.getParameter("custno"));
		
		MemberDAO mDao = MemberDAO.getInstance();
	    MemberDTO mDto = mDao.selectTargetMember(custno);
	    
	    request.setAttribute("member", mDto);
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("member/updateMember.jsp");
	    dispatcher.forward(request, response);
	    
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정된 데이터 반영
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
			long date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime();
			
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
		
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mDto);
		
		response.sendRedirect("updateSuccess.jsp");
		
		
		
		
		
		
	}

}
