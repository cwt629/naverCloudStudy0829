package bit701.day0901;

import java.util.Scanner;

public class Ex7_ForExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean hasInputError = false;
		/*
		 * [문제]
		 * 구구단을 출력할 시작단과 끝단을 입력하여
		 * 그 단수들에 대해 구구단을 출력하자.
		 * 
		 * [예시]
		 * 구구단을 출력할 시작단 입력
		 * 4
		 * 구구단을 출력할 끝단 입력
		 * 6
		 * 
		 *     4단      5단      6단 - 단일 for문
		 *     
		 *    4x1= 4    5x1= 5    6x1= 6 - 다중 for문
		 *    4x2= 8    5x2=10    6x2=12
		 *    ...
		 */
		
		int start, end;
		System.out.print("구구단을 출력할 시작단 입력: ");
		start = sc.nextInt();
		System.out.print("구구단을 출력할 끝단 입력: ");
		end = sc.nextInt();
		
		// 예외처리
		if (start < 2 || start > 9) { 
			System.out.println("시작단은 2~9 사이의 정수여야 합니다.");
			hasInputError = true;
		}
		if (end < 2 || end > 9) {
			System.out.println("끝단은 2~9 사이의 정수여야 합니다.");
			hasInputError = true;
		}
		
		if (hasInputError) return;
		
		// start가 end보다 크면, 두 변수의 값을 바꿔보자(swap)
		if (start > end) {
			int temp = start;
			start = end;
			end = temp;
		}
		
		System.out.println();
		// "단" 부분 출력하기
		for (int i = start; i <= end; i++) {
			System.out.printf("\t  %d단  \t", i);
		}
		System.out.println("\n");
		// 구구단 부분 출력하기
		for (int mult = 1; mult <= 9; mult++)
		{
			for (int n = start; n <= end; n++)
			{
				System.out.printf("\t%dx%d=%2d\t", n, mult, n * mult);
			}
			System.out.println();
		}
	}

}
