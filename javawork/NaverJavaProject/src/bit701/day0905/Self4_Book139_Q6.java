package bit701.day0905;

public class Self4_Book139_Q6 {

	public static void main(String[] args) {
		/*
		 * 별표를 다음과 같이 출력
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */
//		for (int i = 1; i <= 5; i++)
//		{
//			for (int j = 1; j <= i; j++)
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		/*
		 * 별표를 다음과 같이 출력
		 * *****
		 * ****
		 * ***
		 * **
		 * *
		 */
		
//		for (int i = 1; i <= 5; i++)
//		{
//			for (int j = i; j <= 5; j++)
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		/*
		 * 별표를 다음과 같이 출력
		 * 1****
		 * *2***
		 * **3**
		 * ***4*
		 * ****5
		 */
		for (int i = 1; i <= 5; i++)
		{
			for (int j = 1; j <= 5; j++)
			{
				if (i == j)
					System.out.print(i);
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}

}
