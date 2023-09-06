package bit701.day0906;

public class Ex14_ArrayStringSort {

	public static void main(String[] args) {
		String []names = {"한가인", "강호동", "강호남", "Candy", "손미나"};
		
		/*
		 * 참고: 정렬을 간단히 하려면
		 * Arrays라는 클래스를 활용할 수도 있다.
		 */
		
		// Selection Sort - 문자열 비교 시
		for (int i = 0; i < names.length - 1; i++) 
		{
			for (int j = i + 1; j < names.length; j++)
			{
				// a.compareTo(b) : a가 b보다 클경우 무조건 양수 나옴
				if (names[i].compareTo(names[j]) > 0) // 오름차순 정렬
				{
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		
		// 출력
		for (String s:names)
			System.out.println(s);
	}

}
