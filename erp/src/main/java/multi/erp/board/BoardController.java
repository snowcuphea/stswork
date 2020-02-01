package multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	//요청 path
	@RequestMapping("/board/list.do")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();
		
		//1.요청정보 추출
		//2.비지니스메소드 호출
		List<BoardVO> list = service.boardList();
		System.out.println(list);
		
		//3.데이터공유 - jsp페이지에서 응답뷰만들때 사용
		//addObject 로 한 기본값은 request scope에 저장된다. 
		//mav.addObject(attributeName, attributeValue)
		mav.addObject("boardlist", list);
		
		//4.뷰의 이름을 등록
		mav.setViewName("board/list"); //tiles에 등록하는 이름과 일치
		
		//5. 요청재지정 할 껀데 기본이 forward 다. 
		return mav;
		
	}
	//게시글을 작성하기 위한 뷰를 response할 메소드
	@RequestMapping(value = "/board/write.do", method=RequestMethod.GET)
	public String insertView() {
		return "board/write"; //tiles에 등록한 뷰 이름
	}
	
	//입력한 글을 실제 db에 저장하는 메소드
	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
	public String insert(BoardVO board) {
		System.out.println("*****************************"+board);
		int result = service.insert(board);
		System.out.println("###################" + result);
		return "redirect:/board/list.do"; //글 쓴 뒤 글 목록을 보여준다.
	}
	


}
