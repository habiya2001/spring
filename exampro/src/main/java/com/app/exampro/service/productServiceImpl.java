package com.app.exampro.service;
//controller->Service->DAO->myBatis->데이터베이스 동작
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

import com.app.exampro.dao.productDAO;
import com.app.exampro.domain.productVO;

public class productServiceImpl implements productService {
	@Inject
	private productDAO dao;

	@Override
	public List<productVO> list() throws Exception{
		return dao.list(); //맵퍼명.사용할질의어id
	}
}
