package multi.erp.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//emp테이블에서 작업하는 모든 내용에 대한 컨트롤러 
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
	EmpService service;
	
	//로그인 페이지를 보기 위한 요청, 컨트롤러는 Service 오토와이어드 해야한다. 
	@RequestMapping(value="/emp/login.do", method=RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	//로그인 처리를 위한 요청
	//매개변수가 VO객체 : 스프링 MVC내부의 클래스인 DispatcherServlet에서 자동으로 입력된 파라미터들을 추출해서
	// VO객체를 만들고, setter메소드의 값으로 전달한다. 
	@RequestMapping(value="/emp/login.do", method=RequestMethod.POST)
	public ModelAndView login(MemberVO loginUserInfo, HttpServletRequest request) {
		//일단 데이터 잘 받아왔는지부터 체크
		System.out.println("로그인 하기 위해서 사용자가 입력한 값:"+loginUserInfo);
		
		ModelAndView mav = new ModelAndView();
		//user => db연동 후 로그인된 사용자의 정보
		//loginUserInfo => 로그인 하기 위해서 사용자가 입력한 데이터를 vo로 만든 객체
		MemberVO user = service.login(loginUserInfo);
		System.out.println("로그인 성공 후 조회된 레코드로 만들어진 값 : "+user);
		
		//로그인한 사용자의 정보를 세션에 저장
		//세션을 사용하기 위해서 매개변수에 HttpServletRequest를 정의
		//1. 세션을 생성
		//	=> getSession()를 이용해서 세션을 생성
		//	=> 무조건 생성해서 리턴 (처음 세션을 만들 때 사용)
		String viewName = "";
		if(user!= null) {//null체크
			//로그인 성공 시 (//뷰를 다르게 하려고 경우를 2개를 만들었다.)
			HttpSession ses = request.getSession();//getSession() 얘는 무조건 만들어서 리턴해야 한다!!!!!!!!
			//2. 세션에 데이터 공유 (ses는 세션)
			ses.setAttribute("user", user);  
			viewName = "login/ok";
		}else {
			//로그인 실패 시 로그인 페이지 다시 보여준다. 
			viewName = "login";
		}
		mav.setViewName(viewName);
		return mav;
	}
	
	
	
	@RequestMapping("/emp/logout.do")
	public String logout(HttpSession session) {
		//로그아웃 처리를 위해 매개변수로 session을 받도록 처리
		//사용하던 세션객체가 있으면 사용하던 세션객체가 전달된다.
		
		if(session!=null) {
			//null이 아니라 세션이 존재하면, 세션객체를 해제
			session.invalidate(); //invalidate()는 session에서 사용할 수 있는 메소드
		}
		return "redirect:/index.do";
		
	}
	
	@RequestMapping("/emp/insertView.do")
	public String insertView() {
		return "emp/insert";
		
	}
	
	//produces 속성: ajax요청 후 클라이언트로 전송할 데이터의 타입을 정의
	//				application/text는 Ajax요청 후 클라이언트로 보내는 응답메시지의 타입이 text라는 뜻
	
	@RequestMapping(value="emp/idCheck.do", method=RequestMethod.GET,
			produces="application/text;charset=utf-8")
	public @ResponseBody String idCheck(String id) {
		boolean state = service.idCheck(id);
		String result = "";
		if(state) { //이미 사용자가 입력한 아이디가 db에 저장되어 있다는 의미
			result = "사용불가능한 아이디";
	
		}else {
			
			result = "사용가능한 아이디";
		}
		
		return result;
		
	}
	

	
}
