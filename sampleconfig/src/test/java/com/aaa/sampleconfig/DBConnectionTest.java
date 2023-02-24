//Servlet에서 접속방식
//spring 프로그램개발을 하는데 일반 mysql만 이용해서 사용할 때
//데이터베이스 연결 가능확인
package com.aaa.sampleconfig;

import java.sql.DriverManager; //데이터베이스접속
import java.sql.Connection;
import org.junit.Test;

public class DBConnectionTest {
	//root-context.xml에 설정된 값으로 수동입력해서 구동
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/spring";
	private static final String USER = "sample";
	private static final String PW = "1234";

	//testConnection()메서드는 테스트용으로 사용
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try {
			Connection con = DriverManager.getConnection(URL, USER,PW);
			System.out.println(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
