package com.ezen.controller.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.BookDAO;
import com.ezen.dao.WishDAO;
import com.ezen.dto.MemberVO;
import com.ezen.dto.WishlistsVO;

public class WishListForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {

		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		String memberid = vo.getMemberid();
		
		WishDAO wdao = WishDAO.getInstance();
		List<WishlistsVO> Wvo = new ArrayList<WishlistsVO>();	
				
			Wvo=wdao.getwish(memberid);
		
		for (WishlistsVO VO : Wvo) {
			System.out.println("누고!!!!!!!!!!!!>" + VO);
		}
		
		
		request.setAttribute("mywish", Wvo);
		
		
		
		String url = "WishList.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
		
	}

}
