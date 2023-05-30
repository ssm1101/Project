package com.ohnong.app.main.service.impl;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ohnong.app.main.mapper.MemberMapper;
import com.ohnong.app.main.service.MemberService;
import com.ohnong.app.main.service.MemberVO;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

	@Autowired
	MemberMapper memberMapper;

	// 시큐리티
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO mVO = new MemberVO();
		mVO.setUserId(username);
		MemberVO vo = memberMapper.login(mVO);
		if (vo == null) {
			throw new UsernameNotFoundException("no user");
		}
		System.out.println(vo);
		// 권한 정보를 지정
		return vo;
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO memberVO) {
		return memberMapper.login(memberVO);
	}

	// 회원가입
	@Override
	public int insertMemberInfo(MemberVO memberVO) {
		return memberMapper.insertMemberInfo(memberVO);
	}

	// 아이디 중복 체크
	@Override
	public int checkId(String account) {
		return memberMapper.checkId(account);
	}

	// 아이디 찾기
	@Override
	public String findId(String userName, String birth) {
		return memberMapper.findId(userName, birth);
	}

	// 비밀번호 찾기1
	@Override
	public MemberVO checkPw(MemberVO memberVO) {
		return memberMapper.checkPw(memberVO);
	}

	// 비밀번호 찾기2
	@Override
	public int changePw(MemberVO memberVO) {

		// 1임시 비밀번호 발급
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);
		String rawPw = getRamdomPassword(20); // 들어갈 비밀번호

		// 2디비 업데이트
		String encodePw = bcrypt.encode(rawPw); // 암호화하여 저장
		memberVO.setUserPw(encodePw);
		int r = memberMapper.changePw(memberVO);
		System.out.println("확인 : " + r);

		// 3메일 발송
		// 메일 제목
		String subject = "[오농] 임시 비밀번호 발급 안내";
		// 메일 내용
		String msg = "<h3>회원님의 임시 비밀번호입니다. "
				+ "<br> 로그인 후 비밀번호를 변경하여 사용하세요.</h3><p>임시 비밀번호 : "
				+ rawPw + "</p>";

		sendMail(memberVO.getUserEmail(), subject, msg);

		return r;

	}

	@Autowired
	public JavaMailSender javaMailSender;

	private void sendMail(String userEmail, String subject, String msg) {

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			// 1. 메일 수신자 설정
			messageHelper.setTo(userEmail);
			messageHelper.setFrom("moondal96@gmail.com");
			
			// 2. 메일 제목 설정
			messageHelper.setSubject(subject);

			// 3. 메일 내용 설정
			String content = msg;
			messageHelper.setText(content, true);

			// 4. 메일 전송
			javaMailSender.send(message);
			System.out.println("메일 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원 본인 정보 조회
	@Override
	public MemberVO getMemberInfo(String userId) {
		return memberMapper.selectMemberInfo(userId);
	}

	// 회원 본인 정보 수정
	@Override
	public boolean memberMod(MemberVO memberVO) {
		return memberMapper.memberUpdate(memberVO) == 1 ? true : false;
	}

	// 관리자 회원 조회
	@Override
	public List<MemberVO> memberList() {
		return memberMapper.memberList();
	}

	// 관리자용 회원 삭제(업데이트)
	@Override
	public int memberDelete(String userId) {
		return memberMapper.memberDelete(userId);
	}

	// #임시 비밀번호
	public String getRamdomPassword(int size) {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&' };

		StringBuffer sb = new StringBuffer();
		SecureRandom sr = new SecureRandom();
		sr.setSeed(new Date().getTime());

		int idx = 0;
		int len = charSet.length;
		for (int i = 0; i < size; i++) {
			// idx = (int) (len * Math.random());
			idx = sr.nextInt(len); // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다.
			sb.append(charSet[idx]);
		}

		return sb.toString();
	}

	// 비밀번호 변경
	@Override
	public boolean modPw(MemberVO memberVO) {
		return memberMapper.modPw(memberVO) == 1 ? true : false;
	}

	// 회원 본인 정보 수정 2
	@Override
	public boolean memberMod2(MemberVO memberVO) {
		return memberMapper.memberUpdate2(memberVO) == 1 ? true : false;
	}

}