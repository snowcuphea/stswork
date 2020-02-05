package multi.erp.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//mybatis의 핵심클래스를 이용해서 작성

//sql문 하나당 메소드 한 개를 정의. 하나의 메소드는 하나의 sql만 처리할 수 있다.


@Repository("boardDao")
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<BoardVO> boardList() {
		//select문의 실행결과가 여러 개의 레코드를 반환하는 경우 사용
		//return sqlSession.selectList("mapper의 등록한 sql문 id");
		//(namespace포함!!!!)//board.xml에 기술해 놓았으니 보고 쓰자.
		return sqlSession.selectList("multi.erp.board.listall");
	}

	@Override
	public int insert(BoardVO board) {
		
		return sqlSession.insert("multi.erp.board.insert",board);
		
		
	}

	@Override
	public List<BoardVO> categorySearch(String category) {
		System.out.println("dao=>"+category);
		List<BoardVO> list = sqlSession.selectList("multi.erp.board.categorySearch", category);
		System.out.println(list);
		//디버깅. 다 찍어봐야 어디서 에러낫는지 알수잇다
		
		return sqlSession.selectList("multi.erp.board.categorySearch", category);
	}

	//검색어별로 조회 - 동적 SQL 활용
	@Override
	public List<BoardVO> searchList(String tag, String search) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag); //입력받은 태그값을 넣는다. tag라는 이름으로 태그 넘겨줄것이다.
		map.put("search", search);
		
		
		return sqlSession.selectList("multi.erp.board.dynamicSearch",map);
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

}
