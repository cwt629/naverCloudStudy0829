package bit701.day0918;

/*
 *  자바에서의 함수형 프로그램인 람다 표현식은
 *  인터페이스를 사용하는 익명 내부 클래스의
 *  또 다른 표현식이다.
 *  단, 인터페이스는 단 하나의 추상 메소드만 가지고 있어야 한다.
 */

// "이 인터페이스를 함수형으로 사용하겠다" 라는 annotation
@FunctionalInterface
interface Orange
{
	public void write();
	//public void show(); // Error : @FunctionalInterface는 메소드가 하나인지 아닌지 검증하는 역할
}

@FunctionalInterface
interface DataAdd
{
	public void add(int x, int y);
}

public class Ex4_Lambda {

	// 우리가 알고 있는 익명 내부 클래스 형태로 객체 생성
	public void abstMethod1()
	{
		Orange or = new Orange() {
			
			@Override
			public void write() {
				System.out.println("ㅎㅇ");
			}
		};
		
		or.write();
	}
	
	// 람다식으로 오버라이드해보기
	public void abstMethod2()
	{
		Orange or = () -> System.out.println("ㅋㅋ"); // 메소드의 코드가 한줄인 경우 {} 생략
		or.write();
		
		// 오버라이드 메소드의 코드가 2줄 이상인 경우 {} 안에서 주면 된다
		Orange or2 = () -> {
			System.out.println("위");
			System.out.println("아래");
		};
		
		or2.write();
	}
	
	// 람다식으로 오버라이드해보기
	public void abstMethod3()
	{
		// 기존 방식: 익명 내부 클래스
//		DataAdd adder = new DataAdd() {
//			
//			@Override
//			public void add(int x, int y) {
//				System.out.println(x + "+" + y + "=" + (x + y));
//			}
//		};
		
		DataAdd adder = (x, y) -> System.out.println(x + "+" + y + "=" + (x + y));
		adder.add(100, 200);
	}
	
	public static void main(String[] args) {
		Ex4_Lambda ex = new Ex4_Lambda();
		ex.abstMethod1();
		ex.abstMethod2();
		ex.abstMethod3();
	}

}
