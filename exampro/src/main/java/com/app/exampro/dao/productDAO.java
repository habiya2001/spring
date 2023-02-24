package com.app.exampro.dao;
//종류가 많은 장비들을 표준화처리하기 위해서 메소드이름만 선언하고
//이용하는 곳에서 내용을 채워서 사용하는 방식
import java.util.List;  //select문의 결과를 저장을 위한 라이브러리
import java.util.Map;

import com.app.exampro.domain.productVO; //DTO

public interface productDAO {
	//메소드명 mapper에 id명과 유사하게 지정하여 사용
	public List<productVO> list() throws Exception;
}
