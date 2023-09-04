package bit701.day0904;

public class Ex1_While {

	public static void main(String[] args) {
		/*
		 * 반복문에는 for, while, do~while 3가지가 있다.
		 * for문은 주로 반복횟수가 정해져 있는 경우 많이 사용
		 * while이나 do~while은 반복횟수가 정해져 있지 않은 경우에 많이 사용
		 * 
		 * while과 do~while의 차이는
		 * 조건을 먼저 주느냐, 나중에 주느냐(선조건, 후조건) 차이임.
		 */
		
		int a = 65; // 'A'의 ascii code
		while(a <= 90) // 조건이 참인동안 실행. 91이 되면 빠져나간다
		{
//			System.out.print((char)a);
//			a++;
			
			// 위 두줄을 한줄로 줄이려면?
			System.out.print((char)a++);
		}
		System.out.println();
		System.out.println("빠져나온 후의 a값: " + a);
		
		a = 65;
		while (true) 
		{
			System.out.print((char)a++);
			if (a > 90) {
				break;
			}
		}
		System.out.println();
		
		a = 65;
		do {
			System.out.print((char)a++);
		} while (a <= 90); // 조건 뒤에 반드시 ; 붙여야 함.
		
		// while문과 do~while문의 차이 확인
		int n = 10;
//		while (n < 10) // 조건이 거짓이면 한번도 반복 안함
//		{
//			System.out.println(n--);
//		}
		
		// do~while은 일단 한번은 무조건 실행한다.
		do {
			System.out.println(n--);
			if (n == 0) break;
		} while(n < 10);
	}

}
