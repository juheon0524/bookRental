package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDAO;
import com.ezen.dto.MemberVO;


public class LoginCheck implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String pw = null;
		String id = null;
		String checkpw = null;
		id = request.getParameter("memberid");
		pw = request.getParameter("passcode");
		String url = "BookServlet?command=login-form";
		MemberDAO ldao = MemberDAO.getInstance();
		int result = ldao.selectid(id);
		HttpSession session = request.getSession();
		
		if(result == 1) {
			 checkpw = ldao.logincheck(id);

			 if (checkpw.equals(pw)) {
				
				url ="index.jsp";

				MemberVO vo = ldao.getMember(id);
				session.setAttribute("loginUser", vo);
			}else {
				session.setAttribute("message", 0);
				
						
				
			}
		}else{session.setAttribute("message", -1);}
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
