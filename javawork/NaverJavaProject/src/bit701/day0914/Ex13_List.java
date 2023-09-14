package bit701.day0914;

import java.util.Vector;

// List 인터페이스를 구현한 Vector나 ArrayList 연습

public class Ex13_List {

	public static void main(String[] args) {
		Vector<String> list1 = new Vector<String>(); // 기본 10개 할당(10개씩 증가)
		System.out.println("list1의 할당 개수: " + list1.capacity()); // 10개
		
		Vector<String> list2 = new Vector<String>(5); // 기본 5개 할당(5개씩 증가)
		System.out.println("list2의 할당 개수: " + list2.capacity()); // 5개
		
		Vector<String> list3 = new Vector<String>(3, 2); // 기본 3개 할당(2개씩 증가)
		System.out.println("list3의 할당 개수: " + list3.capacity()); // 3개
		
		list3.add("red");
		list3.add("green");
		list3.add("blue");
		list3.add("pink");
		
		System.out.println("list3의 할당 개수: " + list3.capacity()); // 5개
		System.out.println("list3의 데이터 개수: " + list3.size()); // 4개
		
	}

}
