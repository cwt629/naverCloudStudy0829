package bit701.day0906;

import java.util.Scanner;

public class Ex6_ArrayScoreInput {

	public static void main(String[] args) {
		/*
		 * [문제]
		 * score에 5개의 배열 할당 후 
		 * 키보드로 직접 점수를 입력하여 배열에 저장한 후
		 * 총점과 평균을 구하세요.
		 */
		Scanner sc = new Scanner(System.in);
		int []scores = new int[5];
		int scoreInput;
		int sum = 0;
		double avg = 0;
		
		// 점수 입력
		for (int i = 0; i < scores.length; i++) {
			System.out.print(i + "번 점수 입력: ");
			scoreInput = sc.nextInt();
			// 잘못된 입력(0~100 이외) 처리
			// 0보다 작거나 100보다 크면 "0~100 사이 점수로 입력 바람!" 출력 후 다시 입력
			// continue 이용해서 작성해보기
			if (scoreInput < 0 || scoreInput > 100) {
				System.out.println("\t0~100 사이 점수로 입력해주세요.");
				i--; // 미리 1 감소후 i++에서 1 증가되므로, 다시 제자리에 입력할 수 있게 됨
				continue; // i++로 이동
			}
			scores[i] = scoreInput;
		}
		
		// 총점 및 평균 구하기
		for (int point: scores) {
			sum += point;
		}
		avg = (double)sum / scores.length;
		
		// 출력
		System.out.println("입력한 점수들");
		for (int point: scores)
			System.out.printf("%5d", point);
		System.out.println("\n총점: " + sum);
		System.out.println("평균: " + avg);
		sc.close();
	}

}
