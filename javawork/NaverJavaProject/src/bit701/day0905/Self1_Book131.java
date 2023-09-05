package bit701.day0905;

import java.util.Scanner;

public class Self1_Book131 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int speed = 0;
		
		while (run) 
		{
			System.out.println("----------------------------");
			System.out.println("1. 증속 | 2. 감속 | 3. 중지");
			System.out.println("----------------------------");
			System.out.print("선택: ");
			
			String strNum = sc.nextLine();
			
			/*
			 * 숫자같은 타입은 == 연산자를 사용할 수 있으나,
			 * String과 같은 객체는 == 연산자를 사용할 수 없음.
			 * String이라면 equals 메소드를 활용해야 함.
			 */
			if (strNum.equals("1"))
			{
				speed++;
				System.out.println("현재 속도 = " + speed);
			} else if (strNum.equals("2"))
			{
				speed--;
				System.out.println("현재 속도 = " + speed);
			} else if (strNum.equals("3"))
			{
				run = false;
			}
		}
		
		System.out.println("프로그램 종료");
	}

}
