package bit701.day0908;

public class Ex4Object {
	// 인스턴스 멤버 변수
	private int score;
	// 클래스 멤버 변수
	static public String message; // final이 아니므로 변경 가능한 변수임
	
	// 인스턴스 멤버 메소드
	// score에 값을 넣는 메소드(setter method)
	// setter method 만드는 규칙: set[변수명: 첫글자 대문자]
	public void setScore(int score)
	{
		// 인스턴스 멤버 변수와 인자의 이름이 같은 경우가 많다.
		// 이름이 다르면 그냥 인스턴스 멤버 변수 이름을 쓸 수 있지만,
		// 같은 경우는 인스턴스 멤버 변수를 접근하려면
		// this를 이용하면 된다.
		// 다르면 this를 생략해도 된다.
		// 예) this.score = score; 
		
		// 멤버변수 score에 인자로 받은 score를 전달
		this.score = score;
	}
	
	// 점수를 반환하는 getter method
	// getter method 만드는 규칙: get[변수명: 첫글자 대문자]
	public int getScore()
	{
		return score; // this.score에서 this가 생략 가능
	}
	
	// static 메소드는 static 멤버 변수만 접근 가능
	// this 대신 클래스명으로 받아온다.
	// 물론 현재 예시에서는 message도 public이라 굳이 이렇게 안해도 됨
	public static void setMessage(String message)
	{
		Ex4Object.message = message;
	}
	
	public static void main(String[] args) {
		// main 메소드는 static이므로 new로 생성을 해야 멤버 접근이 가능하다
		// 단, static은 호출 가능
		
		Ex4Object.setMessage("Hello World!!");
		// public이므로 바로 출력 가능
		System.out.println(Ex4Object.message);
		
		Ex4Object ex4 = new Ex4Object();
		ex4.setScore(89);
		System.out.println("점수: " + ex4.getScore());
	}

}
