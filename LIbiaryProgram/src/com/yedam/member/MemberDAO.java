package com.yedam.member;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.yedam.common.DAO;

public class MemberDAO extends DAO {
	Scanner sc = new Scanner(System.in);
	private static MemberDAO memberDao = null;

	private MemberDAO() {

	}

	public static MemberDAO getInstance() {
		if (memberDao == null) {
			memberDao = new MemberDAO();
		}
		return memberDao;
	}

	// login()
	public Member login(String id) {
		Member member = null;
		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberBirth(rs.getString("member_birth").substring(0, 10));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAdd(rs.getString("member_add"));
				member.setMemberGrade(rs.getString("member_grade"));
			} else {
				member = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}

	// insertMember()
	public int insertMember(Member member) {
		int result = 0;

		try {
			conn();
			String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?, null)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberBirth());
			pstmt.setString(5, member.getMemberPhone());
			pstmt.setString(6, member.getMemberAdd());
			pstmt.setString(7, member.getMemberGrade());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// getMemberList()
	public List<Member> getMemberList() {
		List<Member> list = new ArrayList<>();
		Member member = null;

		try {
			conn();
			String sql = "SELECT * FROM member WHERE grade_date IS NULL";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberBirth(rs.getString("member_birth").substring(0, 10));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAdd(rs.getString("member_add"));
				member.setMemberGrade(rs.getString("member_grade"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	// getMember()
	public Member getMember(String memberId) {
		Member member = null;

		try {
			conn();
			String sql = "SELECT * FROM member WHERE member_id=? AND grade_date IS NULL";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getString("member_pw"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberBirth(rs.getString("member_birth").substring(0, 10));
				member.setMemberPhone(rs.getString("member_phone"));
				member.setMemberAdd(rs.getString("member_add"));
				member.setMemberGrade(rs.getString("member_grade"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
	}

	// getMemberOverdue(),회원대출도서조회
	public void getMemberOverdue() {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		String sql = "";

		try {
			conn();
			if (MemberService.memberInfo.getMemberGrade().equals("M")) {
				sql = "SELECT * \r\n" + "FROM member m JOIN rental r\r\n" + "ON m.member_id=r.member_id\r\n"
						+ "JOIN book b\r\n" + "ON r.book_no=b.book_no\r\n" + "WHERE r.return_date<sysdate";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
			} else if (MemberService.memberInfo.getMemberGrade().equals("N")) {
				sql = "SELECT * \r\n" + "FROM member m JOIN rental r\r\n" + "ON m.member_id=r.member_id\r\n"
						+ "JOIN book b\r\n" + "ON r.book_no=b.book_no\r\n" + "WHERE m.member_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, MemberService.memberInfo.getMemberId());
				rs = pstmt.executeQuery();
			}

			while (rs.next()) {
				Map<String, Object> map = new LinkedHashMap<>();
				if(MemberService.memberInfo.getMemberGrade().equals("M")) {
					map.put("회원번호", rs.getString("member_id"));
					map.put("이 름", rs.getString("member_name"));
				}
				map.put("대여 도번호", rs.getString("book_no"));
				map.put("대여 도서명", rs.getString("book_title"));
				if(MemberService.memberInfo.getMemberGrade().equals("M")) {
					map.put("연락처", rs.getString("member_phone"));
				}
				map.put("대여일", rs.getString("rent_date").substring(0, 10));
				map.put("반납일", rs.getString("return_date").substring(0, 10));
				listmap.add(map);
			}
			if(MemberService.memberInfo.getMemberGrade().equals("N")) {
				System.out.println("==================================================");
				for (Map<String, Object> map : listmap) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						String key = entry.getKey();
						Object value = entry.getValue();
						System.out.println(key + " : " + value);
					}
					System.out.println("==================================================");
				}
			}else if(MemberService.memberInfo.getMemberGrade().equals("M")) {
				System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
				System.out.println("회원번호        이름             대여도서번호   대여도서명      연락처         대여일         반납일");
				System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
				for (Map<String, Object> map : listmap) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						System.out.printf("%-15s",value);
					}
					System.out.println("\n");
				}
				System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}

	// updatePW(), updatePhone(), updateAdd(), updateName(),
	// updateGrade()-update()함수 하나로
	public int updateMember(Member member) {
		int result = 0;

		try {
			conn();
			String update = "";
			String sql = "";
			if (member.getMemberPw().equals("0")) {
				sql = "UPDATE member SET member_pw=? Where member_id=?";
				System.out.println("변경하실 PW> ");
				update = sc.nextLine();
			} else if (member.getMemberPhone().equals("0")) {
				sql = "UPDATE member SET member_phone=? Where member_id=?";
				System.out.println("변경하실 PHONE> ");
				update = sc.nextLine();
			} else if (member.getMemberAdd().equals("0")) {
				sql = "UPDATE member SET member_add=? Where member_id=?";
				System.out.println("변경하실 ADD> ");
				update = sc.nextLine();
			} else if (member.getMemberName().equals("0")) {
				sql = "UPDATE member SET member_name=? Where member_id=?";
				System.out.println("변경하실 NAME> ");
				update = sc.nextLine();
			} else if (member.getMemberGrade().equals("0")) {
				sql = "UPDATE member SET member_grade=? Where member_id=?";
				System.out.println("변경하실 GRADE> ");
				update = sc.nextLine();
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, update);
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// updateMemberSecession
	public int updateMemberSecession(String memberId) {
		int result = 0;
		String sql = "";
		try {
			conn();
			if (MemberService.memberInfo.getMemberGrade().equals("N")) {
				sql = "UPDATE member SET member_grade=?, grade_date=sysdate Where member_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "R");
				pstmt.setString(2, memberId);
			} else if (MemberService.memberInfo.getMemberGrade().equals("R")) {
				sql = "UPDATE member SET member_grade=?, grade_date=null WHERE member_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "N");
				pstmt.setString(2, memberId);
			}
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// deleteMember()
	public int deleteMember(String id) {
		int result = 0;

		try {
			conn();
			String sql = "DELETE FROM member WHERE member_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	// deleteMemberInfo()
	public int deleteMemberInfo() {
		int result = 0;

		try {
			conn();
			String sql = "DELETE FROM member WHERE grade_date < SYSDATE + 30";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}
}
