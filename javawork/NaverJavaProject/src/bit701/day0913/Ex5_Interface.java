package bit701.day0913;

/*
 * interface는 기능구현을 할 메소드들의 목록을 나열해놓는 일을 한다
 * interface에는 상수와 추상 메소드만 구현이 가능하다.
 * 그래서 구분을 할 필요가 없기 때문에,
 * final, abstract 단어는 안 써도 된다.
 * (어차피 100% 상수와 추상 메소드로만 구성이 되어 있기 때문)
 * 
 * interface도 new로 생성할 수 없다.
 */

interface InterA
{
	int SCORE = 100; // final 상수
	public void play(); // abstract method
	public void study();
}

// 일반 클래스가 interface를 구현할 경우, implements 로 구현
// 인터페이스를 구현한 경우 반드시 모든 메소드를 오버라이드해야만 한다.
/*
 * tip: 
 * 인터페이스의 메소드 오버라이드 할 때
 * 자동화 기능을 활용할 수 있다.
 * 1. Source > Override/Implement Methods
 * 2. (오류나서 빨간줄 쳐진)클래스명에서 Ctrl + 1로 옵션 확인 > implement methods
 */
class My implements InterA
{
	int myscore = SCORE;

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("SCORE = " + SCORE); // 상수 출력
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		//SCORE = 90; // error: final 상수는 변경할 수 없음
		myscore = 80; // 상수값을 초기값으로 받아온 변수를 활용한다
		System.out.println("점수 변경함: " + myscore);
	}
	
	// My 클래스만이 가지고 있는 메소드
	public void processMy()
	{
		System.out.println("My 클래스가 단독으로 처리하는 작업");;
	}
}

public class Ex5_Interface {

	public static void main(String[] args) {
		InterA a = new My();
		a.play();
		a.study();
		// a.processMy(); // error: 오버라이드 메소드가 아니므로 My로 선언 시에만 호출 가능
		System.out.println("--------------------------");
		My b = new My();
		b.play();
		b.study();
		b.processMy();
	}

}
