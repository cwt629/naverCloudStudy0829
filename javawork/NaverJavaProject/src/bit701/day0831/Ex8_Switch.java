package bit701.day0831;

import java.util.Scanner;
/*
 * switch문은 jdk8 이전까지는 정수, 문자만 가능했으나
 * 그 이후 문자열도 가능해졌음
 */

public class Ex8_Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 숫자를 입력받아 1:one 2:two 3:three 그 외:other number 출력
		//		System.out.println("숫자를 입력하슈");
		//		int num = sc.nextInt();
		//		
		//		// switch는 num값에 따라서 해당 case 실행
		//		// 단 break가 없을 경우, (break를 만나기 전까지는) 끝까지 실행됨
		//		switch (num) {
		//		case 1:
		//			System.out.println("one!");
		//			break; // switch문을 빠져나간다.
		//		case 2:
		//			System.out.println("two!");
		//			break;
		//		case 3:
		//			System.out.println("three!");
		//			break;
		//		default:
		//			System.out.println("other number!");
		//		}

		// 
		System.out.println("영문 색상명을 입력하세요");
		String color = sc.nextLine();

		switch(color) {
		// 대문자인 경우와 소문자인 경우를 같이 고려하고 싶으면, 일부러 break를 걸어주지 않을 수 있음
		case "red": // break가 없으므로 다음 case문 실행
		case "RED":
			System.out.println(color + ": 빨강색" );
			break;
		case "green":
		case "GREEN":
			System.out.println(color + ": 초록색" );
			break;
		case "pink":
		case "PINK":
			System.out.println(color + ": 분홍색" );
			break;
		default:
			System.out.println(color + ": 그 이외의 색");
		}
	}

}
