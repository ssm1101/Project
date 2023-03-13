package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class ExeApp {
	Scanner sc = new Scanner(System.in);
	MemberService ms = new MemberService();
	int menu = 0;

	public ExeApp() {
		run();
	}

	private void run() {
		System.out.println("================================================");
		System.out.println("|| 1. 로그인 | 2. 회원 등록 | 3. 프로그램 종료 ||");
		System.out.println("================================================");
		System.out.println("입력> ");
		menu = Integer.parseInt(sc.nextLine());

		switch (menu) {
		case 1:
			ms.login();
			if (MemberService.memberInfo != null) {
				new MemberMenu();
			}
			break;
		case 2:
			ms.insertMember();
			run();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
			run();
			break;
		}

	}

}
