package multi.erp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//mybatis의 핵심클래스를 이용해서 작성

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
		
		return sqlSession.insert("multi.erp.board.insert");
	}

	@Override
	public List<BoardVO> searchList(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> searchList(String tag, String search) {
		// TODO Auto-generated method stub
		return null;
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
