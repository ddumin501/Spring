import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.my.vo.Customer;

public class Test {

	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource); 
			// inputStream = new FileInputStream(resource);// ClassPath경로인 bin폴더에 가서 찾음
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();

			/*
			 * //--UPDATE //session.update("com.my.vo.Customer.updateName", "id1"); //자동
			 * commit X --> 실제 반영 x HashMap<String, String> map = new HashMap<>();
			 * map.put("id", "ddumin"); map.put("name", "하수밍");
			 * session.update("com.my.vo.Customer.updateName",map); session.commit(); //수동
			 * commit 꼭 필요
			 */

			/*
			 * //--INSERT Customer c = new Customer(); c.setId("Idtest"); c.setPwd("ptest");
			 * c.setName("n테스트"); c.setAddr("상세주소1");
			 * session.insert("com.my.vo.Customer.insert",c); session.commit();
			 */

			/*
			 * //--DELETE session.delete("com.my.vo.Customer.delete","Idtest");
			 * session.commit();
			 */

			// --SELECT
			/*
			 * Customer c1 = session.selectOne("com.my.vo.Customer.selectById","Idtest");
			 * System.out.println(c1.getName()+":"+c1.getPwd());
			 * 
			 * int cnt = session.selectOne("com.my.vo.Customer.selectCount");
			 * System.out.println("총 고객수:"+cnt);
			 * 
			 * HashMap map2 = session.selectOne("com.my.vo.Customer.selectGroup");
			 * System.out.println(map2.get("C1")+":"+map2.get("C2")); //Oracle의 특징 --> 별칭에
			 * 대한 헤딩 이름을 대문자로 반환
			 * 
			 * List<Customer> list = session.selectList("com.my.vo.Customer.selectAll");
			 * System.out.println("총 고객행수: " + list.size()); for(Customer c : list) {
			 * System.out.println(c.getId()+":"+c.getName()); }
			 */
			Customer c3 = session.selectOne("com.my.vo.Customer.selectZipcodeById", "PSB");
			 System.out.println(c3.getId() + " : " + c3.getPost().getZipcode() + " : "
					 + c3.getName() + " : " + c3.getPost().getBuildingno()); //has-a관계 설정 필수
			 
			session.close(); // session 닫아주기 --> leak 방지
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
