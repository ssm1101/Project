package com.yedam.rental;

import com.yedam.common.DAO;

public class RentalDAO extends DAO {
	private static RentalDAO rentalDao = null;

	private RentalDAO() {

	}

	public static RentalDAO getInstance() {
		if (rentalDao == null) {
			rentalDao = new RentalDAO();
		}
		return rentalDao;
	}

	// getRentalL()
	public int getRental(String id) {
		int result = 0;

		try {
			conn();
			String sql = "SELECT * FROM rental WHERE member_id=?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
	
	// getRentalL()
	public int getRentalBook(String id) {
		int result = 0;

		try {
			conn();
			String sql = "SELECT * FROM rental WHERE book_no=?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// insertRentalBook()
	public int insertRentalBook(Rental rental) {

		int result = 0;

		try {
			conn();
			String sql = "INSERT INTO rental VALUES(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rental.getMemberId());
			pstmt.setString(2, rental.getBookNo());
			pstmt.setString(3, rental.getRentDate());
			pstmt.setString(4, rental.getReturnDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// deleteRentalBook()
	public int deleteRentalBook(String no) {

		int result = 0;

		try {
			conn();
			String sql = "DELETE FROM rental WHERE book_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
