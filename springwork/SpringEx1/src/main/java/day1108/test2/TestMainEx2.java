package day1108.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMainEx2 {

	public static void main(String[] args) {
		// 1. JAVA ���
		System.out.println("1. ���� �ڹ� ������� MessageInter ����");
		MessageInter m1 = new Message1();
		m1.sayHello("�����");
		MessageInter m2 = new Message2();
		m2.sayHello("�̽¹�");
		
		// 2. Spring ���
		System.out.println("2. �������� xml ���� ������� ��ü ����");
		// web������ �ڵ�ȣ�������, java������ �׷��� �����Ƿ� ���⼭�� �ʿ���
		ApplicationContext context = new ClassPathXmlApplicationContext("appcontext1.xml");
		MessageInter m3 = (Message1)context.getBean("mes1"); // ��ȯ Ÿ���� Object�� -> Ÿ���� �����ϰų� ����ȯ�ؼ� Ÿ�� ���߱�
		MessageInter m3_1 = (Message1)context.getBean("mes1");
		m3.sayHello("������");
		MessageInter m4 = context.getBean("mes2", Message2.class);
		MessageInter m4_1 = context.getBean("mes2", Message2.class);
		m4.sayHello("�赿��");
		
		System.out.println("�ּ� ���ϱ�");
		// singleton: ������ �����ص� �ּ� ����
		System.out.println(m3.hashCode() + "," + m3_1.hashCode());
		// prototype: ������ ������ �ּ� �޶���
		System.out.println(m4.hashCode() + "," + m4_1.hashCode());
	}

}
