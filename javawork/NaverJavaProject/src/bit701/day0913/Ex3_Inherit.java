package bit701.day0913;

/*
 * 다형성 처리 시
 * 부모가 하는 일이 없으면
 * 어떻게 해야 할까?
 * 
 * 오버라이딩을 위해서 그래도 일단 메소드는 만들어야 한다.
 * 
 * 혹은, 메소드를 미완성 형태로 정의하는 추상화 기법을 활용할 수도 있다.
 */

/*
 * 추상 클래스의 특징
 * 1. 일반 메소드와 미완성의 abstract 메소드 둘다 구현 가능하다.
 * 2. abstract(추상) 클래스는 new로 객체 생성을 할 수 없다.
 * 3. 추상 클래스를 상속받는 클래스는 반드시 추상 메소드를 오버라이드해서 기능을 구현해야만 한다.
 * 4. 만약 추상 메소드를 오버라이드하지 않을 경우, 서브클래스도 역시 추상화시켜야만 한다.
 */
abstract class SuperColor
{
//	public void draw()
//	{
//		// 부모 클래스가 하는 일이 없으므로 안에 내용도 없음
//		// 단 "오버라이딩" 하나 때문에, 이 메소드 자체를 안 만들 수는 없다(안 만들면 error)
//	}
	
	// 오버라이드를 위해 바디 부분인 {} 부분을 없앤다(미완성적 개념으로... => 추상화)
	// abstract : 추상화 - 미완성적인 메소드라는 의미
	/*
	 * class의 멤버 메소드 중 "한 개라도" 추상 메소드가 있는 경우
	 * 반드시 클래스도 추상화시켜야 한다.
	 * 즉, class 앞에 abstract를 붙인다.
	 */
	abstract public void draw(); 
	
	// 오버라이드를 하지 않는 경우에도 서브클래스에서 호출 가능
	// 단, 부모로 선언 시, 서브클래스에만 있는 메소드는 호출 불가능 
	public void parentJob()
	{
		System.out.println("부모는 오늘도 돈을 벌어온다");
	}
}

// 3개의 서브 클래스들
class SubRed extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("집안 청소를 한다");
	}
}

class SubGreen extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("식사 준비를 한다");
	}
}

class SubBlue extends SuperColor
{
	@Override
	public void draw() {
		System.out.println("설거지를 한다");
	}
}

public class Ex3_Inherit {

	public static void draw(SuperColor s)
	{
		s.parentJob(); // 부모가 가지고 있는 메소드 호출(오버라이드 x)
		s.draw();
	}
	
	public static void main(String[] args) {
		SuperColor ss = new SuperColor() {
			
			@Override
			public void draw() {
				// TODO Auto-generated method stub
				
			}
		};
		
		draw(new SubBlue());
		draw(new SubGreen());
		draw(new SubRed());
	}

}
