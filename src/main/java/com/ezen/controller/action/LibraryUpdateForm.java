package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

public class LibraryUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		MemberVO vo = new MemberVO();
		String id = request.getParameter("memberid");
		vo.setMemberid(id); 
		vo.setMembername(request.getParameter("membername"));
		vo.setPostalcode(request.getParameter("postalcode"));
		vo.setPostaladdress(request.getParameter("postaladdress"));
		vo.setDetailaddress(request.getParameter("detailaddress"));
		vo.setMphone(request.getParameter("mphone"));
		vo.setBirthdate(request.getParameter("birthdate"));
		vo.setEmail(request.getParameter("email"));
		String url = "update.jsp";
		
		MemberDAO ldao = MemberDAO.getInstance();
		int result = ldao.updateMember(vo);


		if (result == 1) {		
			vo = ldao.getMember(id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			url = "index.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
