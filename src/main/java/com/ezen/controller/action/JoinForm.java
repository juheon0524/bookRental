package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;


public class JoinForm implements Action {

	@Override
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		MemberVO vo = new MemberVO();
		vo.setMemberid(request.getParameter("memberid")); 
		vo.setMembername(request.getParameter("membername"));
		vo.setPostalcode(request.getParameter("postalcode"));
		vo.setPostaladdress(request.getParameter("postaladdress"));
		vo.setDetailaddress(request.getParameter("detailaddress"));
		vo.setMphone(request.getParameter("mphone"));
		vo.setBirthdate(request.getParameter("birthdate"));
		vo.setPasscode(request.getParameter("passcode"));
		vo.setEmail(request.getParameter("email"));
		
		
		MemberDAO ldao = MemberDAO.getInstance();
		int result = ldao.joinMember(vo);
		System.out.println("result >>>>>>>>" + result);
		if (result == 1) {
			request.setAttribute("join", 2);
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		}else {
			request.setAttribute("join", 1);
			RequestDispatcher dis = request.getRequestDispatcher("join.jsp");
			dis.forward(request, response);
			
		}

	}
}
