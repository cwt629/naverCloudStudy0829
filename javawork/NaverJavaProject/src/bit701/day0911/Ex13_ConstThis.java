package bit701.day0911;

/*
 * this: 자기 자신을 의미하는 인스턴스 변수
 * 		인스턴스 멤버 메소드는 this라는 변수를 기본적으로 가지고 있다
 * this() : this() 는 생성자에서 다른 생성자 호출시 사용하는 방법이다
 * 		
 */

class Kiwi
{
	String name;
	int age;
	
	Kiwi()
	{
		//System.out.println("생성자 호출"); // error: this()는 반드시 첫줄에 나와야 한다!
		this("홍길동", 20); // 3번째 생성자 호출
	}
	
	Kiwi(String name)
	{
		this(name, 30);
	}
	
	Kiwi(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public void writeData()
	{
		System.out.println("name: " + name + "\tage: " + age);
	}
}

public class Ex13_ConstThis {

	public static void main(String[] args) {
		Kiwi []karr = {
				new Kiwi(),
				new Kiwi("kim"),
				new Kiwi("Lee", 35)
		};
		
		for (Kiwi k: karr)
			k.writeData();
	}

}
