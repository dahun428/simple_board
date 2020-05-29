package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simple.util.ConnUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.User;

public class UserDAO {
	public User getUserById(String userId) throws SQLException {
		
		User user = null;

		Connection conn = ConnUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			user = new User();
			user.setId(rs.getString("user_id"));
			user.setName(rs.getString("user_name"));
			user.setPassword(rs.getString("user_password"));
			user.setEmail(rs.getString("user_email"));
			user.setDisabled(rs.getString("user_disabled"));
			user.setUserCreateDate(rs.getDate("user_create_date"));
		}
		if(rs!=null)rs.next();
		if(pstmt!=null)pstmt.close();
		if(pstmt!=null)conn.close();

		return user;

	}
	public void addUser(User user) throws SQLException {
		Connection conn = ConnUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(QueryUtil.getSQL("user.addUser"));
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getEmail());
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn != null)conn.close();
		
	}
}
