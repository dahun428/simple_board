package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.ConnUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Reply;
 

public class ReplyDAO {
	public void addNewReply(Reply reply) throws SQLException {
		String query = QueryUtil.getSQL("reply.addNewReply");
		Connection conn = ConnUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, reply.getWriter());
		pstmt.setString(2, reply.getContent());
		pstmt.setInt(3, reply.getBoardNo());
		
		pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
	}
//	public Reply getReplyByBoardNo(int boardNo) {
//		String query = QueryUtil.getSQL("reply.getRelyByWriter");
//		Connection conn = ConnUtil.getConnection();
//		PreparedStatement pstmt = conn.prepareStatement(query);
//		pstmt.setInt(1, no);
//		pstmt.setString(2, writer);
//		ResultSet rs = pstmt.executeQuery();
//		Reply reply = null;
//		if(rs.next()) {
//			reply = resultSetFun(rs);
//		}
//		if(rs!=null)rs.close();
//		if(pstmt!=null)pstmt.close();
//		if(conn!=null)conn.close();
//		return reply;
//	}

	public void deleteReply(int no, String writer) throws SQLException {
		String query = QueryUtil.getSQL("reply.deleteReply");
		Connection conn = ConnUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, no);
		pstmt.setString(2, writer);
		pstmt.executeUpdate();
		
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
	public void updateReply(Reply reply) throws SQLException {
		String query = QueryUtil.getSQL("reply.updateReply");
		Connection conn = ConnUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, reply.getContent());
		pstmt.setString(2, reply.getWriter());
		pstmt.setInt(3, reply.getNo());
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}
	public Reply getRelyByWriter(int no, String writer)  throws SQLException {
		String query = QueryUtil.getSQL("reply.getRelyByWriter");
		Connection conn = ConnUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, no);
		pstmt.setString(2, writer);
		ResultSet rs = pstmt.executeQuery();
		Reply reply = null;
		if(rs.next()) {
			reply = resultSetFun(rs);
		}
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
		return reply;
	}
	public List<Reply> getAllReplyByBoardNo(int boardNo) throws SQLException  {
		
		String query = QueryUtil.getSQL("reply.getAllReplyByBoardNo");
	
		List<Reply> replys = new ArrayList<Reply>();
		
		Connection conn = ConnUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Reply reply = resultSetFun(rs);
			replys.add(reply);
		}
		
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
		return replys;
	}
	
	private Reply resultSetFun(ResultSet rs) throws SQLException {
		Reply reply = new Reply();
		reply.setNo(rs.getInt("reply_no"));
		reply.setWriter(rs.getString("reply_writer"));
		reply.setReplyCreateDate(rs.getDate("reply_create_date"));
		reply.setContent(rs.getString("reply_content"));
		reply.setDelYn(rs.getString("reply_del_yn"));
		reply.setBoardNo(rs.getInt("board_no"));
		
		return reply;
	}
}

