package bit701.day0907;

import java.util.Scanner;

public class Ex3_ArrayBingo {

	public static void main(String[] args) {
		/*
		 * [문제]
		 * 3행 3열의 배열 선언 후
		 * 1~3 사이의 난수를 넣고
		 * 가로, 세로, 대각선으로 비교하여 같은 숫자가 나온 개수를 구한다
		 */
		
		Scanner sc = new Scanner(System.in);
		int [][]data = new int[3][3];
		int bingo; boolean isBingo = true;
		
		while (true)
		{
			// 초기화
			bingo = 0; isBingo = true;
			
			// 3행 3열에 1~3의 숫자 임의로 넣기
			for (int i = 0; i < data.length; i++) 
			{
				for (int j = 0; j < data[i].length; j++)
				{
					data[i][j] = (int)(Math.random() * 3) + 1;
				}
			}
			
			// 출력
			for (int i = 0; i < data.length; i++) 
			{
				for (int j = 0; j < data[i].length; j++)
				{
					System.out.printf("%3d", data[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
			// 빙고 계산(0이면 "꽝", 아닐 경우 "빙고: n개")
			// 1. 가로 계산
			for (int row = 0; row < data.length; row++)
			{
				isBingo = true;
				for (int col = 0; col < data[row].length - 1; col++)
				{
					if (data[row][col] != data[row][col + 1]) {
						isBingo = false;
						break;
					}
				}
				
				if (isBingo) bingo++;
			}
			
			// 2. 세로 계산
			for (int col = 0; col < data[0].length; col++)
			{
				isBingo = true;
				for (int row = 0; row < data.length - 1; row++)
				{
					if (data[row][col] != data[row + 1][col]) {
						isBingo = false;
						break;
					}
				}
				
				if (isBingo) bingo++;
			}
			
			// 3. 대각선(\)
			isBingo = true;
			for (int i = 0; i < data.length - 1; i++)
			{
				if (data[i][i] != data[i + 1][i + 1]) {
					isBingo = false;
					break;
				}
			}
			if (isBingo) bingo++;
			
			// 4. 대각선(/)
			isBingo = true;
			for (int i = 0; i < data.length - 1; i++)
			{
				if (data[i][data.length - i - 1] != data[i + 1][data.length - i - 2])
				{
					isBingo = false;
					break;
				}
			}
			if (isBingo) bingo++;
			
			// 빙고 결과 출력
			String result = (bingo > 0)? ("빙고: " + bingo + "개") : "꽝!";
			System.out.println(result);
			
			System.out.print("종료:q > ");
			String ans = sc.nextLine();
			if (ans.equalsIgnoreCase("q")) break;
			System.out.println("-".repeat(10));
		}
		System.out.println("** 빙고 게임 끝!! **");
	}

}
