package com.yedam.book;

import java.util.List;
import java.util.Scanner;
import com.yedam.member.Member;
import com.yedam.member.MemberDAO;
import com.yedam.member.MemberService;
import com.yedam.rental.Rental;
import com.yedam.rental.RentalDAO;

public class BookService {

	Scanner sc = new Scanner(System.in);

	// insertBook()
	public void insertBook() {
		Book book = new Book();
		String no = "";

		while (true) {
			System.out.println("책번호> ");
			book.setBookNo(no = sc.nextLine());
			// book.setBookNo(Integer.parseInt(sc.nextLine()));
			book = BookDAO.getInstance().check(book);

			if (book == null) {
				book = new Book();
				System.out.println("등록가능한 번호입니다.");
				break;
			} else {
				System.out.println("이미 존재하는 번호입니다.");
			}
		}

		book.setBookNo(no);
		System.out.println("등록하실 책제목> ");
		book.setBookTitle(sc.nextLine());
		System.out.println("저자> ");
		book.setBookAut(sc.nextLine());
		System.out.println("출판사> ");
		book.setBookPub(sc.nextLine());
		System.out.println("가격> ");
		book.setBookPrice(Integer.parseInt(sc.nextLine()));

		int result = BookDAO.getInstance().insertBook(book);
		if (result == 1) {
			System.out.println("도서정보가 정상적으로 등록되었습니다.");
		} else {
			System.out.println("Error!");
		}
	}

	// getBookList()
	public void getBookList() {
		List<Book> list = BookDAO.getInstance().getBookList();
		if (MemberService.memberInfo.getMemberGrade().equals("M")) {
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = =");
			System.out.println("도서번호  책제목           저자      출판사      가격   ");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = =");
			for( int i=0; i<list.size(); i++) {
				System.out.printf("%-8s %-15s %-7s %-7s %-6s",list.get(i).getBookNo(),list.get(i).getBookTitle(),
						list.get(i).getBookAut(),list.get(i).getBookPub(),list.get(i).getBookPrice());
				System.out.println("\n");
			}
		}else if (MemberService.memberInfo.getMemberGrade().equals("N")) {
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = =");
			System.out.println("도서번호   책제목            저자      출판사            ");
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = =");
			for( int i=0; i<list.size(); i++) {
				System.out.printf("%-8s %-15s %-7s %-7s",list.get(i).getBookNo(),list.get(i).getBookTitle(),
						list.get(i).getBookAut(),list.get(i).getBookPub());
				System.out.println("\n");
			}
		}
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = =");
		
	}

	// getBookSearch() bookNo,bookTitle
	public void getBookSearch() {
		Book book = new Book();
		String noAndTitle = "";

		if (MemberService.memberInfo.getMemberGrade().equals("M")) {
			System.out.println("조회할 책번호> ");
			noAndTitle = sc.nextLine();
			book.setBookNo(noAndTitle);
		} else if (MemberService.memberInfo.getMemberGrade().equals("N")) {
			System.out.println("조회할 책제목> ");
			noAndTitle = sc.nextLine();
			book.setBookTitle(noAndTitle);
		}

		List<Book> list = BookDAO.getInstance().getBookSearch(book);

		if (list.isEmpty()) {
			if (MemberService.memberInfo.getMemberGrade().equals("M")) {
				System.out.println("해당 책번호는 존재하지 않습니다.");
			} else if (MemberService.memberInfo.getMemberGrade().equals("N")) {
				System.out.println("해당 책제목은 존재하지 않습니다.");
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("====================================");
				System.out.println("책번호 : " + list.get(i).getBookNo());
				System.out.println("책제목 : " + list.get(i).getBookTitle());
				System.out.println("저 자 : " + list.get(i).getBookAut());
				System.out.println("출판사 : " + list.get(i).getBookPub());
				if (MemberService.memberInfo.getMemberGrade().equals("M")) {
					System.out.println("가 격 : " + list.get(i).getBookPrice());
				}
				System.out.println("====================================");
			}
		}
	}

	// getRentalBookList()
	public void getBookRentalList() {
		BookDAO.getInstance().getBookRentalList();
	}

	// updateTitle(), updatePhone(), updateAdd(), updateName() - updateBook()
	public void updateBook(int menu) {
		Book book = new Book();
		System.out.println("변경을 원하시는 책번호> ");
		book.setBookNo(sc.nextLine());
		book = BookDAO.getInstance().check(book);

		if (book != null) {
			if (menu == 1) {
				book.setBookTitle("0");
			} else if (menu == 2) {
				book.setBookAut("0");
			} else if (menu == 3) {
				book.setBookPub("0");
			} else if (menu == 4) {
				book.setBookPrice(0);
			}
			int result = BookDAO.getInstance().updateBook(book);
			if (result == 1) {
				System.out.println("변경 완료");
			} else {
				System.out.println("Error!");
			}
		} else {
			System.out.println("해당 책번호가 존재하지 않습니다.");
		}

	}

	// deleteBook()
	public void deleteBook() {
		System.out.println("삭제하실 책번호> ");
		String no = sc.nextLine();

		int result = BookDAO.getInstance().deleteBook(no);
		if (result == 1) {
			System.out.println("정상적으로 삭제되었습니다.");
		} else {
			System.out.println("Error!");
		}
	}

	// insertRentalBook()
	public void insertRentalBook() {
		Rental rental = new Rental();
		Member member = new Member();
		Book book = new Book();
		String rentalDate = "";
		String id = "";
		String no = "";

		while (true) {
			System.out.println("대여하실 회원번호> ");
			id = sc.nextLine();
			member = MemberDAO.getInstance().login(id);

			if (member != null) {
				while (true) {
					System.out.println("대여하실 도서번호 ");
					no=sc.nextLine();
					book.setBookNo(no);
					book = BookDAO.getInstance().check(book);

					if (book != null) {
						break;
					} else {
						System.out.println("도서번호가 존재하지않습니다.");
					}
				}
				break;
			} else {
				System.out.println("회원번호가 존재하지않습니다.");
			}
		}
		int result1=RentalDAO.getInstance().getRentalBook(no);
		if(result1==1) {
			System.out.println("이미 대출중입니다.");
		}else {
			System.out.println("대여일> ");
			rentalDate = sc.nextLine();
			rental.setRentDate(rentalDate);
			System.out.println("반납일> ");
			rental.setReturnDate(sc.nextLine());
			rental.setMemberId(id);
			rental.setBookNo(no);
			
			int result = RentalDAO.getInstance().insertRentalBook(rental);
			
			if (result == 1) {
				System.out.println("정상적으로 등록되었습니다.");
			} else {
				System.out.println("Error!");
			}
		}

	}

	public void deleteRentalBook() {
		System.out.println("반납할 책의 도서번호> ");
		String no = sc.nextLine();

		int result = RentalDAO.getInstance().deleteRentalBook(no);
		if (result == 1) {
			System.out.println("정상적으로 반납처리되었습니다.");
		} else {
			System.out.println("Error!");
		}
	}

}
