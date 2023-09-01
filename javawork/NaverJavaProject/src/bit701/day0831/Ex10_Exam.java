package bit701.day0831;

import java.text.NumberFormat;
import java.util.Scanner;

public class Ex10_Exam {

	public static void main(String[] args) {
		/*
		 * [문제]
		 * 상품명과 수량, 단가를 각각 입력받고
		 * 총 금액을 출력하시오.
		 * 그리고 수량이 5개 이상일 경우에는
		 * 10프로 할인된 최종 금액도 출력해주세요.
		 * 
		 * [예시]
		 * 상품명 : 딸기
		 * 수량 : 6
		 * 단가 : 1000
		 * 
		 * 총금액 : 6000 원
		 * 5개 이상 10프로 할인된 금액 : 5400원
		 */
		
		Scanner sc = new Scanner(System.in);
		// 각각 입력받기
		System.out.print("상품명 : ");
		String productName = sc.nextLine();
		
		System.out.print("수량 : ");
		//int productQty = Integer.parseInt(sc.nextLine());
		int productQty = sc.nextInt();
		
		System.out.print("단가 : ");
		//int productCost = Integer.parseInt(sc.nextLine());
		int productCost = sc.nextInt();
		
		// 총 금액 계산
		int totalCost = productCost * productQty;
		
		System.out.printf("\n총금액 : %d 원\n", totalCost);
		
		// 수량이 5개 이상인 경우: 10% 할인된 최종 금액 출력
		// 주의점: printf 내에서 %를 출력하고 싶으면 %% 이라고 입력해줘야 함. % 자체에 의미가 있기 때문이다.
		// %를 n번 연속으로 쓰고싶으면 2n개 써야함...ㅋㅋㅋ
		if (productQty >= 5)
			System.out.printf("5개 이상 10%%%%%%%%%% 할인된 금액 : %d 원\n", totalCost * 9 / 10);
		
		// 추가: number format을 이용해 액수 출력해보기
		System.out.println();
		NumberFormat moneyFormat = NumberFormat.getInstance();
		System.out.printf("총금액(with format) : %s 원\n", moneyFormat.format(totalCost));
		if (productQty >= 5)
			System.out.printf("5개 이상 10%% 할인된 금액(with format) : %s 원\n", moneyFormat.format(totalCost * 9 / 10));
		
		
		
		/*
		 * 선언 - 입력 - 계산 - 출력 순서로 코드를 작성해보자. C언어 했듯이.
		 * 
		 * 예를 들어 선언부에 Scanner, NumberFormat, 상품명, 수량, 단가에 해당하는 변수를 모두 선언해주는 것!
		 */
	}

}
