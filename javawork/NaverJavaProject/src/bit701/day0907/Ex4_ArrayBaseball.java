package bit701.day0907;

import java.util.Scanner;

public class Ex4_ArrayBaseball {

	public static void main(String[] args) {
		int []com = new int[3];
		int []user = new int[3];
		String strNum;
		Scanner sc = new Scanner(System.in);
		int ball, strike;

		// 1~9 사이의 중복되지 않은 숫자를 배열에 담는다
		for (int i = 0; i < com.length; i++)
		{
			com[i] = (int)(Math.random() * 9) + 1;
			for (int j = 0; j < i; j++)
			{
				if (com[i] == com[j])
				{
					i--;
					break;
				}
			}
		}
		// 정답(구현 이후 주석처리할 것)
		//System.out.printf("%d%d%d\n", com[0], com[1], com[2]);

		while(true)
		{
			System.out.print(">> ");
			strNum = sc.nextLine();

			// 종료
			if (strNum.equalsIgnoreCase("q")) {
				System.out.println("게임을 종료합니다");
				break;
			}

			// strNum의 각 숫자를 user 배열에 정수 형태로 넣기
			//user[0] = strNum.charAt(0); // 이는 문자 타입의 숫자를 받아옴! 그래서 아스키코드값이 들어간다
			user[0] = strNum.charAt(0) - '0'; // 0의 아스키코드값(48)을 빼줌으로써 숫자로 받아옴!
			user[1] = strNum.charAt(1) - '0';
			user[2] = strNum.charAt(2) - '0';
			//System.out.printf("%d,%d,%d\n", user[0], user[1], user[2]);

			/*
			 * user와 com을 비교하여 
			 * 숫자가 있지만 자리수가 안맞으면 ball 증가
			 * 숫자가 있고 자리수까지 맞으면 strike 증가
			 * strike이 3이면 정답이므로 "축하합니다. 정답입니다" 출력 후 종료
			 */
			ball = 0; strike = 0;
			for (int i = 0; i < com.length; i++)
			{
				for (int j = 0; j < user.length; j++)
				{
					if (com[i] == user[j])
					{
						if (i == j) strike++;
						else ball++;
						
						break;
					}
				}
			}
			
			System.out.println(strike + "스트라이크 " + ball + "볼");
			if (strike == 3)
			{
				System.out.println("** 축하합니다. 정답입니다!!!");
				break;
			}
		}
	}

}
