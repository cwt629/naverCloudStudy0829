package bit701.day0913;

// 1번 예제의 메소드들을 호출해보자

public class Ex2_Inherit {

	// 인자를 SubA로 하면, SubA만 보낼 수 있다. (모든 서브클래스들을 부르려면 총 3개를 따로 만들어 오버라이딩해야함!)
//	public static void processPlay(SubA sub)
//	{
//		sub.process();
//	}
//	
//	public static void processPlay(SubB sub)
//	{
//		sub.process();
//	}
//	
//	public static void processPlay(SubC sub)
//	{
//		sub.process();
//	}
	
	// 위 3개의 메소드를 하나로 줄여서 만들려면?
	// 인자를 부모클래스로 선언하면 된다!
	public static void processPlay(SuperA s) {
		// 서브클래스 메소드 중에서, 호출할 수 있는 메소드는 오버라이딩 메소드 뿐이다.
		// (물론 부모클래스에서만 정의되어 있는 메소드도 호출할 수 있다)
		s.process(); // s 변수에 누가 생성되어 있느냐에 따라서 하는 일이 달라진다(다형성)
	}
	
	public static void main(String[] args) {
		processPlay(new SubA());
		processPlay(new SubB());
		processPlay(new SubC());
	}

}
