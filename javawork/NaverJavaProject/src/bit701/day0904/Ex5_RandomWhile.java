package bit701.day0904;

import java.util.Scanner;

public class Ex5_RandomWhile {

	public static void main(String[] args) {
		/*
		 * [문제]
		 * 1~100 사이의 난수를 발생 후 숫자 알아맞추기
		 * 
		 * [예시]
		 * 65 발생 시
		 * 	1: 60
		 * 		60보다 큽니다
		 *  2: 70
		 *  	70보다 작습니다
		 *  	.
		 *  	.
		 *  	.
		 *  5: 65
		 *  	정답입니다(65) - 맞출 경우 종료
		 */
		
		Scanner sc = new Scanner(System.in);
		// 1~100 사이의 난수 구하기
		int answer = (int)(Math.random() * 100) + 1;
		int count = 0; // 횟수를 구할 변수
		int num; // 입력받을 변수
		
		while (true)
		{
			System.out.print(++count + "번째 시도: ");
			num = sc.nextInt();
			if (num > answer) {
				System.out.println("\t" + num + "보다 작습니다. (Down)");
			}
			else if (num < answer) {
				System.out.println("\t" + num + "보다 큽니다. (Up)");
			}
			else {
				System.out.println("\t정답입니다!! (" + answer + ")");
				break;
			}
		}
		System.out.println("** 프로그램 종료 **");
	}

}
