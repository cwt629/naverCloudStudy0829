package bit701.day0830;

public class ExamEx8 {

	public static void main(String[] args) {
		// money 변수에 args[0] 값을 대입후(급여:백만단위 ex.5674321)
		/*
		 * [출력]
		 * money : 5674321 원
		 * 만원짜리 567장
		 * 천원짜리 4장
		 * 백원짜리 3개
		 * 십원짜리 2개
		 * 일원짜리 1개
		 * 
		 * [조건]
		 * 산술연산자를 사용해서 출력해보세요.
		 */
		
		int money = Integer.parseInt(args[0]); // 문자열을 정수로 변환
		System.out.printf("money : %d 원\n", money);
		System.out.printf("만원짜리 %d장\n", money / 10000);
		System.out.printf("천원짜리 %d장\n", (money % 10000) / 1000);
		System.out.printf("백원짜리 %d개\n", (money % 1000) / 100);
		System.out.printf("십원짜리 %d개\n", (money % 100) / 10);
		System.out.printf("일원짜리 %d개\n", money % 10);
	}

}
