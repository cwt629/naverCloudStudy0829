package bit701.day0905;

import java.util.Scanner;

public class Ex1_JuminNo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		
		Exit:
		while (true) {
			System.out.println("주민번호를 입력하세요.");
			input = sc.nextLine();
			if (input.equalsIgnoreCase("Q")) break Exit; // q나 Q 입력시 프로그램 종료
			// 길이가 안맞는 경우
			if (input.length() != 14) {
				System.out.println("주민번호 길이가 올바르지 않습니다.");
				continue Exit;
			}
			
			String year = input.substring(0, 2), month = input.substring(2, 4), day = input.substring(4, 6);
			char identifier = input.charAt(7); // 성별이나 국적을 의미하는 번호
			
			String nationType = "확인불가", sexType = "확인불가";
			switch(identifier) {
			case '1': case '3':
				nationType = "내국인";
				sexType = "남성";
				break;
				
			case '2': case '4':
				nationType = "내국인";
				sexType = "여성";
				break;
				
			case '5':
				nationType = "외국인";
				sexType = "남성";
				break;
				
			case '6':
				nationType = "외국인";
				sexType = "여성";
				break;
			}
			
			// 출력
			System.out.println("당신의 정보입니다.");
			System.out.printf("* %s년 %s월 %s일생\n", year, month, day);
			System.out.println("* " + nationType);
			System.out.println("* " + sexType);
			System.out.println("=".repeat(30));
		}
		
		sc.close();
		System.out.println("프로그램을 종료합니다.");
	}

}
