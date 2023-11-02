package com.ezen.util;

import javax.servlet.http.HttpServletRequest;

import com.ezen.dto.PageDTO;

public class BookService {

	public PageDTO pageCalcu(HttpServletRequest request, int bookCount) {

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int limit = request.getParameter("limit") == null ? 10 : Integer.parseInt(request.getParameter("limit"));
		
		PageDTO paging = new PageDTO();
		paging.calcu(page, limit, bookCount);
		
		return paging;
	}
}
