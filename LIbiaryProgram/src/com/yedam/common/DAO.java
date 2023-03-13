package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	// DAO-> DATA ACCESS OBJECT
	// JAVA -> DB 연결 해주는 객체(JDBC)
	// OJDBC를 자바 프로젝트에 추가

	// java -> DB 연결할때 쓰는 객체
	protected Connection conn = null;

	// Select(조회) 결과 값 반환 받는 객체
	protected ResultSet rs = null;

	// Query문(SQL)을 가지고 Query문(SQL)을 실행하는 객체
	protected PreparedStatement pstmt = null;

	// Query문(SQL)을 가지고 Query문(SQL)을 실행하는 객체
	protected Statement stmt = null;

	// SELECT, INSERT, UPDATE, DELETE 등 Query문을
	// DB로 가져가서 실행 시킴.
	// ex) SELECT * FROM employees;

	Properties pro = new Properties();

	// DB 접속 정보
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "seosm";
	String pw = "seosm";

	// DB 연결 메소드
	public void conn() {
		try {
			// 1. 드라이버 로딩
			Class.forName(driver);

			// 2. DB 연결
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
