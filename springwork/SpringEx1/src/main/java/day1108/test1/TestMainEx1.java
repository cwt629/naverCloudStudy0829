package day1108.test1;

public class TestMainEx1 {

	public static void main(String[] args) {
		TestDto dto = new TestDto();
		dto.setName("�����");
		dto.setAddr("����");
		dto.setAge(28);
		
		System.out.println("�̸�: " + dto.getName());
		System.out.println("�ּ�: " + dto.getAddr());
		System.out.println("����: " + dto.getAge());
		
		System.out.println("toString() ȣ��");
		// dto Ŭ���� ���� @ToString �ٿ��ָ�, toString �Ⱥٿ��� �ڵ� ȣ��ȴ� ����
		System.out.println(dto); // ������ dto.toString()�ε�, �Ƚᵵ �ڵ�ȣ���
		
		TestDto dto2 = new TestDto("�̽¹�", "������", 24);
		System.out.println(dto2);
		
		TestDto dto3 = new TestDto("������");
		System.out.println(dto3);
	}

}
