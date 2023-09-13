package bit701.day0913;

class Parent{
	public void method1() {
		System.out.println("Parent-method1()");
	}
	
	public void method2() {
		System.out.println("Parent-method2()");
	}
}

// 상속받는 클래스 구현
class Child extends Parent{
	@Override
	public void method2() {
		System.out.println("Child-method2()");
	}
	
	public void method3() {
		System.out.println("Child-method3()");
	}
}

public class Book309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child a = new Child();
		a.method1(); // 상속받은 메소드
		a.method2(); // Child의 method2가 호출
		a.method3(); // Child에만 있는 메소드
		System.out.println("-".repeat(20));
		
		Parent b = new Child();
		b.method1();
		b.method2();
		//b.method3(); // error: child의 메소드 중엔 오버라이드한 메소드만 호출 가능
		((Child)b).method3(); // 강제로 Child로 형변환 후에는 호출이 가능은 하다(상속 관계일 때만 가능)
	}

}
