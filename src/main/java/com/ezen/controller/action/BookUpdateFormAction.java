package com.ezen.controller.action;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.BookDAO;
import com.ezen.dto.BookVO;
import com.ezen.dto.MemberVO;

public class BookUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {

		/* 로그인 session check start */
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
	
		if (mvo == null || mvo.getMemberflag().equals("00")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('관리자 메뉴입니다.'); location.href='BookServlet?command=book_main'; </script>");
			out.close();
	        return;
	    }
		/* 로그인 session check end */
		
		String url = "/bookUpdate.jsp";
		String isbn = request.getParameter("isbn");
		
		BookDAO bDao = BookDAO.getInstance();
		BookVO vo = bDao.selectOneByIsbn(isbn);
		System.out.println("BookVO : " + vo);
		request.setAttribute("book", vo);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
