package multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//dao의 메소드를 호출하는 클래스
@Service
//서비스로 빈 생성
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	@Qualifier("boardDao")
	BoardDAO dao; //BoardDAO를 autowired시킬것이다.

	@Override
	public List<BoardVO> boardList(String category) {
		List<BoardVO> list=null;
		
		if(category!=null) {//카테고리가 널이 아니어야 작업할 수 있다.
			if(category.equals("all")) {
				list=dao.boardList();
			}else {
				list=dao.categorySearch(category);
			}
	}
		return list;
	}

	@Override
	public int txinsert(BoardVO board) {
		
		return 0;
	}

	@Override
	public int insert(BoardVO board) {
		
		return dao.insert(board);
	}

	@Override
	public List<BoardVO> searchList(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> searchList(String tag, String search) {
		// TODO Auto-generated method stub
		return dao.searchList(tag, search);
	}

	@Override
	public List<BoardVO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO read(String board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> findByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
