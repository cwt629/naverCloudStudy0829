package bit701.day0830;

/* 실행 방법
 * 1. 해당 파일 화면상에 우클릭 - Run As - Java application
 * 2. 메뉴에 Run - Run As - Java application
 * 3. ctrl + F11
 * */

// 선택 주석은 VSCode와 동일: Ctrl + /
// Ctrl + Shift + / (해제는 슬래시 대신 역슬래시)도 가능은 한데, 좀 별로다.

/* 꿀팁
 * 1. 드래그 영역을 아래나 위쪽에 바로 복붙하고 싶으면
 * Ctrl + Alt + 아래/위 방향키
 * 
 * 2. 실행 취소는 Ctrl + Z 이지만,
 * 그 실행취소를 취소하고 싶으면
 * Ctrl + Y
 * 
 * */

public class DataEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// syso 쓰고 ctrl+space 누르면 출력문 자동완성
		System.out.print("apple\t"); // print는 줄바꿈 없음, println은 줄바꿈 포함
		System.out.print("banana\t");
		System.out.println("orange\n");
		
		// printf: 변환기호에 의한 출력, 정수:%d 실수:%f 문자:%c 문자열:%s
		// \n:줄넘김 \t:다음탭위치로이동
		int age = 23;
		double weight = 567.712;
		char blood = 'A';
		String name = "캐서린";
		System.out.printf("이름:%s\n\n", name);
		System.out.printf("나이:%d세\n\n", age);
		System.out.printf("몸무게:%fKg\n", weight); // %f : 소수점아래 6자리까지 출력
		System.out.printf("몸무게:%5.1fKg\n", weight); // %5.1f : 전체자리수 5, 소수점자리수 1 => 전체자리수가 실제전체수보다 크면 그만큼 공백
		System.out.printf("혈액형:%c형\n", blood);
		System.out.println("==================================");
		System.out.printf("이름:%s\n혈액형:%c형\n나이:%d세\n", name, blood, age);
	}

}
