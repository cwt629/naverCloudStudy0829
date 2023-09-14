package bit701.day0914;

import java.util.HashMap;
import java.util.Map;

public class Ex10_Map {

	public static void main(String[] args) {
		// Map: key-value 쌍으로 저장되는 형태(이 때 key는 Set 타입)
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "김태희");
		map.put("age", "30세");
		map.put("addr", "강남구");
		map.put("name", "송혜교"); // 같은 key로 넣는다면 덮어쓴다
		System.out.println("개수: " + map.size());
		// key 값을 알아야 value 값을 얻을 수 있다
		System.out.println("이름: " + map.get("name"));
		System.out.println("나이: " + map.get("age"));
		System.out.println("주소: " + map.get("addr"));
		System.out.println("혈액형: " + map.get("blood")); // 해당 key값이 없으면 null값 반환(error는 아님)
		
		System.out.println("addr 키값을 제거해보자");
		map.remove("addr"); // 해당 key값 제거
		System.out.println("주소: " + map.get("addr"));
	}

}
