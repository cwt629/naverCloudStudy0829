package bit701.day0913;

// 봉인된(sealed) 클래스를 지정하는 방법 - jdk 15에서 추가된 기능
/*
 * 왜나온 거임?
 * -> 무분별한 자식 클래스 생성을 막기 위한 기능
 */
sealed class Person permits Employee, Manager {
	public String name;
	
	public void work() {
		System.out.println("하는 일이 결정되지 않았습니다.");
	}
}

// final class: 나 이후로 더 이상 상속시키지 않는다(마지막 자손)
final class Employee extends Person{
	@Override
	public void work() {
		super.work();
		System.out.println("제품을 생산합니다.");
	}
}

// non-sealed : 봉인을 해제한다(상속 가능)
non-sealed class Manager extends Person{
	@Override
	public void work() {
		super.work();
		System.out.println("생산 관리를 합니다.");
	}
}

public class Book330 {

	public static void main(String[] args) {
		Person p = new Person();
		p.work();
		System.out.println();
		Employee e = new Employee();
		e.work();
		System.out.println();
		Manager m = new Manager();
		m.work();
		
		System.out.println();
		Person p2 = new Manager();
		p2.work();
	}

}
