package bit701.day0906;

import java.util.Scanner;

public class Ex12_ArraySearchName {

	public static void main(String[] args) {
		String []names = {"강호동", "유재석", "한채영", "이효리", "이승기",
				"강남길", "이민정", "이서진", "손미나", "유미리", "장원영"};
		/*
		 * [출력 예시]
		 * 검색할 성은? 이
		 * 		4:이효리
		 * 		5:이승기
		 * 		7:이민정
		 * 		8:이서진
		 * 		총 4명 
		 * 
		 * 검색할 성은? 박
		 * 		'박'씨성을 가진 멤버는 없습니다
		 * 
		 * 검색할 성은? 끝
		 * 		종료합니다
		 * 
		 * [변수]
		 * String searchSung
		 * int count
		 * boolean bFind
		 * 
		 * [활용 메소드]
		 * startsWith 메소드
		 */
		
		Scanner sc = new Scanner(System.in);
		String searchSung = "";
		int count = 0;
		boolean bFind = false;
		
		while (true) {
			// 초기화
			count = 0; bFind = false;
			
			System.out.print("검색할 성은? ");
			searchSung = sc.nextLine();
			
			// 끝 입력한 경우
			if (searchSung.equals("끝")) 
				break;
			
			// 해당 성을 가진 이름 세보기
			for (int i = 0; i < names.length; i++)
			{
				if (names[i].startsWith(searchSung))
				{
					bFind = true;
					System.out.println("\t" + (i + 1) + ": " + names[i]);
					count++;
				}
			}
			
			// 총 명수를 출력하거나, 발견하지 못한 경우 메세지 출력
			if (bFind)
				System.out.println("\t총 " + count + "명");
			else
				System.out.println("\t\"" + searchSung + "\"씨 성을 가진 멤버는 없습니다.");
			
			System.out.println();
		}
		
		System.out.println("\t종료합니다.");
	}

}
