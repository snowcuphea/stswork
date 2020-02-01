package dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



//사용자 정의 dao클래스. 빈으로 인식이 되어야 하기 때문에, Repository 어노테이션을 사용한다.
@Repository //DB연동과 관련된 빈을 만들 때 Repository를 사용한다.
public class DeptDAOImpl {
	//xml에 빈 등록을 하면서 , 내 변수로 쓸 수 있게 맵핑시킬 거라서 Autowired 어노테이션 쓴다.
	@Autowired
	
	//JdbcTemplate 쓸꺼야
	JdbcTemplate mytemplate;
	public int count() {
		return mytemplate.queryForObject("select count(*) from dept", Integer.class);
		//queryForObject("쿼리문", 반환타입을 명시);
		//이 많은 코드들은 JdbcTemplate에서 처리해 준다. 커넥션 맺고, 프리패어드 만들고, sql실행하고, 결과가지고 rs하고 이거 다 queryForObject로 처리한다.
	}
	
	public int insert(String deptno, String deptname) {
		String sql = "insert into dept(deptno, deptname) values(?,?)";
		int result = mytemplate.update(sql, deptno, deptname); //update("쿼리문", '?'에 해당하는 파라미터 순서대로 나열하면 된다.)
		return result;
	}
	
	public int update(String deptno, String deptname) {
		String sql = "update dept set deptname=? where deptno=?";
		int result = mytemplate.update(sql, deptname, deptno); //update("쿼리문", '?'에 해당하는 파라미터 순서대로 나열하면 된다.)
		return result;
	}
	
	public List<DeptDTO> selectAll(){
		
		return mytemplate.query("select deptno, deptname from dept", new MyDeptRowMapper());
		
	}

}
