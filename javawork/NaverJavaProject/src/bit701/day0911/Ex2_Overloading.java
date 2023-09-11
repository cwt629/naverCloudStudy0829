package bit701.day0911;

/*
 * overloading: 이름이 같은 메소드 내에 인자가 다름
 * (타입이 다르거나, 인자 개수가 다르거나 등등)
 * 인자 변수명이 다르다고 오버로딩은 아니다!
 */

// Overloading Method : 메소드명은 반드시 같아야 하고, 인자는 반드시 달라야 한다
class Apple{
//	public static int sum(int a, int b)
//	{
//		System.out.println(1);
//		return a + b;
//	}
	
	public static int sum(int s1, int s2, int s3)
	{
		return s1 + s2 + s3;
	}
	
//	public static double sum(double a, double b)
//	{
//		return a + b;
//	}
	
	public static String sum(String a, String b)
	{
		return a + b;
	}
	
	public static String sum(String a, int b)
	{
		return a + b;
	}
	
	// ... Variable Arguments
	public static int sum(int...n) // n은 배열 타입! 숫자 개수 상관없이 int 배열타입으로 받는다
	{
		System.out.println(2);
		System.out.println("총 " + n.length);
		return 0;
	}
	
	
}


public class Ex2_Overloading {

	public static void main(String[] args) {
		System.out.println(Apple.sum(5,  7)); // varargs와 겹치는 메소드가 있으면, 2개 인자에 대해 따로 정의된거 먼저 함...심지어 double로 들어가기도 한다.
		System.out.println(Apple.sum("apple", "orange"));
		//System.out.println(Apple.sum(1.2, 4.5));
		//System.out.println(Apple.sum(100, "orange")); // 오류 : int+String 조합으로는 메소드 정의하지 않았음
		System.out.println(Apple.sum(100, 200, 300));
		//System.out.println(Apple.sum(100, 200, 300, 400)); // 오류 : int 4개 조합으로는 메소드 정의하지 않았음
		
	}

}
