package com.ezen.controller.action;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BookDAO;
import com.ezen.dto.BookVO;
import com.ezen.dto.PageDTO;
import com.ezen.util.BookService;

public class BookDListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/bookDList.jsp";
		
		BookDAO bDao = BookDAO.getInstance();
		
		//page 관련 추가 시작
		BookService service = new BookService();
		int bookCount = bDao.bookCount();
		PageDTO paging = service.pageCalcu(request, bookCount);
		
		//page 관련 추가 종료
		
//		List<BookVO> bookList = bDao.selectAllBooksByPublisheddate();
		List<BookVO> bookList = bDao.selectAllBooksByPublisheddate(paging.getStartNum(),paging.getEndNum()); //page 관련 추가
		
		request.setAttribute("bookList",  bookList);
		request.setAttribute("paging", paging); 		//page 관련 추가
		request.setAttribute("bookCount",bookCount);	//page 관련 추가
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
