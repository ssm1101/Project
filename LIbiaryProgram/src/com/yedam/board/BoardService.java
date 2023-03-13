package com.yedam.board;

import java.util.List;
import java.util.Scanner;
import com.yedam.exe.MemberMenu;
import com.yedam.member.MemberService;

public class BoardService {

	Scanner sc = new Scanner(System.in);
	List<Board> list = BoardDAO.getInstance().getBoardList();
	int page = 1;
	int totalPage = (list.size() + 4) / 5;

	// createBoard
	public void createBoard() {
		Board board = new Board();

		System.out.println("=================게시글작성=================");
		System.out.println("제목 : ");
		board.setBoardTitle(sc.nextLine());
		System.out.println("작성자 : " + "\t" + MemberService.memberInfo.getMemberId());
		System.out.println("내용 : ");
		board.setBoardCon(sc.nextLine());
		board.setMemberId(MemberService.memberInfo.getMemberId());

		int result = BoardDAO.getInstance().createBoard(board);
		if (result == 1) {
			System.out.println("게시글이 등록되었습니다.");
		} else {
			System.out.println("Error!");
		}

	}

	// getBoard()
	public int getBoard() {
		int boardNo = 0;
		System.out.println("조회 게시글 번호> ");
		boardNo = Integer.parseInt(sc.nextLine());
		Board board = BoardDAO.getInstance().getBoard(boardNo);

		if (board == null) {
			System.out.println("존재하지 않는 글입니다.");
			getBoardListPaging();
		} else {
			System.out.println("====================================================");
			System.out.println("제목 " + board.getBoardTitle());
			System.out.println("====================================================");
			System.out.println("작성자 " + board.getMemberId() + "\t" + "작성일 " + board.getBoardDate());
			System.out.println("====================================================");
			System.out.println("글내용");
			System.out.println(board.getBoardCon());
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("====================================================");

		}
		return boardNo;
	}

	// updateBoard()
	public void updateBoard(int no) {
		Board board = BoardDAO.getInstance().getBoard(no);
		String title = "";
		String con = "";
		String id = "";

		if (MemberService.memberInfo.getMemberGrade().equals("N")) {
			if (!MemberService.memberInfo.getMemberId().equals(board.getMemberId())) {
				System.out.println("본인의 게시글만 수정가능합니다.");
				getBoardListPaging();
			}
		}

		System.out.println("=================게시글수정=================");
		System.out.println("제목 : ");
		title = sc.nextLine();
		System.out.println("작성자 : " + "\t" + board.getMemberId());
		id = board.getMemberId();
		System.out.println("내용 : ");
		con = sc.nextLine();

		board = new Board();
		board.setBoardNo(no);
		board.setBoardTitle(title);
		board.setBoardCon(con);
		board.setMemberId(id);

		int result = BoardDAO.getInstance().updateBoard(board);
		if (result == 1) {
			System.out.println("게시글이 수정되었습니다.");
		} else {
			System.out.println("Error!");
		}
	}

	public void deleteBoard(int no) {
		Board board = BoardDAO.getInstance().getBoard(no);
		if (MemberService.memberInfo.getMemberGrade().equals("N")) {
			if (!MemberService.memberInfo.getMemberId().equals(board.getMemberId())) {
				System.out.println("본인의 게시글만 삭제가능합니다.");
				getBoardListPaging();
			}
		}
		int result = BoardDAO.getInstance().deleteBoard(no);
		if (result >= 0) {
			System.out.println("게시글이 삭제되었습니다.");
		} else {
			System.out.println("Error!");
		}
	}

	public void getBoardListPaging() {
		List<Board> list = BoardDAO.getInstance().getBoardListPaging(page);

		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("번호   제목                       작성자       작성일 ");
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-5d %-25s %-10s %-15s",list.get(i).getBoardNo(),
					list.get(i).getBoardTitle(),list.get(i).getMemberId(),list.get(i).getBoardDate());
			System.out.println("\n");
		}
		System.out.println("= = = = = = = = = = = = = =" + page +"/"+totalPage+"page = =  = = = = = = = = = = = = =");
		boardMenu();
	}

	public void boardMenu() {
		System.out.println("(1)등록 (2)조회 (3)이전페이지 (4)다음페이지 (0)종료");
		System.out.println("입력> ");
		int menu = Integer.parseInt(sc.nextLine());
		switch (menu) {
		case 1:
			createBoard();
			getBoardListPaging();
			break;
		case 2:
			int no = getBoard();
			System.out.println("(1)수정 (2)삭제 (3)목록으로");
			System.out.println("입력> ");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				updateBoard(no);
				getBoardListPaging();
				break;
			case 2:
				deleteBoard(no);
				getBoardListPaging();
				break;
			case 3:
				getBoardListPaging();
				break;
			default:
				break;
			}
		case 3:
			--page;
			if (page < 1) {
				page = 1;
			}
			getBoardListPaging();
			break;
		case 4:
			++page;
			if (page > totalPage) {
				--page;
			}
			getBoardListPaging();
			break;
		case 0:
			new MemberMenu();
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			break;
		}
	}

}
