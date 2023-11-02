package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

public class PwUpdateSuccessForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String pass1 = request.getParameter("passcode");
		String pass2 = request.getParameter("passcode2");
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String id = loginUser.getMemberid();
		String url = "pwupdate2.jsp";
		
		if (pass1.equals(pass2)) {
			MemberDAO ldao = MemberDAO.getInstance();
			int result = ldao.updatePasscode(pass1,id);
			if (result == 1) {
				url = "index.jsp";
			}else {
		
			}
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

		
		
	}

}
