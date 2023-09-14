package bit701.day0914;

import java.util.Scanner;

public class Ex2_Exception {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			/*
			 * try~catch로 묶어주기
			 * ArithmeticException은 숫자2에서만 나오니까
			 * 사실 따로따로 묶어서 해도 되지만,
			 * 그래도 다중catch문으로 해주는 게 깔끔할 것 같다.
			 */
			try {
				System.out.println("숫자1 입력");
				int su1 = Integer.parseInt(sc.nextLine());
				if (su1 == 0)
					break;
				System.out.println("숫자2 입력");
				int su2 = Integer.parseInt(sc.nextLine());
				int div = su1 / su2;
				System.out.printf("%d 나누기 %d 는 %d입니다\n", su1, su2, div);
				System.out.println();
			} catch(NumberFormatException e) {
				System.out.println("문자가 입력되었어요: " + e.getMessage());
			} catch(ArithmeticException e) {
				System.out.println("두번째 숫자는 0이 아닌 값으로 입력해주세요: " + e.getMessage());
			} finally {
				// 예외 발생 여부에 상관없이 무조건 실행되는 영역
				System.out.println("** 무조건 실행시킬 코드를 넣는 곳!! **");
			}

		}
		System.out.println("** 정상 종료 **");
	}

}
