package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ezen.dto.BookVO;
import com.ezen.dto.SubscrVO;
import com.ezen.util.DBManager;

public class SubscrDAO {

	private static SubscrDAO instance = new SubscrDAO();
	private SubscrDAO() {};
	
	public static SubscrDAO getInstance() {
		return instance;
	}

	public List<SubscrVO> selectAllSubscrByRdate() {
		List<SubscrVO> subscrList = new ArrayList<SubscrVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from subscr order by subscrid desc  " ;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SubscrVO vo = new SubscrVO();
				
				vo.setSubscrid(rs.getInt("subscrid"));
				vo.setSubscrname(rs.getString("subscrname"));
				vo.setPrice(rs.getInt("price"));
				vo.setSalefromdate(rs.getString("salefromdate").substring(0, 10));
				vo.setSaletodate(rs.getString("saletodate").substring(0, 10));
				vo.setSubscrperiod(rs.getInt("subscrperiod"));
				vo.setMemberid(rs.getString("memberid"));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setAllowedbookcnt(rs.getInt("allowedbookcnt"));
				
				subscrList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
	
		return subscrList;
	}

	public SubscrVO selectOneBySubscrid(int subscrid) {
		SubscrVO vo = new SubscrVO();
		String sql = "select * "
				+ " from subscr where subscrid = ?" ;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subscrid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setSubscrid(rs.getInt("subscrid"));
				vo.setSubscrname(rs.getString("subscrname"));
				vo.setPrice(rs.getInt("price"));
				vo.setSalefromdate(rs.getString("salefromdate").substring(0, 10));
				vo.setSaletodate(rs.getString("saletodate").substring(0, 10));
				vo.setSubscrperiod(rs.getInt("subscrperiod"));
				vo.setMemberid(rs.getString("memberid"));
				vo.setRegistereddate(rs.getString("registereddate").substring(0, 10));
				vo.setAllowedbookcnt(rs.getInt("allowedbookcnt"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
	}

	public int insertSubscr(SubscrVO vo) {
		
		String sql = "insert into subscr values(subscr_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, ? ) " ;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getSubscrname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getSalefromdate());
			pstmt.setString(4, vo.getSaletodate());
			pstmt.setInt(5, vo.getSubscrperiod());
			pstmt.setString(6, vo.getMemberid());
			pstmt.setInt(7, vo.getAllowedbookcnt());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int updateSubscr(SubscrVO vo) {
		String sql = "update subscr set subscrname=?, price=?, salefromdate=?, saletodate=?, subscrperiod=?, allowedbookcnt=?, "
				+ " memberid=?, registereddate=sysdate "
				+ " where subscrid = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getSubscrname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getSalefromdate());
			pstmt.setString(4, vo.getSaletodate());
			pstmt.setInt(5, vo.getSubscrperiod());
			pstmt.setInt(6, vo.getAllowedbookcnt());
			pstmt.setString(7, vo.getMemberid());
//			pstmt.setString(8, vo.getRegistereddate());
			pstmt.setInt(8, vo.getSubscrid());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int deleteSubscr(int delSubscrid) {

		String sql = "delete from subscr where subscrid = ?  ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, delSubscrid);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
}
