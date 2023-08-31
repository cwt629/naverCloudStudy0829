package bit701.day0831;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex7_Format {

	public static void main(String[] args) {
		// 패턴을 이용해서 다양하게 날짜와 시간을 출력해보자.
		Date date = new Date();
		
		// 패턴 1
		// MM:월 mm:분 EEE:요일(짧게, 한글은 일, 영어는 SUN) 
		// HH:24시간기준
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE"); 
		System.out.println(dateFormat1.format(date)); // 위 format을 받아와 출력한다
		
		// 패턴 2
		// a:오전/오후 EEEE:요일(길게, 한글은 일요일, 영어는 SUNDAY) hh:12시간기준
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss EEEE"); 
		System.out.println(dateFormat2.format(date)); // 위 format을 받아와 출력한다
		
		// 숫자를 format 양식에 맞게 출력하기
		int money = 4567890;
		
		NumberFormat numberFormat1 = NumberFormat.getInstance();
		System.out.println(numberFormat1.format(money)); // 4,567,890
		
		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance();
		System.out.println(numberFormat2.format(money)); // <해당국가 화폐단위>4,567,890
		
		double num = 456.12345;
		System.out.println(numberFormat1.format(num)); // 456.123 (세 자리까지만 나온다?)
		
		numberFormat1.setMaximumFractionDigits(1); // 소수점 최대 1자리까지만 출력
		System.out.println(numberFormat1.format(num));
	}

}
