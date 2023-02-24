package com.aaa.sampleconfig.dao;

//데이터베이스 서버를 위해서

//DAO에서 작업할 메서드를 선언
//데이터베이스에서 접근할 작업영역(메서드)
import com.aaa.sampleconfig.domain.sampleVO; //DTO연결

public interface sampleDAO {
	//삽입,수정,삭제,조회에 관련된 메서드(Mapper에 만든 SQL 개수만큼 메서드를 생성)
	//이름도 Mapper의 id와 동일하게 작업(유사하게)
	/*id="create"
	id="allList" resultType = "sampleVO"
	 #{name}
    id="whereList" resultType = "sampleVO"
	id ="ascList" resultType="sampleVO"
	id ="descList" resultType="sampleVO"
	id="update"
	id="delete"*/
	//public resultType참고 id이름(질의어 내용을 참고)  
	public void create(sampleVO samblevo) throws Exception;
	public sampleVO allList() throws Exception;
	//#{변수명}->인수명 동일하게
	public sampleVO whereList(String name) throws Exception;
	public sampleVO ascList() throws Exception;
	public sampleVO descList() throws Exception;
	public void update(sampleVO vo) throws Exception;
	public void delete(String name) throws Exception;
	//인터페이스는 메서드이름을 공통적으로 사용하고 내용은 상황에 따라 재수정해서 사용
	//인터페이스의 메서드를 복사를 해서 클래스에 붙여넣기
	
}
