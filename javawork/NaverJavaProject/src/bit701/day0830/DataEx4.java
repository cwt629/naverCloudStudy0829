package bit701.day0830;

public class DataEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("========16진수========");
		
		// a1 ~ a3 : 16진수
		int a1 = 0xa3; // 16진수 A3 -> 10진수: 10 * 16 + 3 * 1 = 163
		System.out.println(a1);
		
		int a2 = 0xf4; // 16진수 F4 -> 10진수: 15 * 16 + 4 * 1 = 244
		System.out.println(a2);
		
		int a3 = 0xa56; // 16진수 A56 -> 10진수: 10 * 16^2 + 5 * 16 + 6 * 1 = 2646
		System.out.println(a3);
		
		System.out.println("========8진수========");
		// a4 : 8진수 (앞에 0을 붙이면 8진수로 인식한다)
		int a4 = 045; // 8진수 45 -> 10진수: 4 * 8 + 5 * 1 = 37
		System.out.println(a4);
		
		// 참고: 2진수는 0b 혹은 0B 를 앞에 붙인다
	}

}
