package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.BookVO;
import com.ezen.dto.WishlistsVO;
import com.ezen.util.DBManager;

public class WishDAO {
private WishDAO() {}
	
	private static WishDAO instance = new WishDAO();
	
	public static WishDAO getInstance() {
		return instance;
	}

	public int joinwish(WishlistsVO wvo) {
		String sql = "insert into WISHLIST (wishlistid, memberid, createdate, isbn) values(wishlist_seq.nextval,?,sysdate,?)";
		int join = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, wvo.getMemberid());
			pstmt.setString(2, wvo.getIsbn());
			join = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return join;
	}

	public List<WishlistsVO> getwish(String memberid) {
		List<WishlistsVO> wvo = new ArrayList<WishlistsVO>();
		String sql = "SELECT w.*, b.author, b.publisher, b.publisheddate, b.cumrentalcnt, b.curbookcnt, b.bookimgurl, b.title, avg_score.avg_score "
				+ "FROM wishlist w "
				+ "LEFT OUTER JOIN book b ON w.isbn = b.isbn "
				+ "LEFT OUTER JOIN "
				+ "(SELECT isbn, AVG(score) AS avg_score "
				+ "FROM ratings "
				+ "GROUP BY isbn) "
				+ "avg_score ON w.isbn = avg_score.isbn "
				+ "WHERE w.memberid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WishlistsVO vo = new WishlistsVO();
				vo.setWishlistid(Integer.parseInt(rs.getString("wishlistid")));
				vo.setIsbn(rs.getString("isbn"));
				vo.setMemberid(memberid);
				vo.setCreatedate(rs.getString("createdate"));
				vo.setAuthor(rs.getString("author"));
				vo.setPublisher(rs.getString("publisher"));
				vo.setPublisheddate("publisheddate");
				vo.setCumrentalcnt(rs.getInt("cumrentalcnt"));
				vo.setCurbookcnt(rs.getInt("curbookcnt"));
				vo.setBookimgurl(rs.getString("bookimgurl"));
				vo.setScore(rs.getInt("avg_score"));
				vo.setTitle(rs.getString("title"));
				wvo.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return wvo;
	}

	
	
	public int checkIsbn(String memberid, String isbn) {
	    String sql = "select isbn from wishlist where memberid = ?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int result = -1;

	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, memberid);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            String isbnFromDatabase = rs.getString("isbn");
	            if (isbnFromDatabase.equals(isbn)) {
	                result = 1;
	                break; // 일치하는 항목을 찾으면 루프를 종료합니다.
	            }
	        }
	        

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt);
	    }

	    return result;
	}

	public int deletewish(String memberid, String isbn) {
		 String sql = "delete from wishlist where ISBN = ? and memberid = ? ";
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    int result = -1;

		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, isbn);
		        pstmt.setString(2, memberid);
		        result = pstmt.executeUpdate();

		  
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt );
		    }

		    return result;

	}
}
