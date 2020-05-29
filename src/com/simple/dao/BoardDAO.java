package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.ConnUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Board;

public class BoardDAO {


		public void addBoard(Board board) throws SQLException {
			
			String query = QueryUtil.getSQL("board.addBoard");
			Connection conn = ConnUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.executeUpdate();
			
			if(pstmt!= null)pstmt.close();
			if(conn!= null)conn.close();
		}
		public void upHit(Board board) throws SQLException {
			String query = QueryUtil.getSQL("board.upHit");
			Connection conn = ConnUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board.getHit()+1);
			pstmt.setInt(2, board.getNo());
			pstmt.executeUpdate();
			
			if(pstmt!= null)pstmt.close();
			if(conn!= null)conn.close();
		}
		public void updateReplyCnt(int no) throws SQLException  {
			String query = QueryUtil.getSQL("reply.deleteReply");
			Connection conn = ConnUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setInt(2, no);
			
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		public void updateBoard(Board board) throws SQLException{

			String query = QueryUtil.getSQL("board.updateBoardByBoardNo");
			Connection conn = ConnUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());
			pstmt.executeUpdate();
		
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			
		}
//		public boolean isExistBoard(int boardNo) throws SQLException {
//			String query = QueryUtil.getSQL("board.isExistBoard");
//			Connection conn = ConnUtil.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, boardNo);
//			ResultSet rs = pstmt.executeQuery();
//			if(rs.next()) {
//				return true;
//			}
//			
//			return false;
//		}
		public void deleteBoard(int boardNo, String writer) throws SQLException {
			String query = QueryUtil.getSQL("board.deleteBoard");
			Connection conn = ConnUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setInt(2, boardNo);
			pstmt.setString(3, writer);
			pstmt.executeUpdate();
			
		}
		public List<Board> retrieveAllBoard() throws SQLException {
			List<Board> boards = new ArrayList<Board>();
			
			String query = QueryUtil.getSQL("board.retrieveAllBoard");
			Connection conn = ConnUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				Board board = resultSetfunc(rs);
				boards.add(board);
			}
			
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
			return boards;
		}
		public Board getBoardByNo(int boardNo) throws SQLException {
			String query = QueryUtil.getSQL("board.getBoardByNo");
			Connection conn = ConnUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			Board board = null;
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				board = resultSetfunc(rs);
			}
			return board;
		}
		
		private Board resultSetfunc(ResultSet rs) throws SQLException {
			Board board = new Board();
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setHit(rs.getInt("board_hit"));
			board.setReplyCnt(rs.getInt("board_reply_cnt"));
			board.setDelYn(rs.getString("board_del_yn"));
			board.setBoardCreateDate(rs.getDate("board_create_date"));
			return board;
		}
		
		
		
	}
