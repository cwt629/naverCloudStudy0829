package bit701.day0904;

import java.util.Scanner;

public class Ex6_RandomWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer, count, num;
		
		Exit:
		while (true) {
			answer = (int)(Math.random() * 100) + 1;
			count = 0;
			
			while (true)
			{
				System.out.print(++count + "번째 시도: ");
				num = Integer.parseInt(sc.nextLine()); // nextInt로 받을 경우, 아래에서 nextLine에 엔터가 들어가며 문제 발생!
				if (num > answer)
					System.out.println("\t" + num + "보다 작습니다. (Down)");
				else if (num < answer)
					System.out.println("\t" + num + "보다 큽니다. (Up)");
				else {
					System.out.println("\t**정답입니다!! (" + answer + ")");
					// 계속할지 묻는다
					System.out.println("계속 하려면 y를 입력해주세요. y가 아닐 경우는 게임을 종료합니다.");
					String ans = sc.nextLine();
					if (ans.equalsIgnoreCase("y")) // 대소문자 상관없이 철자만 맞으면 true
					{
						System.out.println("새로운 난수가 발생되었습니다.");
						continue Exit; // 바깥쪽 while문의 조건식으로 이동한다
					} else {
						break Exit; // 2개의 while문을 모두 빠져나간다
					}
				}
				
			}
		}
		
		System.out.println("** 프로그램 종료 **");
	}

}
