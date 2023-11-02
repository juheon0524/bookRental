package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;

public class DeleteCheckForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String pw = request.getParameter("passcode");
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String id = loginUser.getMemberid();
		MemberDAO ldao = MemberDAO.getInstance();
		String result = ldao.logincheck(id);
		String url = "delete.jsp";

		
		
		if (pw.equals(result)) {
			int answer = ldao.deleteMember(id);
			System.out.println("1 잘 나오냐 >>>" + answer);
			url = "index.jsp";
		    session.invalidate(); // 세션을 무효화
		    response.sendRedirect(url); 
		}else {
			request.setAttribute("su", -1);
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}

		
		

	}


}
