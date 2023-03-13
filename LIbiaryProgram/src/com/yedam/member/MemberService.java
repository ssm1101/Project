package com.yedam.member;

import java.util.List;
import java.util.Scanner;
import com.yedam.exe.ExeApp;
import com.yedam.rental.RentalDAO;

public class MemberService {

	Scanner sc = new Scanner(System.in);

	public static Member memberInfo = null;

	// login()
	public void login() {
		Member member = new Member();

		System.out.println("ID > ");
		String id = sc.nextLine();
		System.out.println("PW > ");
		String pw = sc.nextLine();

		member = MemberDAO.getInstance().login(id);

		if (member != null) {
			if (member.getMemberPw().equals(pw)) {
				memberInfo = member;
				if (memberInfo.getMemberGrade().equals("M")) {
					deleteMemberInfo();
					System.out.println(member.getMemberName() + " 관리자님 환영합니다.");
				} else if (memberInfo.getMemberGrade().equals("N")) {
					System.out.println(member.getMemberName() + " 님 환영합니다.");
				} else if (memberInfo.getMemberGrade().equals("R")) {
					System.out.println("탈퇴 절차가 진행중인 아이디입니다.");
					updateMemberSecession();
					new ExeApp();
				}
			} else {
				System.out.println("비밀번호가 틀립니다.");
				new ExeApp();
			}
		} else {
			System.out.println("아이디가 존재하지 않습니다.");
			new ExeApp();
		}

	}

	// logout()
	public void logout() {
		memberInfo = null;
		System.out.println("정상적으로 로그아웃 되었습니다.");
		new ExeApp();
	}

	// insertMember()
	public void insertMember() {
		Member member = new Member();
		String id = "";

		while (true) {
			System.out.println("아이디 중복체크");
			System.out.println("등록하실 ID> ");
			id = sc.nextLine();
			member = MemberDAO.getInstance().login(id);

			if (member == null) {
				member = new Member();
				System.out.println("등록 가능한 ID입니다.");
				break;
			} else {
				System.out.println("이미 존재하는 ID입니다. 다시 입력하세요.");
			}
		}

		member.setMemberId(id);
		System.out.println("PW> ");
		member.setMemberPw(sc.nextLine());
		System.out.println("NAME> ");
		member.setMemberName(sc.nextLine());
		System.out.println("BIRTH> ");
		member.setMemberBirth(sc.nextLine());
		System.out.println("PHONE> ");
		member.setMemberPhone(sc.nextLine());
		System.out.println("ADD> ");
		member.setMemberAdd(sc.nextLine());
		member.setMemberGrade("N");

		int result = MemberDAO.getInstance().insertMember(member);

		if (result == 1) {
			System.out.println("정상적으로 등록되었습니다.");
		} else {
			System.out.println("Error!");
		}
	}

