package bit701.day0914;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Ex8_Set {

	public static void main(String[] args) {
//		Set<String> set = new HashSet<String>(); // 비순차적
		Set<String> set = new TreeSet<String>(); // 순서대로 나옴
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("green");
		set.add("green");
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("yellow");
		System.out.println(set.size()); // 중복 제외 4개
		
		for (String color:set)
			System.out.println(color);
	}

}
