package com.ezen.controller.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.BookDAO;
import com.ezen.dto.BookVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BookUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		ServletContext context =  request.getSession().getServletContext();
		String path = context.getRealPath("image");
		int sizeLimit = 20*1024*1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(
				request, 
				path,
				sizeLimit,
				encType,
				new DefaultFileRenamePolicy()
				);
//		String code = multi.getParameter("code");
//		String name = multi.getParameter("name");
//		int price = Integer.parseInt(multi.getParameter("price"));
//		String description = multi.getParameter("description");
		String bookimgurl = multi.getFilesystemName("bookimgurl");
		
		BookVO vo = new BookVO();
		
		vo.setIsbn(multi.getParameter("isbn"));
		vo.setTitle(multi.getParameter("title"));
		vo.setGenrecode(multi.getParameter("genrecode"));
		vo.setAuthor(multi.getParameter("author"));
		vo.setPublisher(multi.getParameter("publisher"));
		vo.setPublisheddate(multi.getParameter("publisheddate"));
		vo.setTotbookcnt(Integer.parseInt(multi.getParameter("totbookcnt")));
		vo.setRentedbookcnt(Integer.parseInt(multi.getParameter("rentedbookcnt")));
		vo.setCurbookcnt(Integer.parseInt(multi.getParameter("curbookcnt")));
		vo.setPrice(Integer.parseInt(multi.getParameter("price")));
		vo.setCumrentalcnt(Integer.parseInt(multi.getParameter("cumrentalcnt")));
		vo.setRegistereddate(multi.getParameter("registereddate"));
		vo.setMemberid(multi.getParameter("memberid"));
		if(bookimgurl == null) {
			bookimgurl = multi.getParameter("nomakeIMg");
		}
		vo.setBookimgurl(bookimgurl);
		vo.setBookcontent(multi.getParameter("bookcontent"));

		System.out.println("BookVO " +  vo);
		System.out.println("Path " +  path);
		
		BookDAO bDao = BookDAO.getInstance();
		int result = bDao.updateBook(vo);
		
		if(result == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('수정되었습니다.'); location.href='BookServlet?command=admin_main'; </script>");
			out.close();
	        return;
		}

//		if(result == 1) {
//			new BookListAction().execute(request, response);
//		}
	}

}
