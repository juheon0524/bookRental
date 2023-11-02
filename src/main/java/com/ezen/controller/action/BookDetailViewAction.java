package com.ezen.controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.BookDAO;
import com.ezen.dao.GenreDAO;
import com.ezen.dao.RatingsDAO;
import com.ezen.dto.BookVO;
import com.ezen.dto.MemberVO;
import com.ezen.dto.RatingsVO;

public class BookDetailViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String url = "/bookDetailView.jsp";
		String isbn = request.getParameter("isbn");
		
		BookDAO bDao = BookDAO.getInstance();
		BookVO book = bDao.selectOneByIsbn(isbn);
		
		GenreDAO gDao = GenreDAO.getInstance();
		String genreDesc = gDao.selectOneByGenrecode(book.getGenrecode());
		
		RatingsDAO rDao = RatingsDAO.getInstance();
		double score = rDao.selectScoreGroupByIsbn(isbn);
		
		List<RatingsVO> ratingslist = new ArrayList<RatingsVO>();
		ratingslist = rDao.select3RatinsByIsbn(isbn);
		
		request.setAttribute("bookVo",  book);
		request.setAttribute("bookScore",  score);
		request.setAttribute("bookGenre",  genreDesc);
		request.setAttribute("ratingsList", ratingslist);
		
		System.out.println("VO for bookdetail : " + book);
		System.out.println("score for bookdetail : " + score);
		System.out.println("genre for bookdetail : " + genreDesc);
		System.out.println("ratings for bookdetail : " + ratingslist);
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		System.out.println("맴버vo>>>>>>>>>" + vo);

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);

	}

}
