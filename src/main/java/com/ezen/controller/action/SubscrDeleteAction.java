package com.ezen.controller.action;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.SubscrDAO;
import com.ezen.dto.SubscrVO;

public class SubscrDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {

		int delSubscrid = Integer.parseInt(request.getParameter("subscrid"));
		System.out.println("Delete subscrid : " + delSubscrid);
		
		SubscrDAO sDao = SubscrDAO.getInstance();
		int result = sDao.deleteSubscr(delSubscrid);
		
		if(result == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('삭제되었습니다.'); location.href='BookServlet?command=subscr_list'; </script>");
			out.close();
	        return;
		}
	}

}
