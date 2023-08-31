package bit701.day0831;

import java.util.Date;
import java.util.Scanner;

public class Ex2_KeyInput {

	public static void main(String[] args) {
		// Date 클래스를 이용해서 현재 년도를 구해보자(jdk 1.1에서 deprecate되었지만 여전히 많이 사용함)
		// 권장: Calendar를 권장한다고 함. (근데 보통 Date를 많이 쓴다고 함)
		Date date = new Date();
		// getYear는 1900을 뺀 값이 반환
		int curYear = date.getYear() + 1900;
		System.out.println("현재 년도:" + curYear);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("당신이 태어난 년도는?");
		// 문자열로 읽은 후 숫자로 변환한다! 이렇게 하면 다음에 문자열이 입력될 경우에도 문제 발생 x
		int birthYear = Integer.parseInt(sc.nextLine());
		
		System.out.println("지금 사는 곳은 어디야?");
		String address = sc.nextLine();
		
		// 나이 구하기
		int age = curYear - birthYear;
		System.out.println("아하 넌 " + address + "에 사는 " + birthYear + "년생(" + age + "세) 학생이구나!" );
		System.out.printf("아하 넌 %s에 사는 %d년생(%d세) 학생이구나!\n", address, birthYear, age);
		
		// 20세 이상이면 "성인", 미만이면 "미성년자" 라는 글자를 출력
		// if문으로 해도 되고, 조건(삼항)연산자(조건식? 참일때값 : 거짓일때값)로 해도 됨
		
		// 1. 삼항연산자 활용
		//String message = (age >= 20)? "성인" : "미성년자";
		
		// 2. if문 쓰기
		// 지역변수는 자동초기화가 안되고 쓰레기값이 들어있음
		// -> 값이 안들어갈 경우를 대비해 초기값을 지정하는 것이 좋다
		// 지역변수는 그 구역을 빠져나가게 되면 자동소멸되므로 사용 불가능
		String message = ""; 
		if (age >= 20) { // 한문장만 쓸경우는 {} 구역 설정 생략 가능
			message = "성인";
		} else {
			message = "미성년자";
		}
		System.out.println("당신은 " + message);
	}

}
