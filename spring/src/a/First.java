package a;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class First {
	private String msg;

	@Autowired(required = false)
	@Qualifier("s1")
	private Second second;

	private boolean flag;

	@PostConstruct
	public void init() {
		System.out.println("init()호출됨");
		flag = true;
	}

	public First(String msg) {
		super();
		this.msg = msg;
	}

	public First() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String toString() {
		return "msg=" + msg + ", second.info()=" + second.info();
	}
}
