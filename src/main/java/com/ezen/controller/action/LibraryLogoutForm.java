package com.ezen.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LibraryLogoutForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		HttpSession session = request.getSession(false); // 세션이 없으면 새로운 세션을 생성하지 않도록 getSession(false)를 사용

	    if (session != null) {
	        session.invalidate(); // 세션을 무효화
	    }

	    String url = "index.jsp";
	    response.sendRedirect(url);

	}

}
