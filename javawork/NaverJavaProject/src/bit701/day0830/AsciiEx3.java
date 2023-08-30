package bit701.day0830;

public class AsciiEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// char, int는 같은 타입이라고 봐도 된다(ascii value 내에서 할당 가능)
		char a1 = 65;
		int a2 = 'B';
		System.out.println(a1); // 결과: A
		System.out.println(a2); // 결과: 66
		System.out.println((int)a1); // 아스키코드값으로 출력하고 싶은 경우, 형변환시키기 => 결과: 65
		System.out.println((char)a2); // 결과: B
		
		System.out.printf("%d 의 아스키문자는 %c 이다\n", (int)a1, a1);
		
		char b1 = 'C';
		int b2 = 68;
		
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b1+2); // 묵시적 형변환에 의해서 char+int=int, 그러므로 E가 아니라 69가 나옴
		
		/* 묵시적 형변환(+는 실제 더하기 말고도 연산을 의미함. 마이너스도 됨)
		 * char + int = int
		 * int + int = int
		 * long + int = long (더 큰걸 따른다)
		 * double + int = double
		 * String + int = String
		 * String + double = String
		 */
		
		// 그럼 묵시적 형변환 결과 말고 다른 타입으로 출력하고 싶으면? 강제로 형변환해준다.
		System.out.println((char)(b1+2)); // b1+2=69로 int타입이 되는데, char로 강제 형변환해서 출력
		
		// [Self] char + char도 int가 나와버리네...
//		char test1 = 'Z', test2 = 'A';
//		System.out.println(test1 + test2);
		
		System.out.println(5 / 2); // 2 (int와 int의 연산이므로 무조건 결과는 int타입이다)
		System.out.println(5.0 / 2); // 2.5 (double + int = double)
		System.out.println((double)5 / 2); // 2.5 (앞 수 5가 double로 인식됨)
		System.out.println((double)(5/2)); // 2.0 (5/2가 먼저 계산되어 버림! 이미 2가 나와버린 채로 double 붙여봐야...)
		
		// 오버로딩 : println의 인자 안에 어떤 타입을 넣어도 출력되는건, 타입마다 다 만들어놨기 때문!
		/*
		 *  print나 println 은 모든 타입 출력이 가능하다.
		 *  타입별로 여러 개를 같은 이름으로 만들어놨기 때문이다.
		 *  이런 메소드를 중복함수(overloading method)라고 한다.
		 */
		
	}

}
