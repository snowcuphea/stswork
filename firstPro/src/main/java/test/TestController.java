package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//기본 web에서 작성하던 서블릿과 동일한 역할을 하는 클래스
//스프링에서는 컨트롤러라고 부름
//- DispatcherServlet에서 호출되는 클래스임.
//- 서블릿에서 했던 것 처럼 dao의 메소드를 호출함.
//- 데이터 공유(스프링의 방법대로)

@Controller
public class TestController {
@RequestMapping("/test.do")

	public ModelAndView test() {
		System.out.println("컨트롤러 요청 완료");
		//ModelAndView는 응답할 뷰로 넘겨줄 공유데이터 정보와 응답뷰에 대한 정보를 담고 있는 스프링객체임.
		ModelAndView mav = new ModelAndView();
		String data="";
		for(int i=1;i<=9;i++) {
			data = data +(9+"*"+i+"="+(9*i))+"<br/>";
		}
		//공유 데이터 저장
		//request.setAttribute("msg","스프링컨트롤러에서 넘긴 데이터"); 한거랑 똑같음.
		mav.addObject("msg",data);
		
		
		//spring은 default가 forward임.
				//forward할 뷰의 정보를 정의
		mav.setViewName("test/result"); 
		return mav;
	}
	

}
