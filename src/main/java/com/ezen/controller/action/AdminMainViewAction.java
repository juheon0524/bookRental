package com.ezen.controller.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminMainViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/adminMain.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
