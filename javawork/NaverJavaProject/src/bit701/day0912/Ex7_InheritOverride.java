package bit701.day0912;

class SuperB
{
	public void processA()
	{
		System.out.println("부모가 가진 메소드 A");
	}
	
	// my test
	public void notOverriden()
	{
		System.out.println("나의 테스트");
	}
}

class SubB extends SuperB
{
	/* tip)
	 * 메소드 오버라이딩할 때,
	 * 메소드명 조금 입력하다가 Ctrl + SpaceBar 눌러서
	 * 오버라이드 옵션 활용하자.
	 * 
	 * 오버라이딩할 때, 접근 지정자 범위가 더 넓거나 같아야 한다
	 * ex. 부모에서 protected였다면, 자식에서 protected or public
	 * (근데 보통은 그냥 public 준다)
	 * 
	 */
	@Override // 어노테이션(annotation? 없어도 상관은 없는데, 부모꺼랑 메소드명이 다르면 오류가 난다..?)
	public void processA() {
		// TODO Auto-generated method stub
		super.processA(); // 부모가 먼저 작업을 하고
		System.out.println("자식이 가진 오버라이드 메소드 A"); // 나머지는 자식 클래스에서 작업을 완성하겠다.
	}
	
	public void processB()
	{
		System.out.println("자식만이 가지고 있는 메소드 B");
	}
}

///////////////////////////////////////////////////
public class Ex7_InheritOverride {

	public static void main(String[] args) {
		SubB sub1 = new SubB();
		sub1.processA();
		sub1.processB();
		
		/*
		 * 다형성의 기본 원리
		 * 선언은 부모클래스로, 생성은 자식클래스로
		 * 
		 * processB는 호출할 수 없다
		 * 왜? 자식이 가진 것중 오버라이드된 것만 호출이 가능하다
		 * (자식"만"이 가지고 있는 메소드는 호출 불가능!)
		 */
		SuperB sub2 = new SubB();
		sub2.processA(); // 오버라이드된 자식이 가진 메소드 호출
		// sub2.processB(); // error
		sub2.notOverriden(); // my test: 원래 부모에 있던 건 당연히 쓸 수 있음
	}

}