	// getMemberList()
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberList();

		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		System.out.println("ID         PW         NAME         BIRTH          PHONE           ADD                   GRADE");
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%-10s %-10s %-10s %-15s %-15s %-15s %-1s",list.get(i).getMemberId(),list.get(i).getMemberPw()
					,list.get(i).getMemberName(),list.get(i).getMemberBirth(),list.get(i).getMemberPhone()
					,list.get(i).getMemberAdd(),list.get(i).getMemberGrade());
			System.out.println("\n");
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
	}

	// getMember()
	public void getMember() {
		if (memberInfo.getMemberGrade().equals("M")) {
			String memberId = "";

			System.out.println("조회 회원 ID> ");
			memberId = sc.nextLine();
			Member member = MemberDAO.getInstance().getMember(memberId);

			if (member == null) {
				System.out.println("존재하지 않는 회원입니다.");
			} else {
				System.out.println("=================================================");
				System.out.println("ID : " + member.getMemberId());
				System.out.println("PW : " + member.getMemberPw());
				System.out.println("NAME : " + member.getMemberName());
				System.out.println("BIRTH : " + member.getMemberBirth());
				System.out.println("PHONE : " + member.getMemberPhone());
				System.out.println("ADD : " + member.getMemberAdd());
				System.out.println("GRADE : " + member.getMemberGrade());
				System.out.println("=================================================");
			}

		} else if (memberInfo.getMemberGrade().equals("N")) {
			Member member = MemberDAO.getInstance().getMember(memberInfo.getMemberId());
			System.out.println("===========" + member.getMemberName() + " 회원님의 정보=============");
			System.out.println("ID : " + member.getMemberId());
			System.out.println("PW : " + member.getMemberPw());
			System.out.println("NAME : " + member.getMemberName());
			System.out.println("BIRTH : " + member.getMemberBirth());
			System.out.println("PHONE : " + member.getMemberPhone());
			System.out.println("ADD : " + member.getMemberAdd());
			System.out.println("=======================================");
		}
	}

	// getMemberOverdue()
	public void getMemberOverdue() {
		MemberDAO.getInstance().getMemberOverdue();
	}

	// updatePW(), updatePhone(), updateAdd(), updateName() - updateMember()
	public void updateMember(int menu) {
		Member member = new Member();
		if (memberInfo.getMemberGrade().equals("M")) {
			System.out.println("변경을 원하시는 회원ID> ");
			String id = sc.nextLine();
			member = MemberDAO.getInstance().login(id);
		} else if (memberInfo.getMemberGrade().equals("N")) {
			member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		}

		if (member != null) {
			if (menu == 1) {
				member.setMemberPw("0");
			} else if (menu == 2) {
				member.setMemberPhone("0");
			} else if (menu == 3) {
				member.setMemberAdd("0");
			} else if (menu == 4) {
				member.setMemberName("0");
			} else if (menu == 5) {
				member.setMemberGrade("0");
			}
			int result = MemberDAO.getInstance().updateMember(member);
			if (result == 1) {
				System.out.println("변경 완료");
			} else {
				System.out.println("Error!");
			}
		} else {
			System.out.println("해당 아이디가 존재하지 않습니다.");
		}

	}

	// updateMemberSecession
	public void updateMemberSecession() {
		Member member = MemberDAO.getInstance().login(memberInfo.getMemberId());
		int result = RentalDAO.getInstance().getRental(member.getMemberId());
		if (result == 1) {
			System.out.println("대여중인책이 있습니다.");

		} else {
			if (member.getMemberGrade().equals("N")) {
				System.out.println("비밀번호 재확인> ");
				String pw = sc.nextLine();
				if (member.getMemberPw().equals(pw)) {
					System.out.println("정말 탈퇴하시겠습니까?");
					System.out.println("Y/N");
					pw = sc.nextLine();
					if (pw.equals("Y")) {
						result = MemberDAO.getInstance().updateMemberSecession(member.getMemberId());

						if (result == 1) {
							System.out.println("정상처리 되었습니다. 30일 동안 회원 정보가 보관되며 그 뒤 폐기됩니다.");
							logout();
						} else {
							System.out.println("Error!");
						}
					} else if (pw.equals("N")) {
						System.out.println("이전단계로 이동");
					} else {
						System.out.println("잘못입력하셨습니다.");
					}
				} else {
					System.out.println("비밀번호가 틀립니다.");
				}
			} else if (member.getMemberGrade().equals("R")) {
				System.out.println("탈퇴처리를 취소하겠습니까?");
				System.out.println("Y/N");
				String check = sc.nextLine();
				if (check.equals("Y")) {
					result = MemberDAO.getInstance().updateMemberSecession(member.getMemberId());
					if (result == 1) {
						System.out.println("정상 처리 되었습니다.");
					} else {
						System.out.println("Error!");
					}
				} else {
					logout();
				}
			}
		}

	}

	// deleteMember()
	public void deleteMember() {
		System.out.println("삭제하실 회원의 ID> ");
		String id = sc.nextLine();
		
		int result = RentalDAO.getInstance().getRental(id);
		if (result == 1) {
			System.out.println("대여중인책이 있습니다.");
		}else {
			result = MemberDAO.getInstance().deleteMember(id);
			if (result == 1) {
				System.out.println("정상적으로 삭제되었습니다.");
			} else {
				System.out.println("Error!");
			}
		}
		
	}

	// deleteMemberInfo()
	public void deleteMemberInfo() {
		MemberDAO.getInstance().deleteMemberInfo();
	}

}
