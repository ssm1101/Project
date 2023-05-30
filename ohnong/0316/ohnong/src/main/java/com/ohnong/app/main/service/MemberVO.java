package com.ohnong.app.main.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails {

	/*
	 * user_id VARCHAR2(10) NOT NULL,
	 * user_pw VARCHAR2(30) NOT NULL,
	 * user_name VARCHAR2(15) NOT NULL,
	 * birth VARCHAR2(8) NOT NULL,
	 * user_email VARCHAR2(30) NOT NULL,
	 * user_addr VARCHAR2(100) NOT NULL,
	 * user_tel VARCHAR2(13) NOT NULL,
	 * grade VARCHAR2(1) DEFAULT '2',
	 * farm_state VARCHAR2(1) DEFAULT 'N',
	 * temporary_pw VARCHAR2(10),
	 * file_path VARCHAR2(100),
	 * session_id VARCHAR2(80),
	 * limit_time date,
	 * delete_date date
	 */

	String rn;
	String userId;
	String userPw;
	String userName;
	String birth;
	String userEmail;
	String userAddr;
	String userTel;
	String grade;
	String farmState;
	String temporaryPw;
	String filePath;
	Date limitTime;
	Date deleteDate;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<>();

		String role = "";
		if (grade.equals("1")) {
			role = "ROLE_ADMIN"; // 관리자
		} else if (grade.equals("2")) {
			role = "ROLE_MEMBER"; // 일반 유저
		} else if (grade.equals("3")) {
			role = "ROLE_FAMER"; // 농가 유저
		} 

		auth.add(new SimpleGrantedAuthority(role));

		return auth;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	public String getName() {
		return userName;
	}
	@Override
	public String getPassword() {
		return userPw;
	}

	@Override
	// 패스워드 체크...몇 회 이상 실패했을 시
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if(grade.equals("4")) {
			return false;
		} else {
			return true;
		}
	}

}
