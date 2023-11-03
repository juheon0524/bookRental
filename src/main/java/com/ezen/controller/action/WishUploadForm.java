package com.ezen.controller.action;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.ezen.dao.WishDAO;
import com.ezen.dto.MemberVO;
import com.ezen.dto.WishlistsVO;

public class WishUploadForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		String isbn = request.getParameter("isbn");
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		String memberid = vo.getMemberid();
		WishDAO wdao = WishDAO.getInstance();
		
		int result = wdao.checkIsbn(memberid, isbn);
		int value = Integer.parseInt(request.getParameter("value"));
		String url = null;
		if (value == 1) {
			url = "BookServlet?command=book_dlist";
		}else if(value == 2) {
			url = "BookServlet?command=book_plist";
		}else if(value == 3) {
			url = "BookServlet?command=book_detail_view&isbn=" + isbn;
		}
	
		
		
		
		System.out.println("result 누고 니 누고믿고 이래 시건방지게 구는기고?>>>>>"+ result);
		
		if (result == 1) {
			//위시리스트에 있는 책일 때.
			request.setAttribute("wishSu", 1);
			//이따가 이미 찜하신 도서입니다.라고 출력할 거임 
		} else {
			//위시리스트에 없는 책일 때.
			WishlistsVO Wvo = new WishlistsVO();
			Wvo.setIsbn(isbn);
			Wvo.setMemberid(memberid);

			int join = wdao.joinwish(Wvo);
			System.out.println("쪼인 잘됐냐? join>>>>>>>>>" + join);
			if (join == 1) {
				//책 추가 완료 되면
				request.setAttribute("wishSu", 2);
			}
			
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		
		
	}

}
