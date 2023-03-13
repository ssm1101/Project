package com.yedam.board;

public class Board {

	// board_no int
	// board_title String
	// board_con String
	// member_id String
	// board_date String

	private int boardNo;
	private String boardTitle;
	private String boardCon;
	private String memberId;
	private String boardDate;

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardCon() {
		return boardCon;
	}

	public void setBoardCon(String boardCon) {
		this.boardCon = boardCon;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

}
