package com.app.exampro.service;
//컨트롤러에서 DAO를 사용할 수 있도록 중간매개
import java.util.List;  //select문의 결과를 저장을 위한 라이브러리
import java.util.Map;

import com.app.exampro.domain.productVO; //DTO

public interface productService {
	public List<productVO> list() throws Exception;
}


//DAO의 내용을 그대로 복사