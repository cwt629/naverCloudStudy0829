package day1108.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx2 {

	public static void main(String[] args) {
		// 1. JAVA 방식
		System.out.println("1. 기존 자바 방식으로 MessageInter 생성");
		MessageInter m1 = new Message1();
		m1.sayHello("장원태");
		MessageInter m2 = new Message2();
		m2.sayHello("이승민");
		
		// 2. Spring 방식
		System.out.println("2. 스프링의 xml 설정 방식으로 객체 생성");
		// web에서는 자동호출되지만, java에서는 그렇지 않으므로 여기서만 필요함
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext1.xml");
		MessageInter m3 = (Message1)context.getBean("mes1"); // 반환 타입이 Object임 -> 타입을 지정하거나 형변환해서 타입 맞추기
		MessageInter m3_1 = (Message1)context.getBean("mes1");
		m3.sayHello("이준일");
		MessageInter m4 = context.getBean("mes2", Message2.class);
		MessageInter m4_1 = context.getBean("mes2", Message2.class);
		m4.sayHello("김동현");
		
		System.out.println("주소 비교하기");
		// singleton: 여러번 생성해도 주소 동일
		System.out.println(m3.hashCode() + "," + m3_1.hashCode());
		// prototype: 생성할 때마다 주소 달라짐
		System.out.println(m4.hashCode() + "," + m4_1.hashCode());
	}

}
