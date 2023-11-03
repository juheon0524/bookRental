package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.WishDAO;
import com.ezen.dto.MemberVO;

public class WishDeleteForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		String memberid = vo.getMemberid();
		
		String isbn = request.getParameter("isbn");
		
		WishDAO wdao = WishDAO.getInstance();
		int result = wdao.deletewish(memberid, isbn);
		
		if (result == 1) {
			String url = "BookServlet?command=wish_lists";
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}

	}

}
