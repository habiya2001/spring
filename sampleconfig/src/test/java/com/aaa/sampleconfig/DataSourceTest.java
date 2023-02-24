//root-context.xml에 bean을 이용해서 데이터베이스환경을 설정했을 경우
//환경설정으로 데이터베이스가 연동되는지 확인
package com.aaa.sampleconfig;

import java.sql.Connection; //데이터베이스 연결

import javax.inject.Inject; //bean을 주입시켜주는 라이브러리
import javax.sql.DataSource; //bean는 DataSource 정보를 관리하는 라이브러리

import org.junit.Test; //테스트 어너테이션 라이브러리
import org.junit.runner.RunWith; //현재클래스를 JUnit에서 사용할 스프링으로 연결

import org.springframework.test.context.ContextConfiguration; //context환경파일
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  //스프링으로 연동

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"}) //환경파일의 위치
public class DataSourceTest {
	//xml파일에 있는 bean을 사용할 때는 반드시 Inject주입
	//bean에서 dataSource를 읽어와서 ds에 주입(java에서 클래스를 만들때 생성 new 클래스명)
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection() throws Exception {
		try {
			Connection con = ds.getConnection();
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
