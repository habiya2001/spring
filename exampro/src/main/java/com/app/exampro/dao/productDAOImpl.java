package com.app.exampro.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.app.exampro.domain.productVO;

//인터페이스에 해당하는 메서드 작업내용을 작성

//작업영역
@Repository
public class productDAOImpl implements productDAO { //상속을 받아서 메서드이름은 동일하게 내용을 작업내용
	//root-context.xml에 작성한 bean을 sql 적용(주입)
	@Inject
	private SqlSession sql;
	//mybatis를 이용해서 작성한 질의어의 파일을 지정
	private String namespace="com.app.mappers.product";
	
	
	//원메서드의 내용을 사용자가 변경해서 사용
	@Override
	public List<productVO> list() throws Exception{
		return sql.selectList(namespace+".list"); //맵퍼명.사용할질의어id
	}
	
}
