package bit701.day0908;
import bit701.day0908.hello.*; // bit701.day0908.hello 패키지의 모든 것을 가져오겠다

public class Ex1Object {

	public static void main(String[] args) {
		// 다른 패키지의 클래스를 생성해보자
		MyHello my = new MyHello();
		my.hello();
		
		// 같은 패키지에 있는 클래스 선언
		
		/* 다른 클래스여도 같은 패키지에 있으면
		 * private을 제외하고는 모두 접근 가능함
		 * 패키지가 다를 경우
		 * 상속관계가 아닐 경우 public만 유일하게 접근 가능
		 * */
		Test t = new Test(); // 같은 패키지는 import문도 필요 없음
		System.out.println("public 멤버 변수 출력: " + t.str1);
		System.out.println("protected 멤버 변수 출력: " + t.str2);
		System.out.println("default 멤버 변수 출력: " + t.str3);
		//System.out.println("private 멤버 변수 출력" + t.str4); // error 발생 - 접근이 안됨
		
	}

}
