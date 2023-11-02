package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ezen.dao.MemberDAO;

public class IdCheckForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		String id = request.getParameter("memberid");
		

		MemberDAO ldao = MemberDAO.getInstance();
		int result = ldao.selectid(id);
		
		
		
		request.setAttribute("result", result);
		request.setAttribute("memberid", id);
		
		RequestDispatcher dis = request.getRequestDispatcher("idCheck.jsp");
		dis.forward(request, response);
	}

}
