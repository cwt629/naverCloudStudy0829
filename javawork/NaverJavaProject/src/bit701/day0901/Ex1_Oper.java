package bit701.day0901;

public class Ex1_Oper {

	public static void main(String[] args) {
		// 대입 연산자: =, +=, -=, *=, /=, %=
		// 대입연산자나 증감연산자 이용 시, 해당 변수는 반드시 값이 들어있어야 함.
		// (기존 값을 기준으로 연산하는 것이기 때문!)
		int a = 5;
		
		// 아래 두 수식은 같은 수식임
		//a = a + 3;
		a += 3;
		System.out.println(a);
		
		a -= 1; // a-- 으로도 쓸 수 있다.
		System.out.println(a);
		
		a *= 5; // a = a * 5
		System.out.println(a);
		
		a /= 3; // 나누기는 소수점 이하 버림(정수니까)
		System.out.println(a);
		
		a %= 4; // a = a % 4
		System.out.println(a);
	}

}
