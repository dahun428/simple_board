package com.simple.vo;

import java.util.Date;

public class Board {

	private int no;
	private String title;
	private String writer;
	private String content;
	private int hit;
	private int replyCnt;
	private String delYn;
	private Date boardCreateDate;

	public Board() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public Date getBoardCreateDate() {
		return boardCreateDate;
	}

	public void setBoardCreateDate(Date boardCreateDate) {
		this.boardCreateDate = boardCreateDate;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", hit=" + hit
				+ ", replyCnt=" + replyCnt + ", delYn=" + delYn + ", boardCreateDate=" + boardCreateDate + "]";
	}
	
	
}
