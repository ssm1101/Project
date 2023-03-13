package com.yedam.exe;

import java.util.Scanner;

import com.yedam.board.BoardService;
import com.yedam.book.BookService;
import com.yedam.member.MemberService;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	BookService bs = new BookService();
	BoardService bos = new BoardService();
	int menu = 0;

	public MemberMenu() {
		menuList();
	}

	private void menuList() {

		while (true) {
			// 관리자
			if (MemberService.memberInfo.getMemberGrade().equals("M")) {
				System.out.println("==========================================================================");
				System.out.println("|| 1. 회원관리 | 2. 도서관리 | 3. 칭찬 및 건의 사항 게시판 | 4. 로그아웃 ||");
				System.out.println("==========================================================================");
				System.out.println("입력> ");
				menu = Integer.parseInt(sc.nextLine());
				managerMenu();
			}
			// 일반회원
			else if (MemberService.memberInfo.getMemberGrade().equals("N")) {
				System.out.println("====================================================================================");
				System.out.println("|| 1. 마이페이지 | 2. 대출가능 도서확인 | 3. 칭찬 및 건의 사항 게시판 | 4. 로그아웃 ||");
				System.out.println("====================================================================================");
				System.out.println("입력> ");
				menu = Integer.parseInt(sc.nextLine());
				userMenu();
			}
		}

	}

	// 관리자 메뉴리스트
	private void managerMenu() {

		if (menu == 1) {
			System.out.println("==================================================================");
			System.out.println("|| 1. 회원등록 | 2. 회원조회 | 3. 회원정보수정 | 4. 회원정보삭제 ||");
			System.out.println("==================================================================");
			System.out.println("입력> ");
			menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				ms.insertMember();

			} else if (menu == 2) {
				System.out.println("======================================================");
				System.out.println("|| 1. 전체회원조회 | 2. 회원검색 | 3. 연체회원 조회 ||");
				System.out.println("======================================================");
				System.out.println("입력> ");
				menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					ms.getMemberList();
					break;
				case 2:
					ms.getMember();
					break;
				case 3:
					ms.getMemberOverdue();
					break;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}

			} else if (menu == 3) {
				System.out.println("=========================================================================");
				System.out.println("|| 1. PW수정 | 2. 연락처수정 | 3. 주소수정 | 4. 이름수정 | 5. 등급수정 ||");
				System.out.println("=========================================================================");
				System.out.println("입력> ");
				menu = Integer.parseInt(sc.nextLine());
				if (menu < 6) {
					ms.updateMember(menu);
				} else {
					System.out.println("잘못입력하셨습니다.");
				}

			} else if (menu == 4) {
				ms.deleteMember();
			}

		} else if (menu == 2) {
			System.out.println(
					"=========================================================================================================");
			System.out.println("|| 1. 도서정보 등록 | 2. 도서목록 조회 | 3. 도서정보 수정 | 4.도서정보 삭제 | 5. 도서대출 | 6.도서반납 ||");
			System.out.println(
					"=========================================================================================================");
			System.out.println("입력> ");
			menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				bs.insertBook();

			} else if (menu == 2) {
				System.out.println("=====================================================");
				System.out.println("|| 1. 전체도서 조회 | 2. 책검색 | 3. 대출중인 도서 ||");
				System.out.println("=====================================================");
				menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					bs.getBookList();
					break;
				case 2:
					bs.getBookSearch();
					break;
				case 3:
					bs.getBookRentalList();
					break;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}

			} else if (menu == 3) {
				System.out.println("============================================================");
				System.out.println("|| 1. 제목수정 | 2. 저자수정 | 3. 출판사수정 | 4. 가격수정 ||");
				System.out.println("============================================================");
				System.out.println("입력> ");
				menu = Integer.parseInt(sc.nextLine());
				if (menu < 5) {
					bs.updateBook(menu);
				} else {
					System.out.println("잘못입력하셨습니다.");
				}

			} else if (menu == 4) {
				bs.deleteBook();

			} else if (menu == 5) {
				bs.insertRentalBook();

			} else if (menu == 6) {
				bs.deleteRentalBook();
			}

		} else if (menu == 3) {
			bos.getBoardListPaging();

		} else if (menu == 4) {
			ms.logout();

		} else {
			System.out.println("잘못입력 하셨습니다.");
			menuList();
		}
	}

	// 사용자 메뉴리스트
	private void userMenu() {

		if (menu == 1) {
			System.out.println("==========================================================================");
			System.out.println("|| 1. 회원정보 조회 | 2. 회원정보 수정 | 3. 대여도서 확인 | 4. 회원탈퇴 ||");
			System.out.println("==========================================================================");
			System.out.println("입력> ");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				ms.getMember();
				break;
			case 2:
				System.out.println("======================================================");
				System.out.println("|| 1. 비밀번호 수정 | 2. 연락처 수정 | 3. 주소 수정 ||");
				System.out.println("======================================================");
				menu = Integer.parseInt(sc.nextLine());
				if (menu < 4) {
					ms.updateMember(menu);
				} else {
					System.out.println("잘못입력하셨습니다.");
				}
				break;
			case 3:
				ms.getMemberOverdue();
				break;
			case 4:
				ms.updateMemberSecession();
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		} else if (menu == 2) {
			System.out.println("=====================================================");
			System.out.println("|| 1. 대출가능 도서 전체조회 | 2. 대출가능 도서검색 ||");
			System.out.println("=====================================================");
			System.out.println("입력> ");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				bs.getBookList();
				break;
			case 2:
				bs.getBookSearch();
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		} else if (menu == 3) {
			bos.getBoardListPaging();

		} else if (menu == 4) {
			ms.logout();

		} else {
			System.out.println("잘못입력 하셨습니다.");
		}
	}

}
