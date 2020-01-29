package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class IndexController {
	@RequestMapping("/index.do")

	public String main() {
		System.out.println("어노테이션 기반 컨트롤러");
		return "test/index";
	}

}
