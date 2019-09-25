import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import a.First;

public class Test {

	public static void main(String[] args) {
		//beans.xml사용
		String path = "beans2.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);
		
		//Beans.java사용(어노테이션 사용하기)
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
		First first = ctx.getBean("first", a.First.class);
		System.out.println(first);		

	}

}
