package bit701.day0904;

import java.util.Random;

public class Ex4_Random {

	public static void main(String[] args) {
		// new Random() 활용하기
		Random r = new Random();
		
		for (int i = 0; i < 5; i++)
		{
			int n = r.nextInt(10); // 0~9 사이의 난수 발생
			System.out.println(n);
		}
		
		System.out.println("=".repeat(30));
		
		for (int i = 0; i < 5; i++)
		{
			int n = r.nextInt(100) + 1; // 1~100 사이의 난수 발생
			System.out.println(n);
		}
		
		System.out.println("=".repeat(30));
		
		// 임의의 대문자가 나오게 하려면?
		for (int i = 0; i < 5; i++)
		{
			int n = r.nextInt(26) + 65; // 65~90 사이의 난수 발생
			System.out.println((char)n);
		}
		
		System.out.println("=".repeat(30));
	}

}
