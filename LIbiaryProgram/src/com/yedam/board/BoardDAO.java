package com.yedam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.yedam.common.DAO;

public class BoardDAO extends DAO {

	Scanner sc = new Scanner(System.in);

	private static BoardDAO boardDao = null;

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		if (boardDao == null) {
			boardDao = new BoardDAO();
		}
		return boardDao;
	}

	// boardNo()
	public void boardNo() {

	}

	// createBoard()
	public int createBoard(Board board) {
		int result = 0;
		try {
			conn();
			String sql = "INSERT INTO board VALUES((SELECT NVL(MAX(TO_NUMBER(board_no)),0) FROM board)+1, ?, ?, ?, sysdate, 'N')";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardCon());
			pstmt.setString(3, board.getMemberId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// getBoardList()
	public List<Board> getBoardList() {
		List<Board> list = new ArrayList<>();
		Board board = null;

		try {
			conn();
			String sql = "SELECT * FROM board ORDER BY board_no";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardCon(rs.getString("board_con"));
				board.setMemberId(rs.getString("member_id"));
				board.setBoardDate(rs.getString("board_date"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// getBoard()
	public Board getBoard(int boardNo) {
		Board board = null;

		try {
			conn();
			String sql = "SELECT * FROM board WHERE board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new Board();
				board.setBoardDate(rs.getString("board_no"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardCon(rs.getString("board_con"));
				board.setMemberId(rs.getString("member_id"));
				board.setBoardDate(rs.getString("board_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return board;
	}

	// updateBoard()
	public int updateBoard(Board board) {
		int result = 0;

		try {
			conn();
			String sql = "UPDATE board SET board_title=?, board_con=?, board_date=sysdate WHERE board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardCon());
			pstmt.setInt(3, board.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// deleteBoard()
	public int deleteBoard(int no) {
		int result = 0;
		String sql = "";
		try {
			conn();
			sql = "DELETE FROM board WHERE board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			if (result == 1) {
				sql = "UPDATE board SET board_no=board_no-1 WHERE board_no>?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, no);
				result = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	public List<Board> getBoardListPaging(int page) {
		List<Board> list = new ArrayList<>();
		Board board = null;
		int start = page * 5 - 4;
		int end = page * 5;
		try {
			conn();
			String sql = "SELECT *\r\n" + "FROM (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT\r\n"
					+ "    FROM(SELECT *\r\n" + "        FROM board\r\n" + "            ORDER BY board_no)A)\r\n"
					+ "WHERE ?<=RNUM AND RNUM<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setBoardTitle(rs.getString("board_title"));
				board.setBoardCon(rs.getString("board_con"));
				board.setMemberId(rs.getString("member_id"));
				board.setBoardDate(rs.getString("board_date"));
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

}
