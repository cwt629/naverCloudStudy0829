package bit701.day0914;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex14_List {

	public static void main(String[] args) {
		// List는 데이터를 넣은 순서대로 저장되고 중복데이터도 저장됨(Set과 다름) 
		List<String> list = new Vector<String>();
		list.add("장미꽃");
		list.add("안개꽃");
		list.add("장미꽃");
		list.add("국화꽃");
		list.add("할미꽃");
		
		System.out.println("출력 방법 1");
		for (int i = 0; i < list.size(); i++)
		{
			String s = list.get(i);
			System.out.print(s + " ");
		}
		System.out.println("\n=====================");
		
		System.out.println("출력 방법 2");
		for (String s:list)
			System.out.print(s + " ");
		System.out.println("\n=====================");
		
		System.out.println("출력 방법 3");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
		System.out.println("\n=====================");
		
		System.out.println("출력 방법 4");
		Object []data = list.toArray();
		for (Object ob:data)
			System.out.print((String)ob + " ");
	}

}
