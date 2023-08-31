package bit701.day0831;

import java.util.Calendar;
import java.util.Date;

public class Ex5_Date {

	public static void main(String[] args) {
		// 자바에서 시간이나 날짜 출력하는 방법
		System.out.println("Date 클래스를 이용해서 시간과 날짜 구하기");
		Date date = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;
		int day = date.getDate();
		
		int hour = date.getHours();
		int minute = date.getMinutes();
		int second = date.getSeconds();
		
		// %2d : 두자리수. 남는 자리가 있으면 공백으로 채움 (두자리 넘어도 짤리진 않고 그대로 나오더라.)
		System.out.printf("현재 년도 : %d-%2d-%2d\n", year, month, day);
		// %02d : 두자리수. 남는 자리가 있으면 0으로 채움
		System.out.printf("현재 년도 : %d-%02d-%02d\n", year, month, day);
		System.out.printf("현재 시간 : %02d:%02d:%02d\n\n", hour, minute, second);
		
		System.out.println("Calendar 클래스를 이용해서 시간과 날짜 구하기");
		//Calendar cal = new Calendar(); // 오류: new로 만들 수 없음
		// Calendar 클래스는 public이 아니라 protected이기 때문에 생성자가 막혀있음!
		// 그래서 따로 쓸 수 있는 방법이 있는데, 쓰여 있는 바로는 getInstance() 메소드를 활용하는 것.
		// 링크: https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/Calendar.html
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR); // 인자에 field 값이 들어감. 이 부분도 위 링크 문서 참고
		month = cal.get(Calendar.MONTH) + 1; // 0~11의 값 반환 => 1을 더해줘야 현재 월이 잘 나옴
		day = cal.get(Calendar.DATE);
		System.out.printf("현재 년도 : %d-%02d-%02d\n\n", year, month, day);
		
		System.out.println("Date 클래스를 이용해서 요일 구하기");
		// 요일 구하기(Date 활용)
		int weekint = date.getDay(); // 0:일, 1:월, ... , 6:토
		System.out.println("요일숫자: " + weekint);
		
		String week = (weekint == 0)? "일" : (weekint == 1)? "월" : (weekint == 2)? "화" 
				: (weekint == 3)? "수" : (weekint == 4)? "목" : (weekint == 5)? "금" : "토" ;
		System.out.println("오늘은 " + week + "요일입니다.");
	}

}
