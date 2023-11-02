package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.RatingsVO;
import com.ezen.util.DBManager;

public class RatingsDAO {

	private static RatingsDAO instance = new RatingsDAO();
	private RatingsDAO() {}
	
	public static RatingsDAO getInstance() {
		return instance;
	}

	public double selectScoreGroupByIsbn(String isbn) {

		String sql = "select isbn, round(avg(score),1) score from ratings "
				+ " where isbn = ?"
				+ " group by isbn  ";
		double score = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				score = rs.getDouble("score");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return score;
	}

	public List<RatingsVO> select3RatinsByIsbn(String isbn) {
		List<RatingsVO> ratingsList = new ArrayList<RatingsVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from (select * from ratings where isbn = ? order by score desc, writedate desc ) "
				+ " where rownum <= 3 ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RatingsVO vo = new RatingsVO();
				
				vo.setRatingsid(rs.getInt("ratingsid"));
				vo.setIsbn(rs.getString("isbn"));
				vo.setMemberid(rs.getString("memberid"));
				vo.setWritedate(rs.getString("writedate").substring(0, 10));
				vo.setContent(rs.getString("content"));
				vo.setScore(rs.getInt("Score"));
				
				ratingsList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return ratingsList;
	}
}
