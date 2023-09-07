package bit701.day0907;

import java.util.Scanner;

public class Ex1_Array {

	public static void main(String[] args) {
		System.out.println("배열 복습 예제");
		/*
		 * [문제]
		 * 처음에 인원수(count)를 입력받은 후
		 * 그 인원수만큼 names, kor, eng 배열 할당
		 * 그 후 인원수만큼
		 * 이름, 국어점수, 영어점수를 입력하면
		 * 아래와 같이 출력되도록 프로그램을 작성하세요.
		 * 
		 * [출력 예시]
		 * 번호  이름  국어  영어  총점  평균  
		 * -----------------------------------
		 * 1     김     89   90    179   89.5
		 * 2     이     100  100   200   100
		 */
		
		Scanner sc = new Scanner(System.in);
		int count;
		
		// 인원수 입력
		System.out.print("인원수를 입력해주세요 : ");
		count = Integer.parseInt(sc.nextLine());
		
		// 배열 할당
		// tip: 앞에 먼저 int[] kor처럼 선언하고, 이후에 kor = new int[count]과 같이 할당하기도 가능!
		String[] names = new String[count];
		int[] kor = new int[count];
		int[] eng = new int[count];
		int[] total = new int[count];
		double[] avg = new double[count];
		
		// 인원수만큼 이름, 국어점수, 영어점수 입력받기
		for (int i = 0; i < names.length; i++)
		{
			System.out.print(i + 1 + "번째 - 이름은? : ");
			names[i] = sc.nextLine();
			
			System.out.print(i + 1 + "번째 - 국어 성적은? : ");
			kor[i] = Integer.parseInt(sc.nextLine());
			
			System.out.print(i + 1 + "번째 - 영어 성적은? : ");
			eng[i] = Integer.parseInt(sc.nextLine());
			
			// 총점과 평균 구하기
			total[i] = kor[i] + eng[i];
			avg[i] = (double)total[i] / 2; // total[i] / 2.0 도 됨
		}
		
		// 출력
		// 헤더와 구분선 출력
		System.out.println("번호\t이름\t국어\t영어\t총점\t평균");
		System.out.println("-".repeat(50));
		
		// 각 학생 데이터 출력
		for (int i = 0; i < names.length; i++)
		{
			//System.out.printf("%d\t%s\t%d\t%d\t%d\t%f\n", i+1, names[i], kor[i], eng[i], total[i], avg[i]);
			System.out.println(i + 1 + "\t" + names[i] + "\t" + kor[i] + "\t" + eng[i] + "\t" + total[i] + "\t" + avg[i]);
		}
	}
}
