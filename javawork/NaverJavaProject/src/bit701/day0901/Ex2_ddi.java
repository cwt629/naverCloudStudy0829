package bit701.day0901;

import java.util.Scanner;

public class Ex2_ddi {

	public static void main(String[] args) {
		// 태어난 년도를 입력받아 띠를 구해보세요
		Scanner sc = new Scanner(System.in);
		
		System.out.println("태어난 년도는?");
		int year = sc.nextInt();
		
		// 12로 나눈 나머지를 구한다
		int rem = year % 12;
		
		// 띠를 구해보자(서기 1년은 닭띠, ... 12년은 원숭이띠)
		String ddi = rem == 0? "원숭이" : rem == 1? "닭" : rem == 2? "개"
				: rem == 3? "돼지" : rem == 4? "쥐" : rem == 5? "소"
				: rem == 6? "호랑이" : rem == 7? "토끼" : rem == 8? "용"
				: rem == 9? "뱀" : rem == 10? "말" : "양";
		
		System.out.println(year + "년생은 " + ddi + "띠입니다.");
	}

}
