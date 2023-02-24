package com.aaa.sampleconfig.dao;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.session.SqlSession; //mybaits를 이용해서 SQL를 사용
import com.aaa.sampleconfig.domain.sampleVO;

//DAO는 repository 어노테이션을 선언
@Repository
public class sampleDAOImpl implements sampleDAO {
	//root-context.xml의 빈을 사용할 떄는 inject 어노테이션으로 선언
	@Inject
	private SqlSession sqlSession;
	
	//사용할 mapper를 지정
	private static final String NAMESPACE = "com.aaa.sampleconfig.mapper.BoardMapper";
	//붙여넣기 후 ; 삭제 후 {}추가해서 내용 채우기
	
	//인터페이스의 내용을 수정
	@Override
	public void create(sampleVO samblevo) throws Exception{
		//mybatis의 질의어를 이용해서 작업지시
		//sqlSession(데이터베이스) + NAMESPACE(질의어)
		//sqlSession.질의어(batis+".질의어id", 전달값)
		//member_Mapper에 create 질의어를 sqlSession데이터베이스에 insert(삽입)작업으로 진행
		sqlSession.insert(NAMESPACE+".create", samblevo);
	}
	@Override
	public sampleVO allList() throws Exception{
		return sqlSession.selectOne(NAMESPACE+".allList");	
	}	
	@Override
	public sampleVO whereList(String name) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".whereList", name);
	}
	@Override
	public sampleVO ascList() throws Exception{
		return sqlSession.selectOne(NAMESPACE+".ascList");	
	}
	@Override
	public sampleVO descList() throws Exception{
		return sqlSession.selectOne(NAMESPACE+".descList");	
	}
	@Override
	public void update(sampleVO vo) throws Exception{
		sqlSession.update(NAMESPACE+".update", vo);
	}
	@Override
	public void delete(String name) throws Exception{
		sqlSession.delete(NAMESPACE+".delete", name);
	}
}
/*
<T> T selectOne(String statement) - 1개만 검색하는 메서드
<E> List<E> selectList(String statement) - 다중 검색하는 메소드
<K,V> Map<K,V> selectMap(String statement, String mapKey) - 키와 값으로 저장하는 메소드
int insert(String statement) - 삽입
int update(String statement) - 수정
int delete(String statement) -삭제 */