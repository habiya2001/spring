//각 테이블별로 Controller 생성해서 사용
//서블렛은 클래스가 하나의 컨트롤, 스프링은 메서드가 하나의 컨트롤
package com.aaa.sampleconfig;

import com.aaa.sampleconfig.domain.sampleVO;
import com.aaa.sampleconfig.service.sampleService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import javax.inject.Inject;

//생략가능(print문 대신 사용하기 위해서)
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//1. View에 있는 페이지와 연결 작업
//2. Service를 이용해서 페이지에 값을 주고받기 위한
//해당클래스 컨트롤인지를 등록
@Controller
public class sampleController {
	//해당클래스에 대한 로그 변수를 선언
	private static final Logger logger = LoggerFactory.getLogger(sampleController.class);

	@Inject
	private sampleService samService;
	
	//@ReuquestMapping("값")
	//@ReuquestMapping(value="값", method="전달방식")
	//JSP에 값을 전달하고 싶을 땐느 Model 인수를 선언해야 한다.
	@RequestMapping(value="sampleList", method = RequestMethod.GET)	
	public void sampleList(Model model) throws Exception { //작업하고자 하는 메소드(요청받아서 해당페이지를 연결)
		logger.info("sampleList로 접속을 했습니다.");
		//요청한 페이지에 값을 전달하기 위해 저장
		//addAttributre(저장할 변수명, 값)
		//데이터베이스 처리가 필요하면 서비스를 통해서 데이터베이스 처리
		//모든데이터를 검색해서 sampleVO저장해서 요청페이지에 전달
		//목록->처리->목록
		model.addAttribute("sampleVO", samService.allList());
	}
	

	@RequestMapping(value="update", method=RequestMethod.GET)
	public String edit(sampleVO vo, Model model) throws Exception{
		logger.info("update로 접속을 했습니다.");
		//수정폼->처리->완료->수정확인창
		samService.update(vo);
		
		return "updateView";
	}

	//Form에서 input 태그에 입력된 값들을 전달받아서
	@RequestMapping(value="sampleInsert", method=RequestMethod.POST)
	//                    전달받을 값이 저장   페이지정보     작업완료 후 다른페이지 이동
	public String sampleInsert(sampleVO vo, Model model, RedirectAttributes rttr) throws Exception{ //주소부터 msg변수로 값을 전달받는다.
		logger.info("msg값을 전달했습니다.");
		//삽입폼->처리->완료->목록
		samService.create(vo); //삽입처리
		//형식적인 선언
		rttr.addFlashAttribute("msg", "INSERT"); //다른페이지로 이동할 때 전달할 메세지
		return "redirect:/sampleList";
	}
	
	//삭제나 부분조회, 수정할 레코드 조회=>기본키 값만 가져와서
	//http://localhost:8080/delete?name=홍길동
	@RequestMapping("sampleDelete")
	//메서드 1개 하나의 페이지(JSP)          저장                ?전달받은값
	public String sampleDelete(@RequestParam("name") String name, Model model) throws Exception{
		logger.info("DTO의 값을 전달했습니다.");
		//dto생성하고 기본값을 저장		
	
		samService.delete(name);
		//전달페이지에 변수를 추가==>samVO DTO를
		return "sampleDeleteResult"; //데이터베이스(X)하고 페이지 이동
	}
	
}
