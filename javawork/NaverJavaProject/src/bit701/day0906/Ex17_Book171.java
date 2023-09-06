package bit701.day0906;

public class Ex17_Book171 {

	public static void main(String[] args) {
//		test1(); // static method 호출
//		Ex17_Book171.test1(); // 자기 자신 안에 있는 static method는 클래스명 생략 가능
		
		int []scores;
		scores = new int[] {83, 90, 87};
		int sum1 = 0;
		for (int i = 0; i < scores.length; i++)
		{
			sum1 += scores[i];
		}
		System.out.println("총합: " + sum1);
		
		printItem(scores);
		
		System.out.println("=".repeat(30));
		printItem(new int[] {45, 67, 78, 89, 99, 100}); // 배열 만들어서 바로 인자로 넘기기도 가능
	}

//	public static void test1()
//	{
//		System.out.println("test1 메소드 호출");
//	}
	
	public static void printItem(int []scores) {
		// 매개변수가 참조하는 배열의 항목을 출력
		for (int i = 0; i < scores.length; i++)
		{
			System.out.println("score[" + i + "]: " + scores[i]);
		}
	}
}
