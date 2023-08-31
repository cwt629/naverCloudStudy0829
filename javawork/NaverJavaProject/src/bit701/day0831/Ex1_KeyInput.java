package bit701.day0831;

import java.util.Scanner;

// 컴파일 상 오류가 날 경우, eclipse에서는 저장 후 해당 줄 왼쪽 x표 눌러서 옵션 확인 가능
// 혹은 예를 들어 아래 Scanner 타입 어디든 입력바를 놓고 Ctrl + 1 눌러도 됨.

public class Ex1_KeyInput {

	public static void main(String[] args) {
		// static 변수나 메소드는 new로 객체 생성하지 않고 호출한다
		// 대표적으로 Math 클래스의 모든 메소드는 static이다.
//		System.out.println("3의 5승 : " + Math.pow(3, 5));
//		System.out.println("5,7 중 더 큰 값은? " + Math.max(5, 7));
		
		// new로 객체를 생성. 이 변수를 인스턴스 변수라고 함.
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("당신의 나이를 입력하세요");
		int age = sc.nextInt();
		System.out.println("응!! 나는 " + age + " 세야!!");
		
		/*
		 * 숫자 입력 후 문자열을 입력하는 경우는 입력이 안되는 현상 발생.
		 * 숫자 입력 후 발생하는 엔터값이 버퍼에 저장되는데
		 * 문자열 입력 시 이 버퍼를 먼저 읽고
		 * 없으면 키보드로 입력받는 원리이다.
		 * 그래서 우리가 나이 입력하고 다음에 친 "엔터"가 들어간다!
		 * 
		 * 그러면 이를 해결하는 방법은? 아래 2가지가 있다.
		 * 1) 버퍼의 엔터문자를 먼저 읽어서 없앤다.
		 * 2) 숫자를 읽을 경우도 무조건 nextLine으로 문자열로 입력 후, 변환해서 사용한다.
		 */
		
		// 해결방법1) 버퍼의 엔터문자를 먼저 읽어서 없앤다.
		sc.nextLine();
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine(); // 한줄 전체를 읽어온다
		System.out.println("내 이름은 " + name + " 입니다");
	}

}
