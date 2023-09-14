package bit701.day0914;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex7_Set {

	public static void main(String[] args) {
		/*
		 * Set 인터페이스의 특징
		 * 1. 순차적이지 않다. (순서는 지멋대로임)
		 * 2. 중복을 불허한다.
		 */
		Set<Integer> set = new HashSet<Integer>(); // 비순차적
		//Set<Integer> set = new TreeSet<Integer>(); // 오름차순 정렬
		System.out.println(set.size()); // size : 데이터의 개수(배열은 length)
		set.add(30);
		set.add(25); // Self: 이거 넣으니까 오름차순 아닌거 확인했다
		set.add(1);
		set.add(5);
		set.add(10);
		set.add(5);
		set.add(7);
		System.out.println(set.size()); // 5는 한번만 계산됨
		
		System.out.println("--------------------------------");
		// 컬렉션들을 출력하는 방법은 여러가지가 있다
		// 출력 1 : 각 요소 받아오기 (직관적인 듯)
		for (Integer n:set)
			System.out.println(n);
		System.out.println("--------------------------------");
		
		// 출력 2 : Iterator 활용 (잘 안쓴다고 함)
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println("--------------------------------");
		
	}

}
