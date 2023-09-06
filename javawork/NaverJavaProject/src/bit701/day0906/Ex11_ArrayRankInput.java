package bit701.day0906;

import java.util.Scanner;

public class Ex11_ArrayRankInput {

	public static void main(String[] args) {
		/*
		 * [문제]
		 * 총 4명의 이름과 점수를 입력하면
		 * 이름과 점수, 등수를 출력하는
		 * 프로그램을 작성하시오.
		 * 
		 * [조건]
		 * 점수가 0~100을 벗어날 경우, 다시 입력받으시오.
		 * 
		 * [출력 예시]
		 * 0번 이름: 송혜교
		 * 0번 점수: 99
		 * 
		 * 1번 이름: 강호동
		 * 1번 점수: 120
		 * 		다시 입력하세요
		 * 1번 이름: 강호동
		 * 1번 점수: 60
		 * ...
		 * 
		 *   번호  이름  점수  등수
		 *   ----------------------
		 *     1   송혜교 99    1
		 *     ...
		 */
		Scanner sc = new Scanner(System.in);
		String []names = new String[4];
		int []scores = new int[4];
		int []ranks = new int[4];
		
		for (int i = 0; i < scores.length; i++)
		{
			System.out.print(i + "번 이름: ");
			names[i] = sc.nextLine();
			
			System.out.print(i + "번 점수: ");
			scores[i] = Integer.parseInt(sc.nextLine());
			
			// 점수가 범위 밖인 경우
			if (scores[i] < 0 || scores[i] > 100) {
				System.out.println("\t점수는 0~100 범위여야 합니다.");
				i--;
				continue;
			}
		}
		
		// rank 구하기
		for (int i = 0; i < scores.length; i++)
		{
			ranks[i] = 1;
			for (int j = 0; j < scores.length; j++)
			{
				if (scores[i] < scores[j])
					ranks[i]++;
			}
		}
		
		// 출력
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("-".repeat(30));
		for (int i = 0; i < scores.length; i++)
		{
			System.out.println(i + 1 + "\t" + names[i] + "\t" + scores[i] + "\t" + ranks[i]);
		}
	}

}
