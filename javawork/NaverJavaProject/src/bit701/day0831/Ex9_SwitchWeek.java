package bit701.day0831;

import java.util.Scanner;

public class Ex9_SwitchWeek {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 년도와 월을 입력하면 며칠까지 있는지 출력해보자
		// 일단 해당 년도가 윤년인지 아닌지부터 판단해보자
		System.out.println("년도를 입력하세요(4자리 숫자)");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요(1~12)");
		int month = sc.nextInt();
		// 월을 잘못 입력한 경우는 종료한다
		if (month < 1 || month > 12) {
			System.out.println("월을 잘못 입력하셨어요");
			return;
		}

		System.out.printf("입력한 년도와 월 : %d년 %d월\n\n", year, month);
		int days = 0;
		boolean isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		if (isLeapYear) System.out.println("윤년이네"); // 조건에서 ==true 는 생략 가능. ==false는 !b 형태
		else System.out.println("평년이네");
		System.out.println();

		switch(month) {
		case 2:
			days = (isLeapYear)? 29 : 28; // 윤년인 경우 29일, 아닐 경우 평년이므로 28일
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 31;
		}
		
		System.out.printf("%d년 %d월은 %d일까지 있어요!!\n", year, month, days);
	}

}
