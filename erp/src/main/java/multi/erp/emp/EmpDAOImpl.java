package multi.erp.emp;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //빈등록하는 작업
public class EmpDAOImpl implements EmpDAO {
	@Autowired
	SqlSession sqlsession;

	@Override
	public MemberVO login(MemberVO loginUser) {
		
		return sqlsession.selectOne("multi.erp.emp.memberlogin", loginUser); //emp.xml에 작성한 sql문 실행
		//loginUser타입 반환 
		//레코드가 하나인 경우 selectOne메소드를 사용한다. 
	}

	
	
	@Override
	public ArrayList<MemberVO> getTreeEmpList(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberVO> search(String column, String search, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberVO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public boolean idCheck(String id) {
		boolean result = false;
		MemberVO user=  sqlsession.selectOne("multi.erp.emp.idcheck",id);
		if(user!=null) {
			result = true;
		}
		return result;
	}

	@Override
	public MemberVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
