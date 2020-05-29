package com.simple.service;

import java.sql.SQLException;
import java.util.List;

import com.simple.dao.BoardDAO;
import com.simple.dao.ReplyDAO;
import com.simple.dao.UserDAO;
import com.simple.util.simpleBoardCheckFunction;
import com.simple.vo.Board;
import com.simple.vo.Reply;
import com.simple.vo.User;

public class simpleBoardService {

	ReplyDAO replyDao = new ReplyDAO();
	BoardDAO boardDao = new BoardDAO();
	UserDAO userDao = new UserDAO();
	
	public int addBoard(String title, String writer, String content) throws SQLException{
		System.out.println("addBoard");
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		boardDao.addBoard(board);
		return simpleBoardCheckFunction.BOARD_IS_SUCCESS;
	}
	public void upHit(int boardNo) throws SQLException {
		Board board = boardDao.getBoardByNo(boardNo);
		boardDao.upHit(board);
	}
	public int updateBoard(String title, String content, 	int no) throws SQLException{
		System.out.println("updateBoard");
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setNo(no);
		
		boardDao.updateBoard(board);
		return simpleBoardCheckFunction.BOARD_IS_SUCCESS;
	}
	public int deleteBoard(int boardNo, String userId) throws SQLException {
		System.out.println("deleteBoard");
		Board board = boardDao.getBoardByNo(boardNo);
		User user = userDao.getUserById(userId);
		if(user == null) {
			return simpleBoardCheckFunction.BOARD_IS_FAIL;
		}
		if("Y".equals(board.getDelYn())) {
			return simpleBoardCheckFunction.BOARD_IS_FAIL;
		}
		boardDao.deleteBoard(boardNo, userId);
		return simpleBoardCheckFunction.BOARD_IS_SUCCESS;
	}
	public List<Board> getAllBoard() throws SQLException {	
		return boardDao.retrieveAllBoard();
	}
	public Board getBoardByNo(int boardNo) throws SQLException{
		return boardDao.getBoardByNo(boardNo);
	}
	
	public int addNewReply(String writer, String content, int boardNo) throws SQLException {
		System.out.println("addNewReply");
		Board board = boardDao.getBoardByNo(boardNo);
		if(board == null) {
			return simpleBoardCheckFunction.REPLY_IS_FAIL;
		}
		Reply reply = new Reply();
		reply.setWriter(writer);
		reply.setContent(content);
		reply.setBoardNo(boardNo);
		replyDao.addNewReply(reply);
		
		boardDao.updateReplyCnt(reply.getBoardNo());
		return simpleBoardCheckFunction.REPLY_IS_SUCCESS;
	}
//	public void getReplyByBoardNo(int boardNo) {
//		replyDao.get
//	}
	public int updateReply(String content, String userId, int replyNo) throws SQLException {
		System.out.println("updateReply");
		Reply replyCheck = replyDao.getRelyByWriter(replyNo, userId);
		if("Y".equals(replyCheck.getDelYn())) {
			return simpleBoardCheckFunction.REPLY_IS_FAIL;
		}
		Reply reply = new Reply();
		reply.setNo(replyNo);
		reply.setContent(content);
		reply.setWriter(userId);
		
		replyDao.updateReply(reply);
		return simpleBoardCheckFunction.REPLY_IS_SUCCESS;
	}
	public int deleteReply(int no, String userId) throws SQLException {
		System.out.println("deleteReply");
		if(userDao.getUserById(userId) == null) {
			return simpleBoardCheckFunction.REPLY_IS_FAIL;
		}
		Reply reply = replyDao.getRelyByWriter(no, userId);
		if("Y".equals(reply.getDelYn())){
			return simpleBoardCheckFunction.REPLY_IS_FAIL;
		}
		replyDao.deleteReply(no, userId);
		return simpleBoardCheckFunction.REPLY_IS_SUCCESS;
	}
	public List<Reply> getAllReplyByBoardNo(int boardNo) throws SQLException {
		return replyDao.getAllReplyByBoardNo(boardNo);
	}
	public int userLogin(String userId, String pw) throws SQLException{
		System.out.println("userLogin");
		User user = userDao.getUserById(userId);
		if(user == null) {
			return simpleBoardCheckFunction.USER_NO_ID;
		}
		return simpleBoardCheckFunction.USER_IS_SUCCESS;
		
	}
	public User getUserById(String userId) throws SQLException{
		return userDao.getUserById(userId);
	}
	public int userSignUp(User user) throws SQLException {
		System.out.println("userSignUp");
		User userCheck = userDao.getUserById(user.getId());
		if(userCheck != null) {
			return simpleBoardCheckFunction.USER_EXIST_ID;
		}
		userDao.addUser(user);
		return simpleBoardCheckFunction.USER_IS_SUCCESS;
	}
	
	
}
