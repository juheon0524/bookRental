package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ezen.util.DBManager;

public class GenreDAO {

	private static GenreDAO instance = new GenreDAO();
	private GenreDAO() {}
	
	public static GenreDAO getInstance() {
		return instance;
	}

	public String selectOneByGenrecode(String genrecode) {
		
		String sql = "select genredesc from genre where genrecode = ? ";

		String genredesc = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genrecode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				genredesc = rs.getString("genredesc");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return genredesc;
	}
}
