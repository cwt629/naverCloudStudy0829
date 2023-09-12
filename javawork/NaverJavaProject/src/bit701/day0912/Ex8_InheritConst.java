package bit701.day0912;

class SuperC
{
	protected String name;
	protected int age;
	
	public SuperC() {
		System.out.println("부모 디폴트 생성자 호출");
		name = "홍길동";
		age = 10;
	}
	
	SuperC(String name, int age)
	{
		System.out.println("부모의 두번째 생성자 호출");
		this.name = name;
		this.age = age;
	}
}

class SubC extends SuperC
{
	String hp;
	
	SubC() {
		super(); // 부모의 디폴트 생성자 호출: JAVA에서는 이거 안써도 그냥 내부적으로 호출된다(생략가능, 단 "디폴트일경우만")
		System.out.println("서브클래스의 디폴트 생성자 호출");
		hp = "010-111-222";
	}
	
	SubC(String hp)
	{
		// super() 생략되어 있음
		System.out.println("sub의 두번째 생성자 호출");
		this.hp = hp;
	}
	
//	SubC(String name, int age, String hp)
//	{
//		System.out.println("sub의 세번째 생성자 호출");
//		this.name = name;
//		this.age = age;
//		this.hp = hp;
//	}
	
	// 위의 방법보다는 아래 방법으로 부모 생성자를 호출하는 경우가 많다.
	SubC(String name, int age, String hp)
	{
		super(name, age); // 부모의 2번째 생성자 호출됨, 생략 안됨 - 반드시 첫줄
		System.out.println("sub의 세번째 생성자 호출");
		
		this.hp = hp;
	}
	
	public void dataShow()
	{
		// 부모 클래스의 멤버 변수가 protected이므로 패키지 상관없이 접근 가능
//		System.out.println("이름: " + this.name);
//		System.out.println("나이: " + this.age);
		System.out.println("이름: " + super.name); // 부모가 가진 변수는 this, super 모두 가능
		System.out.println("나이: " + super.age);
		System.out.println("핸드폰: " + this.hp);
		System.out.println("====================");
	}
}

////////////////////////////////////////////
public class Ex8_InheritConst {

	public static void main(String[] args) {
		SubC sub1 = new SubC(); // 결과: 부모 생성자 호출 > 서브클래스 디폴트 생성자 호출
		sub1.dataShow();
		
		SubC sub2 = new SubC("010-4545-6767");
		sub2.dataShow();
		
		SubC sub3 = new SubC("캔디", 12, "02-455-788");
		sub3.dataShow();
	}

}
