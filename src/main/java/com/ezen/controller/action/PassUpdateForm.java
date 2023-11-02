package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

public class PassUpdateForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String pw = request.getParameter("passcode");
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String id = loginUser.getMemberid();
		MemberDAO ldao = MemberDAO.getInstance();
		String result = ldao.logincheck(id);
		String url = "pwupdate.jsp";

		
		
		if (pw.equals(result)) {
			url = "pwupdate2.jsp";
		}else {
			request.setAttribute("su", -1);
		}

		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}


