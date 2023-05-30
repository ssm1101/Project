package com.ohnong.app.main.service;

import org.apache.commons.mail.HtmlEmail;

public class MailUtil {
	
	public void sendMail(MemberVO member) throws Exception {
		
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com"; // 서버명
		String hostSTMPid = "moondal96@gmail.com"; // 아이디
		String hostSMTPpw = "erqybnhgdimctnuj"; // 비밀번호
		
		// 보내는 사람
		String fromEmail = "moondal96@gmail.com"; // 보내는 사람 메일
		String fromName = "ohnong";
		
		String subject = ""; // 메일 제목
		String msg = ""; // 메일 내용
		
		subject = "임시 비밀번호 발급 안내";
		msg += "<div align='left>";
		msg += "<h3>";
		msg += member.getName() + "님의 임시 비밀번호입니다. <br> 로그인 후 비밀번호를 변경하여 사용하세요.</h3>";
		msg += "<p>임시 비밀번호 : ";
		msg += member.getUserPw() + "</p></div>";
		
		// Email 전송
		String mailRecipient = member.getUserEmail(); // 받는 사람 이메일 주소
		try {
			// 객체 선언
			HtmlEmail mail = new HtmlEmail();
			mail.setDebug(true);
			mail.setCharset(charSet);
			mail.setSSL(true); //
			mail.setHostName(hostSMTP);
			mail.setSmtpPort(587);
			mail.setAuthentication(hostSTMPid, hostSMTPpw);
			//mail.setTLS(true); //
			mail.setSslSmtpPort(mailRecipient);
			mail.addTo(mailRecipient, charSet);
			mail.setFrom(fromEmail, fromName, charSet);
			mail.setSubject(subject);
			mail.setHtmlMsg(msg);
			mail.send();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
}
