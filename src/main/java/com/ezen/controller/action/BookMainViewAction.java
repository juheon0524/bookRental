package com.ezen.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BookDAO;
import com.ezen.dto.BookVO;

public class BookMainViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/bookMainView.jsp";
		
		BookDAO bDao = BookDAO.getInstance();
		List<BookVO> bookPList = bDao.select5BooksByRentalCnt();
		List<BookVO> bookDList = bDao.select5BooksByPublisheddate();
		
		request.setAttribute("bookPList",  bookPList);
		request.setAttribute("bookDList",  bookDList);

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
