package bit701.day0830;

public class DataEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* main 함수의 인자를 넣어주고 싶다면?
		 * Run 메뉴 or 버튼옆 화살표 - Run Configuration - 클래스명(한번은 실행해야 생김) - Arguments
		 * - Program arguments > 인자 대입해주기! 띄어쓰기로 구분한다. 
		 * */
		System.out.println("내 이름은 " + args[0] + " 입니다");
		System.out.println("우리집은 " + args[1] + " 입니다");
		System.out.println("내 혈액형은 " + args[2] + "형입니다");
		System.out.println(); // 인자를 비워두면 그냥 줄바꿈
		System.out.println("실수형 데이터 타입");
		
		float f1 = 1234.567891234f; // 4바이트 float으로 값을 지정하려면 숫자끝에 f 추가
		double f2 = 1234.567891234;
		System.out.println(f1); // 1234.5679 : 8자리까지만 정확하게 출력(정수부+소수부 합해서!!)
		System.out.println(f2); // 1234.567891234 : 15자리까지 정확하게 출력
		
		char ch1 = 'A';
		char ch2 = '가';
		System.out.println(ch1);
		System.out.println(ch2);
	}

}
