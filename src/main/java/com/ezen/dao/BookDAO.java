package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.BookVO;
import com.ezen.util.DBManager;

public class BookDAO {

	private static BookDAO instance = new BookDAO();
	private BookDAO() {}
	
	public static BookDAO getInstance() {
		return instance;
	}

	public BookVO selectOneByIsbn(String isbn) {
		BookVO vo = new BookVO();
		String sql = "select * "
				+ " from book where isbn = ?" ;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setGenrecode(rs.getString("genrecode"));
				vo.setAuthor(rs.getString("author"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPublisheddate(rs.getString("publisheddate").substring(0, 10));
				vo.setTotbookcnt(rs.getInt("totbookcnt"));
				vo.setRentedbookcnt(rs.getInt("rentedbookcnt"));
				vo.setCurbookcnt(rs.getInt("curbookcnt"));
				vo.setPrice(rs.getInt("price"));
				vo.setCumrentalcnt(rs.getInt("cumrentalcnt"));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setMemberid(rs.getString("memberid"));
				vo.setBookimgurl(rs.getString("bookimgurl"));
				vo.setBookcontent(rs.getString("bookcontent"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
	}

	
	public List<BookVO> selectAllBooksByRentalCnt() {
		List<BookVO> bookList = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select b.*, (select round(avg(score),1) from ratings r where b.isbn = r.isbn group by b.isbn) score "
				+ " from book b "
				+ " order by cumrentalcnt desc ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setGenrecode(rs.getString("genrecode"));
				vo.setAuthor(rs.getString("author"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPublisheddate(rs.getString("publisheddate").substring(0, 10));
				vo.setTotbookcnt(Integer.parseInt(rs.getString("totbookcnt")));
				vo.setRentedbookcnt(Integer.parseInt(rs.getString("rentedbookcnt")));
				vo.setCurbookcnt(Integer.parseInt(rs.getString("curbookcnt")));
				vo.setCumrentalcnt(Integer.parseInt(rs.getString("cumrentalcnt")));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setMemberid(rs.getString("memberid"));
				vo.setBookimgurl(rs.getString("bookimgurl"));
				vo.setBookcontent(rs.getString("bookcontent"));
				vo.setScore(rs.getDouble("score"));
				
				bookList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return bookList;
	}

	public List<BookVO> selectAllBooksByRentalCnt(int start, int end) {
		List<BookVO> bookList = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from "
				+ "( select rownum rnum, imsi.* from " 
				+ "( select b.*, (select round(avg(score),1) from ratings r where b.isbn = r.isbn group by b.isbn) score " 
				+ " from book b "
				+ " order by cumrentalcnt desc) imsi ) "
				+ " where rnum >= ? and rnum <= ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setGenrecode(rs.getString("genrecode"));
				vo.setAuthor(rs.getString("author"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPublisheddate(rs.getString("publisheddate").substring(0, 10));
				vo.setTotbookcnt(Integer.parseInt(rs.getString("totbookcnt")));
				vo.setRentedbookcnt(Integer.parseInt(rs.getString("rentedbookcnt")));
				vo.setCurbookcnt(Integer.parseInt(rs.getString("curbookcnt")));
				vo.setCumrentalcnt(Integer.parseInt(rs.getString("cumrentalcnt")));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setMemberid(rs.getString("memberid"));
				vo.setBookimgurl(rs.getString("bookimgurl"));
				vo.setBookcontent(rs.getString("bookcontent"));
				vo.setScore(rs.getDouble("score"));
				
				bookList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return bookList;
	}


	
	public List<BookVO> select5BooksByRentalCnt() {
		List<BookVO> bookList = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from ( select b.*, (select round(avg(score),1) from ratings r where b.isbn = r.isbn group by b.isbn) score "
				+ " from book b "
				+ " order by cumrentalcnt desc) "
				+ " where rownum <= 5 ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setGenrecode(rs.getString("genrecode"));
				vo.setAuthor(rs.getString("author"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPublisheddate(rs.getString("publisheddate").substring(0, 10));
				vo.setTotbookcnt(Integer.parseInt(rs.getString("totbookcnt")));
				vo.setRentedbookcnt(Integer.parseInt(rs.getString("rentedbookcnt")));
				vo.setCurbookcnt(Integer.parseInt(rs.getString("curbookcnt")));
				vo.setCumrentalcnt(Integer.parseInt(rs.getString("cumrentalcnt")));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setMemberid(rs.getString("memberid"));
				vo.setBookimgurl(rs.getString("bookimgurl"));
				vo.setBookcontent(rs.getString("bookcontent"));
				vo.setScore(rs.getDouble("score"));
				
				bookList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return bookList;
	}


	public List<BookVO> selectAllBooksByPublisheddate() {
		List<BookVO> bookList = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select b.*, (select round(avg(score),1) from ratings r where b.isbn = r.isbn group by b.isbn) score "
				+ " from book b "
				+ " order by publisheddate desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setGenrecode(rs.getString("genrecode"));
				vo.setAuthor(rs.getString("author"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPublisheddate(rs.getString("publisheddate").substring(0, 10));
				vo.setTotbookcnt(Integer.parseInt(rs.getString("totbookcnt")));
				vo.setRentedbookcnt(Integer.parseInt(rs.getString("rentedbookcnt")));
				vo.setCurbookcnt(Integer.parseInt(rs.getString("curbookcnt")));
				vo.setCumrentalcnt(Integer.parseInt(rs.getString("cumrentalcnt")));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setMemberid(rs.getString("memberid"));
				vo.setBookimgurl(rs.getString("bookimgurl"));
				vo.setBookcontent(rs.getString("bookcontent"));
				vo.setScore(rs.getDouble("score"));
				
				bookList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return bookList;
	}
	
	public List<BookVO> select5BooksByPublisheddate() {
		List<BookVO> bookList = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from (select b.*, (select round(avg(score),1) from ratings r where b.isbn = r.isbn group by b.isbn) score "
				+ " from book b "
				+ " order by publisheddate desc) "
				+ " where rownum <= 5 ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setGenrecode(rs.getString("genrecode"));
				vo.setAuthor(rs.getString("author"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPublisheddate(rs.getString("publisheddate").substring(0, 10));
				vo.setTotbookcnt(Integer.parseInt(rs.getString("totbookcnt")));
				vo.setRentedbookcnt(Integer.parseInt(rs.getString("rentedbookcnt")));
				vo.setCurbookcnt(Integer.parseInt(rs.getString("curbookcnt")));
				vo.setCumrentalcnt(Integer.parseInt(rs.getString("cumrentalcnt")));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setMemberid(rs.getString("memberid"));
				vo.setBookimgurl(rs.getString("bookimgurl"));
				vo.setBookcontent(rs.getString("bookcontent"));
				vo.setScore(rs.getDouble("score"));
				
				bookList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return bookList;
	}
	
	
	public List<BookVO> selectAllBooksByPublisheddate(int start, int end) {
		List<BookVO> bookList = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from "
				+ "( select rownum rnum, imsi.* from " 
				+ "( select b.*, (select round(avg(score),1) from ratings r where b.isbn = r.isbn group by b.isbn) score " 
				+ " from book b "
				+ " order by publisheddate desc) imsi ) "
				+ " where rnum >= ? and rnum <= ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setGenrecode(rs.getString("genrecode"));
				vo.setAuthor(rs.getString("author"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPublisheddate(rs.getString("publisheddate").substring(0, 10));
				vo.setTotbookcnt(Integer.parseInt(rs.getString("totbookcnt")));
				vo.setRentedbookcnt(Integer.parseInt(rs.getString("rentedbookcnt")));
				vo.setCurbookcnt(Integer.parseInt(rs.getString("curbookcnt")));
				vo.setCumrentalcnt(Integer.parseInt(rs.getString("cumrentalcnt")));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setMemberid(rs.getString("memberid"));
				vo.setBookimgurl(rs.getString("bookimgurl"));
				vo.setBookcontent(rs.getString("bookcontent"));
				vo.setScore(rs.getDouble("score"));
				
				bookList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return bookList;
	}
	
	public int insertBook(BookVO vo) {
		String sql = "insert into book values(?, ?, ?, ?, ?, ?, ?, "
				+ " ?, ?, ?, ?, ?, ?, ?, ? )" ; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getIsbn());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getGenrecode());
			pstmt.setString(4, vo.getAuthor());
			pstmt.setString(5, vo.getPublisher());
			pstmt.setString(6, vo.getPublisheddate());
			pstmt.setInt(7, vo.getTotbookcnt());
			pstmt.setInt(8, vo.getRentedbookcnt());
			pstmt.setInt(9, vo.getCurbookcnt());
			pstmt.setInt(10, vo.getPrice());
			pstmt.setInt(11, vo.getCumrentalcnt());
			pstmt.setString(12, vo.getRegistereddate());
			pstmt.setString(13, vo.getMemberid());
			pstmt.setString(14, vo.getBookimgurl());
			pstmt.setString(15, vo.getBookcontent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int updateBook(BookVO vo) {
		String sql = "update book set title=?, genrecode=?, author=?, publisher=?, publisheddate=?, totbookcnt=?, "
				+ " rentedbookcnt=?, curbookcnt=?, price=?, cumrentalcnt=?, registereddate=?, memberid=?, bookimgurl=?, bookcontent=? "
				+ " where isbn = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getGenrecode());
			pstmt.setString(3, vo.getAuthor());
			pstmt.setString(4, vo.getPublisher());
			pstmt.setString(5, vo.getPublisheddate());
			pstmt.setInt(6, vo.getTotbookcnt());
			pstmt.setInt(7, vo.getRentedbookcnt());
			pstmt.setInt(8, vo.getCurbookcnt());
			pstmt.setInt(9, vo.getPrice());
			pstmt.setInt(10, vo.getCumrentalcnt());
			pstmt.setString(11, vo.getRegistereddate());
			pstmt.setString(12, vo.getMemberid());
			pstmt.setString(13, vo.getBookimgurl());
			pstmt.setString(14, vo.getBookcontent());
			pstmt.setString(15, vo.getIsbn());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int bookCount() {
		String sql = "select count(*) bookcount from book  ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("bookcount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}

}
