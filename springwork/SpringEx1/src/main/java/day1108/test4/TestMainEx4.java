package day1108.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx4 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext1.xml");
		
		Bitcamp bit = (Bitcamp)context.getBean("bit");
		bit.infoProcess();
	}

}
