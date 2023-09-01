package bit701.day0901;

import java.util.Scanner;

public class Ex6_ForExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * [문제 1]
		 * 숫자 n을 입력받은 후 1부터 n까지의 총 합계를 출력하시오
		 */
//		System.out.println("숫자를 입력하세요.");
//		int n = sc.nextInt();
//		
//		int total = 0;
//		for (int i = 1; i <= n; i++) total += i;
//		System.out.printf("합계는 %d입니다.", total);
		
		/*
		 * [문제 2]
		 * 구구단 숫자 2~9 사이의 숫자를 입력받은 후
		 * 범위를 벗어날 경우 "잘못 입력하여 종료합니다" 출력 후 종료
		 * 제대로 입력한 경우 해당 구구단 출력
		 * 
		 * [출력 예시]
		 * ** 5단 **
		 * 5 x 1 =  5
		 * 5 x 2 = 10
		 * .
		 * .
		 * 5 x 9 = 45
		 */
		
		System.out.println("구구단 숫자를 입력하세요. (2 ~ 9)");
		int num = sc.nextInt();
		
		// 예외처리
		if (num < 2 || num > 9) {
			System.out.println("잘못 입력하여 종료합니다.");
			return;
		}
		
		// 구구단 출력
		System.out.printf("\t** %d단 **\n", num);
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%9d x %d = %2d\n", num, i, num * i);
		}
	}

}
