package dept;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext factory = new GenericXmlApplicationContext("config/erp.xml");
		DeptServiceImpl service = factory.getBean("deptService", DeptServiceImpl.class);
		
		System.out.println("전체부서갯수: " + service.count());
		//System.out.println("삽입 성공?"+ service.insert("exam01", "framework"));
		System.out.println("수정 성공? " + service.update("exam01", "부서"));
	
		List<DeptDTO> list = service.selectAll();
		
		for( int i = 0 ; i<list.size();i++) {
			DeptDTO dept = list.get(i);
			System.out.println(dept.getDeptno()+" : "+dept.getDeptname());
		}
	}

}
