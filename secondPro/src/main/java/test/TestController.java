package test;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController  {
@RequestMapping("/test.do")

	public ModelAndView test() { 
		System.out.println("어노테이션 컨트롤러 요청 완료");
		
		ModelAndView mav = new ModelAndView();
		String data="";
		mav.addObject("msg",data);
		mav.setViewName("test/result");
	
		return mav;
}
	


}
