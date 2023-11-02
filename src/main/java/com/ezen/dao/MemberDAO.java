package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.ezen.dto.MemberVO;
import com.ezen.util.DBManager;



public class MemberDAO {
	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	
	public int joinMember(MemberVO vo) {  
		String sql = "insert into Member "
				+ "(memberid, membername, postalcode, "
				+ "postaladdress, detailaddress, mphone, birthdate, "
				+ "passcode, email, statuscode, memberflag, joindate)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMemberid());
			pstmt.setString(2, vo.getMembername());
			pstmt.setString(3, vo.getPostalcode());
			pstmt.setString(4, vo.getPostaladdress());
			pstmt.setString(5, vo.getDetailaddress());
			pstmt.setString(6, vo.getMphone());
			pstmt.setString(7, vo.getBirthdate());
			pstmt.setString(8, vo.getPasscode());
			pstmt.setString(9, vo.getEmail());
			pstmt.setString(10, "active");
			pstmt.setString(11, "00");
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}



	public int selectid(String id) {
		String sql = "select * from member where memberid = ?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
}



	public String logincheck(String id) {
		
		String sql = "select passcode from member where memberid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String checkpw = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			checkpw = rs.getString("passcode");

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return checkpw;
	}
	



	public MemberVO getMember(String id) {
		String sql = "select * from member where memberid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String memberid = rs.getString("memberid");
				String membername = rs.getString("membername");
				String postalcode = rs.getString("postalcode");
				String postaladdress = rs.getString("detailaddress");
				String detailaddress = rs.getString("detailaddress");
				String mphone = rs.getString("mphone");
				String birthdate = rs.getString("birthdate");
				String passcode = rs.getString("passcode");
				String joindate = rs.getString("joindate");
				String email = rs.getString("email");
				String memberflag = rs.getString("memberflag");
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        
		        // 현재 날짜를 가져와서 형식에 맞게 포맷합니다.
		        LocalDate currentDate = LocalDate.now();
		        String formattedDate = currentDate.format(formatter);
				
				String lastlogindate = formattedDate;
				
				vo = new MemberVO();
				vo.setMembername(membername);
				vo.setMemberid(memberid);
				vo.setPostalcode(postalcode);
				vo.setPostaladdress(postaladdress);
				vo.setDetailaddress(detailaddress);
				vo.setMphone(mphone);
				vo.setBirthdate(birthdate);
				vo.setPasscode(passcode);
				vo.setJoindate(joindate);
				vo.setLastlogindate(lastlogindate);
				vo.setEmail(email);
				vo.setMemberflag(memberflag);
				
				updateJoindate(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return vo;
	}



	private void updateJoindate(MemberVO vo) {
		String sql = "update member set lastlogindate = ? where memberid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getLastlogindate());
			pstmt.setString(2, vo.getMemberid());
			pstmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}



	public int updateMember(MemberVO vo) {
		String sql = "update member set "
				+ "membername=?, postalcode=?, "
				+ "postaladdress=?, detailaddress=?, mphone=?, birthdate=?, "
				+ "email=? where memberid = ?";
					
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getMembername());
			pstmt.setString(2, vo.getPostalcode());
			pstmt.setString(3, vo.getPostaladdress());
			pstmt.setString(4, vo.getDetailaddress());
			pstmt.setString(5, vo.getMphone());
			pstmt.setString(6, vo.getBirthdate());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getMemberid());
			result = pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}



	public int updatePasscode(String pass1, String id) {
		String sql = "update member set passcode = ?  where memberid = ?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass1);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}



	public int deleteMember(String id) {
		int result = -1;
		String sql = "delete from member where memberid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

}