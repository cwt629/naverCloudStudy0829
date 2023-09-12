package bit701.day0912;

import java.util.StringTokenizer;

public class Ex4_Split {

	public static void main(String[] args) {
		String str1 = "red,blue,green,orange,gray";
		// 문자열을 , 로 분리해서 배열에 담아보자
		String []strArray = str1.split(",");
		System.out.println("총 " + strArray.length + "개로 분리됨");
		
		for (int i = 0; i < strArray.length; i++)
		{
			System.out.println(i + ": " + strArray[i]);
		}
		System.out.println("-".repeat(20));
		
		String str2 = "sea.jpg"; 
		//String []str2Array = str2.split("."); // 분리가 안된다...! 하자가 많다
		//String []str2Array = str2.split("[.]"); // 이렇게 해야되네 ㄷㄷ
		String []str2Array = str2.split("\\."); // 얘도 되네 ㄷㄷ
		System.out.println(str2Array.length);
		System.out.println(str2Array[0]);
		System.out.println(str2Array[1]);
		
		String str3 = "red|green|yellow";
		String []str3Array = str3.split("\\|"); // 역슬래시 or []로 감싸서.
		System.out.println(str3Array.length);
		for (int i = 0; i < str3Array.length; i++)
		{
			System.out.println(i + ": " + str3Array[i]);
		}
		
		// 자바의 클래스를 이용해서 분리하기
		StringTokenizer st = new StringTokenizer(str1, ",");
		System.out.println("총 " + st.countTokens() + "개로 분리");
		while (st.hasMoreTokens()) // 다음 분리할 토큰이 있으면 true, 더 없으면 false
		{
			// countTokens는 length와 다르게, 다음 토큰 받으면서 하나씩 줄어든다.
			System.out.println("토큰 개수는 " + st.countTokens());
			System.out.println(st.nextToken());
		}
		System.out.println("-".repeat(20));
		
		StringTokenizer st2 = new StringTokenizer(str1, ",");
		/*
		 * 아래 출력 결과는 red, blue, green까지만 나온다.
		 * 이렇게 하면 어디가 문제일까?
		 * 
		 * countTokens()는 다음 토큰을 읽을 때마다 값이 1씩 감소한다.
		 */
//		for (int i = 0; i < st2.countTokens(); i++)
//		{
//			System.out.println(st2.nextToken());
//		}
		
		/*
		 * 그래서, 위처럼 for문을 쓰려면 다음과 같이
		 * 초기 countToken 값을 저장해놓고 써야한다.
		 */
		int count = st2.countTokens();
		for (int i = 0; i < count; i++)
		{
			System.out.println(st2.nextToken());
		}
	}

}
