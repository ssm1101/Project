package com.yedam.book;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;

public class BookDAO extends DAO {
	Scanner sc = new Scanner(System.in);
	private static BookDAO bookDao = null;

	private BookDAO() {

	}

	public static BookDAO getInstance() {
		if (bookDao == null) {
			bookDao = new BookDAO();
		}
		return bookDao;
	}

	// 책번호 중복체크
	public Book check(Book book) {
		try {
			conn();
			String sql = "SELECT * FROM book WHERE book_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookNo());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book();
				book.setBookNo(rs.getString("book_no"));
				book.setBookTitle(rs.getString("book_title"));
				book.setBookAut(rs.getString("book_aut"));
				book.setBookPub(rs.getString("book_pub"));
				book.setBookPrice(rs.getInt("book_price"));
			} else {
				book = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return book;
	}

	// insertBook()
	public int insertBook(Book book) {
		int result = 0;

		try {
			conn();
			String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookNo());
			pstmt.setString(2, book.getBookTitle());
			pstmt.setString(3, book.getBookAut());
			pstmt.setString(4, book.getBookPub());
			pstmt.setInt(5, book.getBookPrice());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// getBookList(),getMemberBookList()
	public List<Book> getBookList() {
		List<Book> list = new ArrayList<>();
		Book book = null;
		String sql = "";
		try {
			conn();
			if (MemberService.memberInfo.getMemberGrade().equals("M")) {
				sql = "SELECT * FROM book";

			} else if (MemberService.memberInfo.getMemberGrade().equals("N")) {
				sql = "SELECT *\r\n" + "FROM book b LEFT OUTER JOIN rental r\r\n" + "ON b.book_no=r.book_no\r\n"
						+ "WHERE r.book_no IS NULL";
			}

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				book = new Book();
				book.setBookNo(rs.getString("book_no"));
				book.setBookTitle(rs.getString("book_title"));
				book.setBookAut(rs.getString("book_aut"));
				book.setBookPub(rs.getString("book_pub"));
				if (MemberService.memberInfo.getMemberGrade().equals("M")) {
					book.setBookPrice(rs.getInt("book_price"));
				}
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// getBookNo(), getBookTitle()
	public List<Book> getBookSearch(Book book) {
		List<Book> list = new ArrayList<>();
		String sql = "";
		Book book1 = null;
		try {
			conn();
			if (MemberService.memberInfo.getMemberGrade().equals("M")) {
				sql = "SELECT * FROM book WHERE book_no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getBookNo());
				rs = pstmt.executeQuery();
			} else if (MemberService.memberInfo.getMemberGrade().equals("N")) {
				sql = "SELECT *\r\n" + "FROM book b LEFT OUTER JOIN rental r\r\n" + "ON b.book_no=r.book_no\r\n"
						+ "WHERE r.book_no IS NULL\r\n" + "AND b.book_title=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, book.getBookTitle());
				rs = pstmt.executeQuery();
			}

			while (rs.next()) {
				book1 = new Book();
				book1.setBookNo(rs.getString("book_no"));
				book1.setBookTitle(rs.getString("book_title"));
				book1.setBookAut(rs.getString("book_aut"));
				book1.setBookPub(rs.getString("book_pub"));
				book1.setBookPrice(rs.getInt("book_price"));
				list.add(book1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// getRentalBookList()
	public void getBookRentalList() {

		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();

		try {
			conn();
			String sql = "SELECT * \r\n" + "FROM book b JOIN rental r\r\n" + "ON b.book_no=r.book_no\r\n"
					+ "JOIN member m\r\n" + "ON r.member_id=m.member_id\r\n" + "WHERE r.rent_date IS NOT NULL";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Map<String, Object> map = new LinkedHashMap<>();
				map.put("책번호", rs.getString("book_no"));
				map.put("책제목", rs.getString("book_title"));
				map.put("저 자", rs.getString("book_aut"));
				map.put("출판사", rs.getString("book_pub"));
				map.put("회원번호", rs.getString("member_id"));
				map.put("이 름", rs.getString("member_name"));
				map.put("대여일", rs.getString("rent_date").substring(0,10));
				map.put("반납일", rs.getString("return_date").substring(0,10));
				listmap.add(map);
			}

			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			System.out.println("도서번호      책제목        저자          출판사        회원번호       이름         대여일       반납일");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			for (Map<String, Object> map : listmap) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					System.out.printf("%-12s",value);
				}
				System.out.println("\n");
			}
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

	// updateTitle(), updatePhone(), updateAdd(), updateName() - updateBook()
	public int updateBook(Book book) {

		int result = 0;

		try {
			conn();
			int updatePrice = 0;
			String update = "";
			String sql = "";
			if (book.getBookTitle().equals("0")) {
				sql = "UPDATE book SET book_title=? WHERE book_no=?";
				System.out.println("변경하실 도서명> ");
				update = sc.nextLine();
			} else if (book.getBookAut().equals("0")) {
				sql = "UPDATE book SET book_aut=? WHERE book_no=?";
				System.out.println("변경하실 저자명> ");
				update = sc.nextLine();
			} else if (book.getBookPub().equals("0")) {
				sql = "UPDATE book SET book_pub=? WHERE book_no=?";
				System.out.println("변경하실 출판사> ");
				update = sc.nextLine();
			} else if (book.getBookPrice() == 0) {
				sql = "UPDATE book SET book_price=? WHERE book_no=?";
				System.out.println("변경하실 도서가격> ");
				updatePrice = Integer.parseInt(sc.nextLine());
			}

			pstmt = conn.prepareStatement(sql);
			if (book.getBookPrice() == 0) {
				pstmt.setInt(1, updatePrice);
			} else {
				pstmt.setString(1, update);
			}
			pstmt.setString(2, book.getBookNo());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// deleteBook()
	public int deleteBook(String no) {
		int result = 0;

		try {
			conn();
			String sql = "DELETE FROM book WHERE book_no=?";
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
