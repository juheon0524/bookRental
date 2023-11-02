package com.ezen.controller.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.SubscrDAO;
import com.ezen.dto.MemberVO;
import com.ezen.dto.SubscrVO;

public class SubscrListAction implements Action {

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
		
		
		String url = "/subscrList.jsp";
		
		SubscrDAO sDao = SubscrDAO.getInstance();
		
		List<SubscrVO> subscrList = sDao.selectAllSubscrByRdate();
		
		request.setAttribute("subscrList",  subscrList);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
