package bit701.day0905;

import java.util.Scanner;

public class Self5_Book139_Q7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0;
		String command;
		
//		do {
//			int tempCash;
//			System.out.println("=".repeat(40));
//			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
//			System.out.println("=".repeat(40));
//			System.out.print("선택> ");
//			
//			command = sc.nextInt();
//			
//			switch(command) {
//			case 1:
//				System.out.print("예금액> ");
//				tempCash = sc.nextInt();
//				money += tempCash;
//				break;
//				
//			case 2:
//				System.out.print("출금액> ");
//				tempCash = sc.nextInt();
//				money -= tempCash;
//				break;
//				
//			case 3:
//				System.out.println("잔고> " + money);
//				break;
//				
//			case 4:
//				break;
//				
//			default:
//				System.out.println("1~4의 값을 입력해주세요.");
//			}
//			
//			System.out.println();
//		} while (command != 4);

		Exit: while (true) {
			String tempCash;
			System.out.println("=".repeat(40));
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("=".repeat(40));
			System.out.print("선택> ");
			
			command = sc.nextLine();
			
			switch(command) {
			case "1":
				System.out.print("예금액> ");
				tempCash = sc.nextLine();
				money += Integer.parseInt(tempCash);
				break;
				
			case "2":
				System.out.print("출금액> ");
				tempCash = sc.nextLine();
				money -= Integer.parseInt(tempCash);
				break;
				
			case "3":
				System.out.println("잔고> " + money);
				break;
				
			case "4":
				break Exit;
				
			default:
				System.out.println("1~4의 값을 입력해주세요.");
			}
			
			System.out.println();
		}
		
		sc.close();
		System.out.println();
		System.out.println("프로그램 종료");
	}

}
