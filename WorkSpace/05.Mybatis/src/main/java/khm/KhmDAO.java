package khm;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import customer.CustomerVO;

public class KhmDAO {

	public void test() {
		String resource = "mybatis/conn.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		try (SqlSession session = sqlSessionFactory.openSession()) {
			// int dualInt = session.selectOne("khm.dual");
			// session.method (-> .insert, update, delete, selectOne, selectList)
			//  selectOne , selectList
			// 데이터 한건, 여러건 조회
			// selectOne("") => parameter (statement)
			// mapper namespace.id
			// System.out.println("mybatis를 통해 select : " + dualInt);
			// vo: getter & setter를 만들면 자동으로 되는것은 bean(Spring 객체 만들때만 사용됨)
			// KhmVO vo = session.selectOne("khm.voselect");
			// System.out.println("==");
			// List<KhmVO> voList = session.selectList("khm.listselect");
			// System.out.println("리스트 사이즈 : " + voList.size());

			// 파라메터의 전송은 단 하나의 객체만 가능하다 => String, int, ArrayList, HashMap..
			// $, # <=
			// $ 표시는 ex) vo를 파라메터로 넘기면 vo에 값을 그대로 출력(조건으로 사용)
			// where id = field1 (x) field1이라는 컬럼이 없기 때문에 오류
			// # 표시는 데이터 타입에 맞춰서 처리가 된다.
			// where id = 'field1' (o) 값 비교이기때문에 오류 x

			// 파라메터는 어떤 타입이든 상관 없지만 하나만 전송할 수 있음 (Parameter Object)
			// 변수를 여러개 가지고있는 클래스를 만든다(구조가 DB와 같은 것 ==> VO, DTO 활용)
			// String data = session.selectOne("khm.selectwhere1", 1);
			// System.out.println(data);
			// CustomerVO 만들기
			// CustomerVO vo = new CustomerVO();
//			  vo.setId(1);
//			  vo.setName("NAME");
//			  CustomerVO data = session.selectOne("khm.selectwhere2", vo);
//			  System.out.println(data.getName());

			List<CustomerVO> list = session.selectList("khm.selectwhere3");
			System.out.println(list);
			for (CustomerVO vo : list) {
				System.out.println(vo.getId() + " " + vo.getName() + " " + vo.getEmail());
			}

			// 내가 VO를 가지고있지않음
			// ID, NAME, GENDER, EMAIL, PHONE
			// 3, '최채윤'
			// HashMap<K, V> <= Key, Value 둘 다 클래스타입 가능
			HashMap<String, Object> params = new HashMap<>();
			params.put("id", 3);
			params.put("name", "최채윤");
			String name = session.selectOne("khm.mapselect", params);
			System.out.println(name);
		}
	}
}
