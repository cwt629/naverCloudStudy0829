package bit701.day0831;

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
		
		System.out.printf("\n총금액 : %d 원", totalCost);
		
		// 수량이 5개 이상인 경우: 10% 할인된 최종 금액 출력
		if (productQty >= 5)
			System.out.printf("\n5개 이상 10프로 할인된 금액 : %d 원", totalCost * 9 / 10);
	}

}
