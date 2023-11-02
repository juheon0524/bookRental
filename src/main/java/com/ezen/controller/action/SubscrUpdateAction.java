package com.ezen.controller.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BookDAO;
import com.ezen.dao.SubscrDAO;
import com.ezen.dto.BookVO;
import com.ezen.dto.SubscrVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class SubscrUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		SubscrVO vo = new SubscrVO();
		
		vo.setSubscrid(Integer.parseInt(request.getParameter("subscrid")));
		vo.setSubscrname(request.getParameter("subscrname"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setSalefromdate(request.getParameter("salefromdate"));
		vo.setSaletodate(request.getParameter("saletodate"));
		vo.setSubscrperiod(Integer.parseInt(request.getParameter("subscrperiod")));
		vo.setAllowedbookcnt(Integer.parseInt(request.getParameter("allowedbookcnt")));
		vo.setMemberid(request.getParameter("memberid"));
		vo.setRegistereddate(request.getParameter("registereddate"));

		System.out.println("SubscrVO " +  vo);
		
		SubscrDAO sDao = SubscrDAO.getInstance();
		int result = sDao.updateSubscr(vo);
		
		if(result == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('수정되었습니다.'); location.href='BookServlet?command=subscr_list'; </script>");
			out.close();
	        return;
		}

	}

}
