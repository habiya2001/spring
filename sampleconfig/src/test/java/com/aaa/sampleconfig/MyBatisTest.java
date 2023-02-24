//root-context.xml에 SqlSession을 이용한 mybaits의 동작 테스트
package com.aaa.sampleconfig;

import javax.inject.Inject;
//mybatis 사용시 select, update, delete, insert 질의어 단순화
import org.apache.ibatis.session.SqlSession;  //mybatis 라이브러리
import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test; //테스트 어너테이션 라이브러리
import org.junit.runner.RunWith; //현재클래스를 JUnit에서 사용할 스프링으로 연결

import org.springframework.test.context.ContextConfiguration; //context환경파일
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  //스프링으로 연동

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"}) //환경파일의 위치
public class MyBatisTest {
	//batis와       bean 연동
	//SqlSession    sqlSession
	@Inject
	private SqlSessionFactory sqlFactory; //SqlSessionFactory(mybitis에 정의된 클래스)
	
	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}
	
	@Test
	public void testSession() throws Exception {
		try {
			SqlSession session = sqlFactory.openSession();
			System.out.println(session);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
