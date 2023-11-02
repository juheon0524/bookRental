package com.ezen.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LibraryLoginForm implements Action {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "login.jsp";
		response.sendRedirect(url);
	}

}
