import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.dao.OrderDAO;
import com.my.exception.NotFoundException;
import com.my.service.OrderService;
import com.my.vo.OrderInfo;
import com.my.vo.OrderLine;

public class OrderTest {
	public static void main(String[] args) {
		//OrderDAOOracle dao= new OrderDAOOracle();		
		String path = "beans.xml";
	  	ApplicationContext ctx;
	  	ctx = new ClassPathXmlApplicationContext(path);
	  	
	  	//OrderDAO dao = ctx.getBean("orderDAO", com.my.dao.OrderDAO.class);
	  	OrderService service = ctx.getBean("orderService", com.my.service.OrderService.class);
		
	  	String id="id1";
		try {
			List<OrderInfo> list = service.findById(id);
			for(OrderInfo info:list) {
				int order_no = info.getOrder_no();
				Timestamp order_time = info.getOrder_time();
				System.out.println("주문기본정보: "+order_no+","+order_time);
				List<OrderLine> lines = info.getOrderLines();
				for(OrderLine line : lines) {
					String p_no = line.getProduct().getProd_no();
					String p_name = line.getProduct().getProd_name();
					int p_price = line.getProduct().getProd_price();
					int quantity = line.getOrder_quantity();
					System.out.println("주문상세정보: "+p_no+","+p_name+","+p_price+","+quantity);
				}
				System.out.println("--------------------");
			}
		} catch (NotFoundException e) {
			System.out.println(e.getMessage()); //--출력
		}

		//------INSERT----------
		/*
		OrderInfo info = new OrderInfo();
		Customer c = new Customer();
		c.setId(id);
		info.setCustomer(c);//주문자
		
		List<OrderLine> orderLines = new ArrayList<>();
		
		OrderLine line = new OrderLine();
		Product p = new Product();
		p.setProd_no("10001");
		line.setProduct(p); //주문상품번호
		line.setOrder_quantity(2); //주문수량
		orderLines.add(line);
		
		line = new OrderLine(); //★★★★★새로 객체 생성 필수! 다른 OrderLine임.
		p = new Product();
		p.setProd_no("10003");
		line.setProduct(p); //주문상품번호
		line.setOrder_quantity(3); //주문수량
		orderLines.add(line);
		
		info.setOrderLines(orderLines);
		try{
			dao.insert(info);
			System.out.println("주문 추가 성공!"); //출력
		}catch(AddException e) {
			e.printStackTrace();
		}
		*/

	}
}
