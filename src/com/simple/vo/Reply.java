package com.simple.vo;

import java.util.Date;

public class Reply {

	private int no;
	private String writer;
	private String content;
	private String delYn;
	private Date replyCreateDate;
	private int boardNo;
	
	public Reply() {}


	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDelYn() {
		return delYn;
	}


	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}


	public Date getReplyCreateDate() {
		return replyCreateDate;
	}


	public void setReplyCreateDate(Date replyCreateDate) {
		this.replyCreateDate = replyCreateDate;
	}


	@Override
	public String toString() {
		return "Reply [no=" + no + ", writer=" + writer + ", content=" + content + ", delYn=" + delYn
				+ ", replyCreateDate=" + replyCreateDate + ", boardNo=" + boardNo + "]";
	}
	
	
}